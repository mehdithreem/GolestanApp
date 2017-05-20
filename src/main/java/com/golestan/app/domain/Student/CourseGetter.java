package com.golestan.app.domain.Student;

import com.golestan.app.domain.Condition;

import javax.persistence.*;
import java.util.List;

/**
 * Created by nahal on 5/19/2017 AD.
 */
@Entity
@Table(name="COURSE_GETTER")
public class CourseGetter {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "GPA")
    private int gpa;

    @Column(name = "STUDENT_FULL_NAME")
    private String studentFullName;

    @Column(name = "STUDENT_NUMBER")
    private String studentNumber;

    @OneToMany(fetch = FetchType.EAGER)
    private List<License> licenses;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Condition> conditions;

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getGpa() {
        return gpa;
    }

    public void setGpa(int gpa) {
        this.gpa = gpa;
    }

    public List<License> getLicenses() {
        return licenses;
    }

    public void setLicenses(List<License> licenses) {
        this.licenses = licenses;
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
}
