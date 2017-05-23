package com.golestan.app.domain.Student;

import com.golestan.app.domain.EducationalMajor.EducationalMajor;
import com.golestan.app.domain.SemesterIdentifier;

import javax.persistence.*;
import java.util.Map;

/**
 * Created by nahal on 5/19/2017 AD.
 */
@Entity
@Table(name = "STUDENT")
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public class Student {
    @Embedded
    private EducationalMajor educationalMajor;

    @Embedded
    private GraduatedMatchForm graduatedMatchingForm;

    @ElementCollection
    private Map<SemesterIdentifier, SemesterStatus> semesterIdentifierCourseGetterMap;

    @Id
    @Column( name = "ID_NUMBER")
    private String studentNumber;

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
}
