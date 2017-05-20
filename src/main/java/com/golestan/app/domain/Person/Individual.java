package com.golestan.app.domain.Person;

import com.golestan.app.domain.Student.Student;

import javax.persistence.*;
import java.util.List;

/**
 * Created by mehdithreem on 5/19/2017 AD.
 */
@Entity
@Table(name = "Individual")
public class Individual {
    @Id
    @Column( name = "NID")
    private String nationalId;

    @Column( name = "FIRST_NAME")
    private String firstName;

    @Column( name = "LAST_NAME")
    private String lastName;

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Individual() {
        nationalId = null;
    }


}
