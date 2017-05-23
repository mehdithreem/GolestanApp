package com.golestan.app.domain.AttendanceConditions;

import com.golestan.app.domain.Condition;
import com.golestan.app.domain.CourseOffer.CourseOffer;
import com.golestan.app.domain.Student.Student;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by nahal on 5/20/2017 AD.
 */
//@Entity
//@DiscriminatorValue("EDUCATIONAL_TOPICS_MATCH_CONDITION")
public class EducationalTopicsMatchCondition extends Condition{

    public EducationalTopicsMatchCondition(String title) {
        super(title);
    }

    public boolean is_justify(Student studen, CourseOffer courseOffer) {
        return true;
    }

}
