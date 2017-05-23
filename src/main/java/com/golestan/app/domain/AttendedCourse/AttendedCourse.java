package com.golestan.app.domain.AttendedCourse;

import com.golestan.app.domain.Condition;

import javax.persistence.*;
import java.util.List;

/**
 * Created by nahal on 5/20/2017 AD.
 */

@Entity
@Table(name = "AttendedCourse")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",discriminatorType= DiscriminatorType.STRING)
abstract public class AttendedCourse {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;

    @Column( name = "STATUS")
    private String status;

    @Column( name = "MARK")
    private float mark;

    @Column( name = "STUDENT_FULL_NAME")
    private String studentFullName;

    @Column( name = "STUDENT_NUMBER")
    private String studentNumber;

    protected AttendedCourse(String studentFullName, String studentNumber) {
        this.status = "اخذ شده";
        this.mark = 0;
        this.studentFullName = studentFullName;
        this.studentNumber = studentNumber;
    }

    protected AttendedCourse() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentFullName() {
        return studentFullName;
    }

    public void setStudentFullName(String studentFullName) {
        this.studentFullName = studentFullName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

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

    public abstract Integer getCourseUniqueId();
}
