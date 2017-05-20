package com.golestan.app.domain.Student;

import javax.persistence.*;
import java.util.List;

/**
 * Created by nahal on 5/19/2017 AD.
 */
@Entity
@Table(name = "CourseGetter")
public class CourseGetter {

    @Column( name = "STATUS")
    private String status;

    @Column( name = "GPA")
    private int gpa;

    @OneToMany(fetch = FetchType.EAGER)
    private List<License> licenses;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getGpa() {
        return gpa;
    }

    public void setGpa(int gpa) {
        this.gpa = gpa;
    }

    public List<License> getLicenses() {
        return licenses;
    }

    public void setLicenses(List<License> licenses) {
        this.licenses = licenses;
    }
}
