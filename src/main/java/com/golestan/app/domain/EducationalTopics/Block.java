package com.golestan.app.domain.EducationalTopics;

import com.golestan.app.domain.AttendedCourse.AttendedCourse;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nahal on 5/20/2017 AD.
 */

@Entity
@Table(name = "BLOCK")
public class Block {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;

    @Column(name="unit_per_block")
    private Integer unitPerBlock;

    @OneToMany(fetch = FetchType.EAGER)
    private List<EducationalTopicsLesson> educationalTopicsLessons;

    public List<EducationalTopicsLesson> getEducationalTopicsLessons() {
        return educationalTopicsLessons;
    }

    public void setEducationalTopicsLessons(List<EducationalTopicsLesson> educationalTopicsLessons) {
        this.educationalTopicsLessons = educationalTopicsLessons;
    }

    public Block(Integer unitPerBlock) {
        this.unitPerBlock = unitPerBlock;
        this.educationalTopicsLessons = new ArrayList<EducationalTopicsLesson>();
    }

    protected Block() {

    }

    public void addEducationalTopicsLesson(EducationalTopicsLesson lesson) {
        this.educationalTopicsLessons.add(lesson);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUnitPerBlock() {
        return unitPerBlock;
    }

    public void setUnitPerBlock(Integer unitPerBlock) {
        this.unitPerBlock = unitPerBlock;
    }

    public boolean IsTatbigh(List<AttendedCourse> attendedCourses){
        Integer lpb = 0;
        for(AttendedCourse attendedCourse : attendedCourses) {
            boolean found = false;
            for (EducationalTopicsLesson educationalTopicsLesson : educationalTopicsLessons) {
                if (attendedCourse.getCourseUniqueId().equals(educationalTopicsLesson.getCourseUniqueId()))
                    found = true;
            }
            if(found)
                lpb +=1;
            else
                return false;
        }
        if(lpb != unitPerBlock)
            return false;

        return true;
    }
}
