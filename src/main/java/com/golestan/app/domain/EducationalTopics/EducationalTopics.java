package com.golestan.app.domain.EducationalTopics;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by nahal on 5/20/2017 AD.
 */
@Entity
@Table(name = "EducationalTopics")
public class EducationalTopics {

    //Oriention and major

    @OneToMany(fetch = FetchType.EAGER)
    private List<Block> blocks;

    public List<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }
}
