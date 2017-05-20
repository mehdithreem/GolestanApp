package com.golestan.app.domain.EducationalMajor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by nahal on 5/20/2017 AD.
 */
@Entity
@Table(name = "EducationalMajor")

public class EducationalMajor {

    @Column( name = "MAJOR")
    private Major major;

    @Column( name = "ORIENTATION")
    private Orientation orientation;

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }
}
