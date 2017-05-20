package com.golestan.app.domain.CourseOffer;

import com.golestan.app.domain.AttendedCourse.AttendedCourse;
import com.golestan.app.domain.AttendedCourse.AttendedCourseFromThisUni;
import com.golestan.app.domain.Condition;
import com.golestan.app.domain.Professor.Professor;
import com.golestan.app.domain.SemesterIdentifier;

import javax.persistence.*;
import java.util.List;

/**
 * Created by nahal on 5/20/2017 AD.
 */

@Entity
@Table(name = "CourseOffer")
public class CourseOffer {

    @Column( name = "PLACE")
    private String place;

    @Column( name = "DATE")
    private String classTime;

    @Embedded
    private SemesterIdentifier semesterIdentifier;

    @ManyToOne
    private Professor professor;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Condition> conditions ;

    @OneToMany(fetch = FetchType.EAGER)
    private List<AttendedCourseFromThisUni> attendedCourses;

    public SemesterIdentifier getSemesterIdentifier() {
        return semesterIdentifier;
    }

    public void setSemesterIdentifier(SemesterIdentifier semesterIdentifier) {
        this.semesterIdentifier = semesterIdentifier;
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
}
