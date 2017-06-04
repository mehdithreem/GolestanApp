package com.golestan.app.domain.EducationalMajor;

import javax.persistence.*;

/**
 * Created by nahal on 5/20/2017 AD.
 */
@Entity
@Table(
        name= "EDUCATIONAL_MAJOR",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"YEAR", "major_name", "orientation_name"}
                )
        })
public class EducationalMajor {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @Embedded
    @AttributeOverride( name = "name", column = @Column(name = "major_name"))
    private Major major;

    @Embedded
    @AttributeOverride( name = "name", column = @Column(name = "orientation_name"))
    private Orientation orientation;

    @Column( name="YEAR")
    private Integer year;

    public EducationalMajor(Major major, Orientation orientation, Integer year) {
        this.major = major;
        this.orientation = orientation;
        this.year = year;
    }

    protected EducationalMajor() {
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
