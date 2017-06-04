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

    @OneToMany( fetch = FetchType.LAZY )
    private List<Block> blocks;

    public EducationalTopics(EducationalMajor educationalMajor) {
        this.educationalMajor = educationalMajor;
        this.blocks = new ArrayList<Block>();
    }

    protected EducationalTopics() {

    }

    public void addBlock(Block block) {
        this.blocks.add(block);
    }

    public EducationalMajor getEducationalMajor() {
        return educationalMajor;
    }

    public void setEducationalMajor(EducationalMajor educationalMajor) {
        this.educationalMajor = educationalMajor;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean IsTatbigh(List<AttendedCourse> attendedCourses){
        for(Block block : blocks){
            if (! block.IsTatbigh(attendedCourses))
                return false;
        }
        return true;
    }
}
