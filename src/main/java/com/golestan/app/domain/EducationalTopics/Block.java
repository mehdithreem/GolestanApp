package com.golestan.app.domain.EducationalTopics;

import javax.persistence.*;
import java.util.List;

/**
 * Created by nahal on 5/20/2017 AD.
 */

@Embeddable
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
