package com.golestan.app.domain.Person;

import javax.persistence.*;

/**
 * Created by nahal on 5/19/2017 AD.
 */
@Entity
@Table(name = "Character")
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
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
