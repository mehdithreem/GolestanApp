package com.golestan.app.domain.Student;

import com.golestan.app.domain.EducationalMajor.EducationalMajor;
import com.golestan.app.domain.Term;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by nahal on 5/19/2017 AD.
 */
@Entity
@Table(name = "Student")
public class Student {


    @Column( name = "EDUCATIONAL MAJOR")
    private EducationalMajor educationalMajor;

    @Column( name = "MATCHING FORM")
    private GraduatedMatchingForm graduatedMatchingForm;


    //wat to say
    Map<Term, CourseGetter> term_coursemngr_map = new LinkedHashMap<Term, CourseGetter>();


    public GraduatedMatchingForm getGraduatedMatchingForm() {
        return graduatedMatchingForm;
    }
    public void setGraduatedMatchingForm(GraduatedMatchingForm graduatedMatchingForm) {
        this.graduatedMatchingForm = graduatedMatchingForm;
    }

    public Map<Term, CourseGetter> getTerm_coursemngr_map() {
        return term_coursemngr_map;
    }

    public void setTerm_coursemngr_map(Map<Term, CourseGetter> term_coursemngr_map) {
        this.term_coursemngr_map = term_coursemngr_map;
    }


}
