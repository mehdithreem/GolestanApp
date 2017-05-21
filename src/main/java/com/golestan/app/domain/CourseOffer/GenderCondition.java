package com.golestan.app.domain.CourseOffer;

import com.golestan.app.domain.Condition;
import com.golestan.app.domain.Student.Student;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by nahal on 5/20/2017 AD.
 */
@Entity
@DiscriminatorValue("GENDER_CONDITION")

public class GenderCondition extends Condition{

    protected GenderCondition() {}

    public GenderCondition(String title) {
        super(title);
    }

    public boolean is_justify(Student student) {
        return false;
    }
}
