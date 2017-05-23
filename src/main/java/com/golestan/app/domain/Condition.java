package com.golestan.app.domain;

import com.golestan.app.domain.CourseOffer.CourseOffer;
import com.golestan.app.domain.Student.Student;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by nahal on 5/20/2017 AD.
 */

@Entity
@Table(name = "CONDITION")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",discriminatorType= DiscriminatorType.STRING)
public abstract class Condition {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    @ElementCollection
    @CollectionTable(name="CONDITION_ACTIVE_SEMESTERS")
    private List<SemesterIdentifier> activeSemesters;

    @Column( name = "TITLE")
    private String title;

    public Condition(String title) {
        this.title = title;
    }

    protected Condition() {
        this.id = null;
        this.activeSemesters = null;
        this.title = null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<SemesterIdentifier> getActiveSemesters() {
        return activeSemesters;
    }

    public void setActiveSemesters(List<SemesterIdentifier> activeSemesters) {
        this.activeSemesters = activeSemesters;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public abstract boolean is_justify(Student student, CourseOffer courseOffer);
}
