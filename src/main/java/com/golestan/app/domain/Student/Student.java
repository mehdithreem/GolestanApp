package com.golestan.app.domain.Student;

import com.golestan.app.domain.EducationalMajor.EducationalMajor;
import com.golestan.app.domain.Semester;
import com.golestan.app.domain.SemesterIdentifier;

import javax.persistence.*;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by nahal on 5/19/2017 AD.
 */
@Entity
@Table(name = "STUDENT")
public class Student {

    @Id
    @Column( name = "STUDENT_NUMBER")
    private String studentNumber;

    @Embedded
    private EducationalMajor educationalMajor;

    @Embedded
    private GraduatedMatchForm graduatedMatchingForm;

    @ElementCollection
    private Map<SemesterIdentifier, CourseGetter> semesterIdentifierCourseGetterMap;

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

    public Map<SemesterIdentifier, CourseGetter> getSemesterIdentifierCourseGetterMap() {
        return semesterIdentifierCourseGetterMap;
    }

    public void setSemesterIdentifierCourseGetterMap(Map<SemesterIdentifier, CourseGetter> semesterIdentifierCourseGetterMap) {
        this.semesterIdentifierCourseGetterMap = semesterIdentifierCourseGetterMap;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }
}
