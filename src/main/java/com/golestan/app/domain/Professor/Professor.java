package com.golestan.app.domain.Professor;

import com.golestan.app.domain.SemesterIdentifier;

import javax.persistence.*;
import java.util.Map;

/**
 * Created by nahal on 5/19/2017 AD.
 */

@Entity
@Table(name = "PROFESSOR")
public class Professor {

    @ElementCollection
    private Map<SemesterIdentifier, CourseManager> semesterCourseManagerMap;

    @Id
    @Column( name = "ID_NUMBER")
    private String professorNumber;

    public String getNumber() {
        return professorNumber;
    }

    public void setProfessorNumber(String professorNumber) {
        this.professorNumber = professorNumber;
    }

    public Map<SemesterIdentifier, CourseManager> getSemesterCourseManagerMap() {
        return semesterCourseManagerMap;
    }

    public void setSemesterCourseManagerMap(Map<SemesterIdentifier, CourseManager> semesterCourseManagerMap) {
        this.semesterCourseManagerMap = semesterCourseManagerMap;
    }
}

