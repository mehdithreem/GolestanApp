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

    @Column(name = "CORR_COURSE_UNIQUE_ID")
    private Integer correspondingCourseUniqueId;

    public AttendedCourseFromOtherUni(String studentFullName, String studentNumber, String courseName, Integer courseUnit, CourseType courseType) {
        super(studentFullName, studentNumber);
        this.courseUnit = courseUnit;
        this.courseName = courseName;
        this.courseType = courseType;
        this.correspondingCourseUniqueId = -1;
    }

    protected AttendedCourseFromOtherUni() {
        super();
    }

    public Integer getCourseUniqueId() {
        return correspondingCourseUniqueId;
    }

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

    public Integer getCorrespondingCourseUniqueId() {
        return correspondingCourseUniqueId;
    }

    public void setCorrespondingCourseUniqueId(Integer correspondingCourseUniqueId) {
        this.correspondingCourseUniqueId = correspondingCourseUniqueId;
    }


}
