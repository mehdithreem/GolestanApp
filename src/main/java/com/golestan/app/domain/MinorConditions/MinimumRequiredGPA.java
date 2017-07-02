package com.golestan.app.domain.MinorConditions;

import com.golestan.app.domain.Condition;
import com.golestan.app.domain.CourseOffer.CourseOffer;
import com.golestan.app.domain.Student.Student;

/**
 * Created by mehdithreem on 7/2/2017 AD.
 */
public class MinimumRequiredGPA extends Condition{

    public MinimumRequiredGPA(String title) {
        super(title);
    }

    public boolean is_justify(Student student, CourseOffer courseOffer) {
        return true;
    }
}
