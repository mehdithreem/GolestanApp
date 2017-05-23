package com.golestan.app.domain.Student;

import com.golestan.app.domain.EducationalMajor.EducationalMajor;
import com.golestan.app.domain.Person.Character;
import com.golestan.app.domain.Person.Individual;
import com.golestan.app.domain.SemesterIdentifier;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by nahal on 5/19/2017 AD.
 */
@Entity
@Table(name = "STUDENT")
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public class Student extends Character {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @Embedded
    private EducationalMajor educationalMajor;

    @Embedded
    private GraduatedMatchForm graduatedMatchingForm;

    @ElementCollection
    private Map<SemesterIdentifier, SemesterStatus> semesterIdentifierCourseGetterMap;

    @Column( name = "ID_NUMBER" , unique = true)
    private String studentNumber;

    public Student(Individual ind, String studentNumber, EducationalMajor educationalMajor) {
        this.educationalMajor = educationalMajor;
        this.graduatedMatchingForm = null;
        this.studentNumber = studentNumber;
        this.semesterIdentifierCourseGetterMap = new HashMap<SemesterIdentifier, SemesterStatus>();
        this.setIndividual(ind);
    }

    protected Student() {
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public GraduatedMatchForm getGraduatedMatchingForm() {
        return graduatedMatchingForm;
    }

    public void setGraduatedMatchingForm(GraduatedMatchForm graduatedMatchingForm) {
        this.graduatedMatchingForm = graduatedMatchingForm;
    }

    public EducationalMajor getEducationalMajor() {
        return educationalMajor;
    }

    public void setEducationalMajor(EducationalMajor educationalMajor) {
        this.educationalMajor = educationalMajor;
    }

    public Map<SemesterIdentifier, SemesterStatus> getSemesterIdentifierCourseGetterMap() {
        return semesterIdentifierCourseGetterMap;
    }

    public void setSemesterIdentifierCourseGetterMap(Map<SemesterIdentifier, SemesterStatus> semesterIdentifierCourseGetterMap) {
        this.semesterIdentifierCourseGetterMap = semesterIdentifierCourseGetterMap;
    }

    public void addSemesterStatus(SemesterStatus semstat) {
        this.semesterIdentifierCourseGetterMap.put(semstat.getSemesterIdentifier(), semstat);
    }
}
