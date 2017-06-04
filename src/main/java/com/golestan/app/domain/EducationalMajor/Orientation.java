package com.golestan.app.domain.EducationalMajor;

import javax.persistence.*;

/**
 * Created by nahal on 5/19/2017 AD.
 */

@Embeddable
public class Orientation {
    @Column(name = "name")
    private String name;

    public Orientation(String name) {
        this.name = name;
    }

    protected Orientation() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orientation that = (Orientation) o;

        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
