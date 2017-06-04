package com.golestan.app.domain.EducationalTopics;

import com.golestan.app.domain.AttendedCourse.AttendedCourse;

import javax.persistence.*;
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

    @Column(name="lessons_per_block")
    private Integer lessons_per_block;

    @OneToMany(fetch = FetchType.EAGER)
    private List<EducationalTopicsLesson> educationalTopicsLessons;

    public List<EducationalTopicsLesson> getEducationalTopicsLessons() {
        return educationalTopicsLessons;
    }

    public void setEducationalTopicsLessons(List<EducationalTopicsLesson> educationalTopicsLessons) {
        this.educationalTopicsLessons = educationalTopicsLessons;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLessons_per_block() {
        return lessons_per_block;
    }

    public void setLessons_per_block(Integer lessons_per_block) {
        this.lessons_per_block = lessons_per_block;
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
        if(lpb != lessons_per_block)
            return false;

        return true;
    }
}
