package com.golestan.app.data.EducationalTopics;

import com.golestan.app.domain.EducationalTopics.Block;
import com.golestan.app.domain.EducationalTopics.EducationalTopicsLesson;
import org.hibernate.Session;

/**
 * Created by mehdithreem on 6/4/2017 AD.
 */
class BlockRepository {
    private static BlockRepository theRepository = new BlockRepository();
    public static BlockRepository getRepository() {
        return theRepository;
    }

    public void create(Block block, Session session) {
        for(EducationalTopicsLesson lesson : block.getEducationalTopicsLessons())
            EducationalTopicsLessonRepository.getRepository().create(lesson, session);

        session.save(block);
    }
}
