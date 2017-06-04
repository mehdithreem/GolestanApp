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
public class Block extends Tatbighable {
//    @Id
//    @GeneratedValue
//    @Column(name="id")
//    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="unit_per_block")
    private Integer unitPerBlock;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Tatbighable> tatbighables;

    public Block(Integer unitPerBlock, String name) {
        this.unitPerBlock = unitPerBlock;
        this.tatbighables = new ArrayList<Tatbighable>();
        this.name = name;
    }

    protected Block() {
    }

    public void addTatbighable(Tatbighable tatbighable) {
        this.tatbighables.add(tatbighable);
    }

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public Integer getUnitPerBlock() {
        return unitPerBlock;
    }

    public void setUnitPerBlock(Integer unitPerBlock) {
        this.unitPerBlock = unitPerBlock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tatbighable> getTatbighables() {
        return tatbighables;
    }

    public void setTatbighables(List<Tatbighable> tatbighables) {
        this.tatbighables = tatbighables;
    }

    public boolean tatbigh(List<AttendedCourse> attendedCourses){
//        Integer lpb = 0;
//        for(AttendedCourse attendedCourse : attendedCourses) {
//            boolean found = false;
//            for (EducationalTopicsLesson educationalTopicsLesson : tatbighables) {
//                if (attendedCourse.getCourseUniqueId().equals(educationalTopicsLesson.getCourseUniqueId()))
//                    found = true;
//            }
//            if(found)
//                lpb +=1;
//            else
//                return false;
//        }
//        if(lpb != unitPerBlock)
//            return false;

        return true;
    }
}
