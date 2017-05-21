package com.golestan.app.domain.CourseOffer;

import com.golestan.app.domain.Condition;
import com.golestan.app.domain.Student.Student;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by nahal on 5/20/2017 AD.
 */
@Entity
@DiscriminatorValue("UNI_ENTRY_CONDITION")
public class UniEntryCondition extends Condition{

    public UniEntryCondition(String title) {
        super(title);
    }

    protected UniEntryCondition() {
    }

    public boolean is_justify(Student student) {
        return false;
    }
}
