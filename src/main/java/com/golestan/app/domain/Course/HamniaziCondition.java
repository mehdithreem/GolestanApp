package com.golestan.app.domain.Course;

import com.golestan.app.domain.Condition;
import com.golestan.app.domain.CourseOffer.CourseOffer;
import com.golestan.app.domain.Student.Student;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Created by mehdithreem on 5/20/2017 AD.
 */

@Entity
@DiscriminatorValue("HAMNIAZI")
public class HamniaziCondition extends Condition {
    @OneToOne
    private Course hamniaz;

    public HamniaziCondition(String title, Course hamniaz) {
        super(title);
        this.hamniaz = hamniaz;
    }

    public boolean is_justify(Student student, CourseOffer courseOffer) {
        return false;
    }
}
