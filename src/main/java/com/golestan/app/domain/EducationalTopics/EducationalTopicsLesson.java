package com.golestan.app.domain.EducationalTopics;


import javax.persistence.*;

/**
 * Created by nahal on 5/20/2017 AD.
 */


@Entity
@Table(name = "Educational_Topics_Lesson")
public class EducationalTopicsLesson {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;

    @Column( name = "NAME")
    private String name;

    @Column( name = "COURSE UNIT")
    private int CourseUnit;

    @Column( name = "COURSE TYPE")
    private CourseType courseType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourseUnit() {
        return CourseUnit;
    }

    public void setCourseUnit(int courseUnit) {
        CourseUnit = courseUnit;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }
}
