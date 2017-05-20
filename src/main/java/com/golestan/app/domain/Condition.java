package com.golestan.app.domain;

import com.golestan.app.domain.Student.Student;

import java.util.Date;

/**
 * Created by nahal on 5/20/2017 AD.
 */

public abstract class Condition {
    private Date duration;
    private String title;

    Condition(String title) {
        this.title = title;
    }

    public abstract boolean test(Student student);
}
