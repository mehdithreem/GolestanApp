package com.golestan.app.domain;

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

    Condition(String title) {
        this.title = title;
    }

    public abstract boolean is_justify(Student student);
}
