package com.golestan.app.domain.Student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by nahal on 5/19/2017 AD.
 */

@Entity
@Table( name = "GUEST_STUDENT")
public class GuestStudent extends Student{

    @Column( name = "ORIGIN_UNIVERSITY")
    private String OriginUniversity;

    public String getOriginUniversity() {
        return OriginUniversity;
    }

    public void setOriginUniversity(String originUniversity) {
        OriginUniversity = originUniversity;
    }
}
