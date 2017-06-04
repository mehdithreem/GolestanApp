package com.golestan.app.domain.EducationalMajor;

import javax.persistence.*;
import java.util.List;

/**
 * Created by nahal on 5/19/2017 AD.
 */

@Embeddable
public class Major {
    @Column(name = "name")
    private String name;

    public Major(String name) {
        this.name = name;
    }

    protected Major() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
