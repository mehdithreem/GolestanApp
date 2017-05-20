package com.golestan.app.domain.Professor;

import com.golestan.app.domain.Semester;
import com.golestan.app.domain.SemesterIdentifier;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Map;

/**
 * Created by nahal on 5/19/2017 AD.
 */

@Entity
@Table(name = "PROFESSOR")
public class Professor {

    @ElementCollection
    private Map<SemesterIdentifier, CourseManager> semesterCourseManagerMap;

    public Map<SemesterIdentifier, CourseManager> getSemesterCourseManagerMap() {
        return semesterCourseManagerMap;
    }

    public void setSemesterCourseManagerMap(Map<SemesterIdentifier, CourseManager> semesterCourseManagerMap) {
        this.semesterCourseManagerMap = semesterCourseManagerMap;
    }
}

