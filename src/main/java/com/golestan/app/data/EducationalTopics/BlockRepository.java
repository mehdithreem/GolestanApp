package com.golestan.app.data.EducationalTopics;

import com.golestan.app.domain.EducationalTopics.Block;
import com.golestan.app.domain.EducationalTopics.EducationalTopicsLesson;
import com.golestan.app.domain.EducationalTopics.Tatbighable;
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
        for(Tatbighable tatbighable : block.getTatbighables()) {
            if (tatbighable instanceof Block)
                this.create((Block) tatbighable, session);
            else if (tatbighable instanceof EducationalTopicsLesson)
                EducationalTopicsLessonRepository.getRepository().create((EducationalTopicsLesson) tatbighable, session);
            else
                System.err.println("I don't know type of Tatbighable");
        }

        session.save(block);
    }
}
