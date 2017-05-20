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

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name="NAME")
    private String name;

    @Column(name="COURSE_UNIT")
    private Integer courseUnit;

    @Column(name="COURSE_UNIQUE_ID")
    private Integer courseUniqueId;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Condition> conditions;
}
