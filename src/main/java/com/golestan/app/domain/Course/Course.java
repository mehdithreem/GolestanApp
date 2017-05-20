package com.golestan.app.domain.Course;

import com.golestan.app.domain.Condition;

import javax.persistence.*;
import java.util.List;

/**
 * Created by mehdithreem on 5/20/2017 AD.
 */
@Entity
@Table( name="Course")
public class Course {

    @Column(name="NAME")
    private String name;

    @Column(name="COURSE_UNIT")
    private Integer courseUnit;

    @Column(name="LESSON_UNIQUE_ID")
    private Integer lessonUniqueId;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Condition> conditions;
}
