package com.golestan.app.domain.Course;

import com.golestan.app.domain.Condition;
import com.golestan.app.domain.Student.Student;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by mehdithreem on 5/20/2017 AD.
 */

@Entity
@DiscriminatorValue("PISHNIAZI")
public class PishniaziCondition extends Condition {
    @Column(name="PISHNIAZ")
    private Course pishniaz;

    public PishniaziCondition(String title, Course pishniaz) {
        super(title);
        this.pishniaz = pishniaz;
    }

    public boolean is_justify(Student student) {
        return false;
    }
}
