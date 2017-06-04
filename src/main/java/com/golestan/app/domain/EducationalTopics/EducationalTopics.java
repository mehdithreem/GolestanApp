package com.golestan.app.domain.EducationalTopics;

import com.golestan.app.domain.AttendedCourse.AttendedCourse;
import com.golestan.app.domain.EducationalMajor.EducationalMajor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nahal on 5/20/2017 AD.
 */
@Entity
@Table(name = "EDUCATIONAL_TOPICS")
public class EducationalTopics {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;

    @ManyToOne( fetch = FetchType.EAGER )
    private EducationalMajor educationalMajor;

    @ManyToOne( fetch = FetchType.LAZY )
    private Tatbighable root;

    public EducationalTopics(EducationalMajor educationalMajor, Tatbighable root) {
        this.educationalMajor = educationalMajor;
        this.root = root;
    }

    protected EducationalTopics() {
    }

    public EducationalMajor getEducationalMajor() {
        return educationalMajor;
    }

    public void setEducationalMajor(EducationalMajor educationalMajor) {
        this.educationalMajor = educationalMajor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Tatbighable getRoot() {
        return root;
    }

    public void setRoot(Tatbighable root) {
        this.root = root;
    }

    public boolean IsTatbigh(List<AttendedCourse> attendedCourses){
//        for(Block block : blocks){
//            if (! block.IsTatbigh(attendedCourses))
//                return false;
//        }
        return true;
    }
}
