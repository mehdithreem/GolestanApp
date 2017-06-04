package com.golestan.app.domain.EducationalMajor;

import javax.persistence.*;

/**
 * Created by nahal on 5/19/2017 AD.
 */

@Embeddable
public class Orientation {
    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
