package com.golestan.app.domain.AttendedCourse;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by nahal on 5/20/2017 AD.
 */

@Entity
@Table(name = "AttendedCourse")
abstract public class AttendedCourse {

    @Column( name = "STATUS")
    private String status;

    @Column( name = "MARK")
    private float mark;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }
}
