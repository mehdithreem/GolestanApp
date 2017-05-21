package com.golestan.app.domain.CourseOffer;

import com.golestan.app.domain.AttendedCourse.AttendedCourse;
import com.golestan.app.domain.AttendedCourse.AttendedCourseFromThisUni;
import com.golestan.app.domain.Condition;
import com.golestan.app.domain.Course.Course;
import com.golestan.app.domain.Professor.Professor;
import com.golestan.app.domain.SemesterIdentifier;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nahal on 5/20/2017 AD.
 */

@Entity
@Table(name = "CourseOffer")
public class CourseOffer {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;

    @Column( name = "PLACE")
    private String place;

    @Column( name = "DATE")
    private String classTime;

    @Embedded
    private SemesterIdentifier semesterIdentifier;

    @ManyToOne(fetch = FetchType.EAGER)
    private Professor professor;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Condition> conditions ;

    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;

    @OneToMany(fetch = FetchType.LAZY)
    private List<AttendedCourseFromThisUni> attendedCourses;

    protected CourseOffer() {
    }

    public CourseOffer(String place, String classTime, SemesterIdentifier semesterIdentifier, Course course) {
        this.place = place;
        this.classTime = classTime;
        this.semesterIdentifier = semesterIdentifier;
        this.professor = null;
        this.conditions = new ArrayList<Condition>();
        this.course = course;
        this.attendedCourses = new ArrayList<AttendedCourseFromThisUni>();
    }

    public SemesterIdentifier getSemesterIdentifier() {
        return semesterIdentifier;
    }

    public void setSemesterIdentifier(SemesterIdentifier semesterIdentifier) {
        this.semesterIdentifier = semesterIdentifier;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getClassTime() {
        return classTime;
    }

    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    public List<AttendedCourseFromThisUni> getAttendedCourses() {
        return attendedCourses;
    }

    public void setAttendedCourses(List<AttendedCourseFromThisUni> attendedCourses) {
        this.attendedCourses = attendedCourses;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void addCondtiotion(Condition cond) {
        this.conditions.add(cond);
    }

    public void addAttendedCourses(AttendedCourseFromThisUni acourse) {
        this.attendedCourses.add(acourse);
    }
}
