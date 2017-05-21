package com.golestan.app.domain.Course;

import com.golestan.app.domain.Condition;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mehdithreem on 5/20/2017 AD.
 */
@Entity
@Table( name="Course")
public class Course {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name="NAME")
    private String name;

    @Column(name="COURSE_UNIT")
    private Integer courseUnit;

    @Column(name="COURSE_UNIQUE_ID")
    private Integer courseUniqueId;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Condition> conditions;

    public Course(String name, Integer courseUnit, Integer courseUniqueId) {
        this.name = name;
        this.courseUnit = courseUnit;
        this.courseUniqueId = courseUniqueId;
        this.conditions = new ArrayList<Condition>();
    }

    protected Course() {
        this.id = null;
        this.name = null;
        this.courseUnit = null;
        this.courseUniqueId = null;
        this.conditions = null;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCourseUnit() {
        return courseUnit;
    }

    public void setCourseUnit(Integer courseUnit) {
        this.courseUnit = courseUnit;
    }

    public Integer getCourseUniqueId() {
        return courseUniqueId;
    }

    public void setCourseUniqueId(Integer courseUniqueId) {
        this.courseUniqueId = courseUniqueId;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    public void addCondtion(Condition condition) {
        this.conditions.add(condition);
    }
}
