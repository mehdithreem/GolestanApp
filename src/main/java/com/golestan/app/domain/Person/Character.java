package com.golestan.app.domain.Person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by nahal on 5/19/2017 AD.
 */
@Entity
@Table(name = "Character")
abstract public class Character {

    @Column( name = "INDIVIDUAL")
    Individual individual;

    public Individual getIndividual() {
        return individual;
    }

    public void setIndividual(Individual individual) {
        this.individual = individual;
    }
}
