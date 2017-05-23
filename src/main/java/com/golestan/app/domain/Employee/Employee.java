package com.golestan.app.domain.Employee;

import com.golestan.app.domain.Person.Character;

import javax.persistence.*;

/**
 * Created by nahal on 5/19/2017 AD.
 */
@Entity
@Table(name = "EMPLOYEE")
public class Employee extends Character{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

}
