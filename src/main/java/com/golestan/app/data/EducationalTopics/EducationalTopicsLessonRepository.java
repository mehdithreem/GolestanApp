package com.golestan.app.data.EducationalTopics;

import com.golestan.app.domain.EducationalTopics.EducationalTopicsLesson;
import org.hibernate.Session;

/**
 * Created by mehdithreem on 6/4/2017 AD.
 */
public class EducationalTopicsLessonRepository {
    private static EducationalTopicsLessonRepository theRepository = new EducationalTopicsLessonRepository();
    public static EducationalTopicsLessonRepository getRepository() {
        return theRepository;
    }

    public void create(EducationalTopicsLesson lesson, Session session) {
        session.save(lesson);
    }
}
