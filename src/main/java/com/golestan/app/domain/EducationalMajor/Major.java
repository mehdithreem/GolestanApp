package com.golestan.app.domain.EducationalMajor;

import javax.persistence.*;
import java.util.List;

/**
 * Created by nahal on 5/19/2017 AD.
 */

@Entity
@Table(name = "MAJOR")
public class Major {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Orientation> orientationList;

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

    public List<Orientation> getOrientationList() {
        return orientationList;
    }

    public void setOrientationList(List<Orientation> orientationList) {
        this.orientationList = orientationList;
    }
}
