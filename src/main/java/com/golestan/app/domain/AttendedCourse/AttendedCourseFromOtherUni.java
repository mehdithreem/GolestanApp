package com.golestan.app.domain.AttendedCourse;

import com.golestan.app.domain.EducationalTopics.CourseType;

import javax.persistence.*;

/**
 * Created by nahal on 5/20/2017 AD.
 */

@Entity
@DiscriminatorValue("FROM_OTHER_UNI")
public class AttendedCourseFromOtherUni extends AttendedCourse{

    @Column(name = "COURSE_NAME")
    private String courseName;

    @Column(name = "COURSE_UNIT")
    private Integer courseUnit;

    @Enumerated(EnumType.STRING)
    @Column(name = "COURSE_TYPE")
    private CourseType courseType;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCourseUnit() {
        return courseUnit;
    }

    public void setCourseUnit(Integer courseUnit) {
        this.courseUnit = courseUnit;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }
}
