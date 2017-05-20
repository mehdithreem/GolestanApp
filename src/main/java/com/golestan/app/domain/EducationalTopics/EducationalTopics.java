package com.golestan.app.domain.EducationalTopics;

import com.golestan.app.domain.EducationalMajor.EducationalMajor;

import javax.persistence.*;
import java.util.List;

/**
 * Created by nahal on 5/20/2017 AD.
 */
@Entity
@Table(name = "EducationalTopics")
public class EducationalTopics {

    @Embedded
    private EducationalMajor educationalMajor;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Block> blocks;

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
}
