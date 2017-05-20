package com.golestan.app.domain.Professor;

import com.golestan.app.domain.Term;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by nahal on 5/19/2017 AD.
 */
public class Professor {
    Map<Term, CourseManager> term_coursemngr_map = new LinkedHashMap<Term, CourseManager>();
}
