package com.golestan.app.domain.Professor;

import com.golestan.app.domain.Person.Character;
import com.golestan.app.domain.SemesterIdentifier;

import javax.persistence.*;
import java.util.Map;

/**
 * Created by nahal on 5/19/2017 AD.
 */

@Entity
@Table(name = "PROFESSOR")
public class Professor extends Character{

    @ElementCollection
    private Map<SemesterIdentifier, CourseManager> semesterCourseManagerMap;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Map<SemesterIdentifier, CourseManager> getSemesterCourseManagerMap() {
        return semesterCourseManagerMap;
    }

    public void setSemesterCourseManagerMap(Map<SemesterIdentifier, CourseManager> semesterCourseManagerMap) {
        this.semesterCourseManagerMap = semesterCourseManagerMap;
    }
}

