package com.golestan.app.domain;

import com.golestan.app.domain.Student.Student;

import java.util.Date;

/**
 * Created by nahal on 5/20/2017 AD.
 */

public abstract class Policy {

    private Date duration;

    private String name;

    abstract boolean is_justify(Student student);

}
