package com.golestan.app.application;

import com.golestan.app.domain.EducationalMajor.EducationalMajor;
import com.golestan.app.domain.EducationalTopics.EducationalTopics;
import com.golestan.app.domain.Student.Student;

/**
 * Created by mehdithreem on 5/30/2017 AD.
 */
public class EducationalTopicsManager {
    private static EducationalTopicsManager theRepository = new EducationalTopicsManager();
    public static EducationalTopicsManager getInstance() {
        return theRepository;
    }

    public EducationalTopics getEducationalTopicsOf(Student target) {
        return new EducationalTopics();
    }
}
