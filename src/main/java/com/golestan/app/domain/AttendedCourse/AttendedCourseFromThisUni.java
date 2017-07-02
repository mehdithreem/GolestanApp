package com.golestan.app.domain.AttendedCourse;

import com.golestan.app.domain.CourseOffer.CourseOffer;

import javax.persistence.*;

/**
 * Created by nahal on 5/20/2017 AD.
 */

@Entity
@DiscriminatorValue("FROM_THIS_UNI")
public class AttendedCourseFromThisUni extends AttendedCourse {


    @ManyToOne(fetch = FetchType.EAGER)
    private CourseOffer courseOffer;

    public AttendedCourseFromThisUni(String studentFullName, String studentNumber, CourseOffer courseOffer) {
        super( studentFullName, studentNumber);
        this.courseOffer = courseOffer;
    }

    protected AttendedCourseFromThisUni() {
        super();
    }

    public Integer getCourseUniqueId() {
        return courseOffer.getCourse().getCourseUniqueId();
    }

    public String getCourseName() {
        return courseOffer.getCourse().getName();
    }

    public CourseOffer getCourseOffer() {
        return courseOffer;
    }

    public void setCourseOffer(CourseOffer courseOffer) {
        this.courseOffer = courseOffer;
    }
}
