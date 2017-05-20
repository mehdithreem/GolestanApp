package com.golestan.app.domain.EducationalMajor;

import javax.persistence.*;

/**
 * Created by nahal on 5/19/2017 AD.
 */

@Entity
@Table(name = "ORIENTATION")
public class Orientation {


    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
