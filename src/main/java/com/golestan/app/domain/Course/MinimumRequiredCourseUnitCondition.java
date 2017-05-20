package com.golestan.app.domain.Course;

import com.golestan.app.domain.Condition;
import com.golestan.app.domain.Student.Student;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by mehdithreem on 5/20/2017 AD.
 */
@Entity
@DiscriminatorValue("MIN_REQUIRED_COURSE_CONDITION")
public class MinimumRequiredCourseUnitCondition extends Condition{

    public MinimumRequiredCourseUnitCondition(String title) {
        super(title);
    }

    public boolean is_justify(Student student) {
        return false;
    }
}
