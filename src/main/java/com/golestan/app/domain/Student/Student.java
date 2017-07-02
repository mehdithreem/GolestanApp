package com.golestan.app.domain.Student;

import com.golestan.app.data.Student.StudentRepository;
import com.golestan.app.domain.AttendedCourse.AttendedCourse;
import com.golestan.app.domain.CourseOffer.CourseOffer;
import com.golestan.app.domain.EducationalMajor.EducationalMajor;
import com.golestan.app.domain.MinorConditions.MinorConditions;
import com.golestan.app.domain.Person.Character;
import com.golestan.app.domain.Person.Individual;
import com.golestan.app.domain.SemesterIdentifier;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    @ManyToOne( fetch = FetchType.EAGER )
    private EducationalMajor educationalMajor;

    @ManyToOne( fetch = FetchType.EAGER )
    private EducationalMajor educationalMinor;

    @ElementCollection
    private Map<SemesterIdentifier, SemesterStatus> semesterIdentifierCourseGetterMap;

    @Column( name = "ID_NUMBER" , unique = true)
    private String studentNumber;

    public Student(Individual ind, String studentNumber, EducationalMajor educationalMajor) {
        this.educationalMajor = educationalMajor;
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

    public void registerCourseOffer(CourseOffer courseOffer, SemesterIdentifier semesterIdentifier) {
        SemesterStatus semesterStatus = (this.getSemesterIdentifierCourseGetterMap()).get(semesterIdentifier);

        semesterStatus.register(courseOffer);

        StudentRepository.getRepository().updateAttendedCourses(semesterStatus);
    }

    public void createLicense(License license, SemesterIdentifier semesterIdentifier) {
        SemesterStatus semesterStatus = (this.getSemesterIdentifierCourseGetterMap()).get(semesterIdentifier);
        semesterStatus.addLicense(license);
        StudentRepository.getRepository().createLicense(semesterStatus, license);
    }

    public List<AttendedCourse> getAttendedCourses(){
        List<AttendedCourse> res =  new ArrayList<AttendedCourse>();
        for (SemesterIdentifier semester : semesterIdentifierCourseGetterMap.keySet()){
            res.addAll(semesterIdentifierCourseGetterMap.get(semester).getAttendedCourses());
        }
        return res;
    }

    public List<AttendedCourse> getAttendedCourses(SemesterIdentifier semesterIdentifier) {
        return semesterIdentifierCourseGetterMap.get(semesterIdentifier).getAttendedCourses();
    }

    public EducationalMajor getEducationalMinor() {
        return educationalMinor;
    }

    public void setEducationalMinor(EducationalMajor educationalMinor) {
        this.educationalMinor = educationalMinor;
    }

    public boolean addMinor(EducationalMajor educationalMinor) {
        if (MinorConditions.getInstance().isMojaz(this)) {
            setEducationalMinor(educationalMinor);
            return true;
        }
        return false;
    }
}
