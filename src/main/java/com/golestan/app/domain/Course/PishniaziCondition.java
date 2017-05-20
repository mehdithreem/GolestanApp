package com.golestan.app.domain.Course;

import com.golestan.app.domain.Condition;
import com.golestan.app.domain.Student.Student;

/**
 * Created by mehdithreem on 5/20/2017 AD.
 */

@Entity
@DiscriminatorValue("PISHNIAZI")
public class PishniaziCondition extends Condition {
    PishniaziCondition(String title) {
        super(title);
    }

    public boolean is_justify(Student student) {
        return false;
    }
}
