package com.golestan.app.domain.EducationalMajor;

import javax.persistence.*;

/**
 * Created by nahal on 5/20/2017 AD.
 */
@Embeddable
public class EducationalMajor {

    @OneToOne(fetch = FetchType.EAGER)
    private Major major;

    @OneToOne(fetch = FetchType.EAGER)
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
