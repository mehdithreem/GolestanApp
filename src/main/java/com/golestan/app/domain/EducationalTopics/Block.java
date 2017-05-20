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
@Table(name = "Block")
public class Block {

    @OneToMany(fetch = FetchType.EAGER)
    private List<EducationalTopicsLesson> educationalTopicsLessons;

    public List<EducationalTopicsLesson> getEducationalTopicsLessons() {
        return educationalTopicsLessons;
    }

    public void setEducationalTopicsLessons(List<EducationalTopicsLesson> educationalTopicsLessons) {
        this.educationalTopicsLessons = educationalTopicsLessons;
    }
}
