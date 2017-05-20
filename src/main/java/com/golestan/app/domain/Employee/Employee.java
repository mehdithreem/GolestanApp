package com.golestan.app.domain.Employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by nahal on 5/19/2017 AD.
 */
@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @Column( name = "ID_NUMBER")
    private String employeeNumber;

    public String getNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }
}
