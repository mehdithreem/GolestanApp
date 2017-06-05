package com.golestan.app.domain.EducationalTopics;

import com.golestan.app.domain.AttendedCourse.AttendedCourse;

import javax.persistence.*;
import java.util.List;

/**
 * Created by mehdithreem on 6/5/2017 AD.
 */

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Tatbighable {
    @Id
    @GeneratedValue
    @Column(name="root_id")
    private Integer rootId;

    public abstract ITatbighed tatbigh(List<AttendedCourse> attendedCourses);

    public abstract Integer minUnit();

    public Integer getRootId() {
        return rootId;
    }

    public void setRootId(Integer rootId) {
        this.rootId = rootId;
    }
}
