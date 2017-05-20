package com.golestan.app.domain.AttendedCourse;

import com.golestan.app.domain.CourseOffer.CourseOffer;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by nahal on 5/20/2017 AD.
 */

@Entity
@DiscriminatorValue("FROM_THIS_UNI")
public class AttendedCourseFromThisUni extends AttendedCourse {

    @ManyToOne
    private CourseOffer courseOffer;

    public CourseOffer getCourseOffer() {
        return courseOffer;
    }

    public void setCourseOffer(CourseOffer courseOffer) {
        this.courseOffer = courseOffer;
    }
}
