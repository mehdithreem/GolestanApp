package com.golestan.app.data.EducationalTopics;

import com.golestan.app.domain.EducationalMajor.EducationalMajor;
import com.golestan.app.domain.EducationalTopics.Block;
import com.golestan.app.domain.EducationalTopics.EducationalTopics;
import com.golestan.app.domain.EducationalTopics.EducationalTopicsLesson;
import com.golestan.app.domain.EducationalTopics.Tatbighable;
import com.golestan.app.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by nahal on 6/3/2017 AD.
 */
public class EducationalTopicsRepository {
    private static EducationalTopicsRepository theRepository = new EducationalTopicsRepository();
    public static EducationalTopicsRepository getRepository() {
        return theRepository;
    }

    public void create(EducationalTopics educationalTopics) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Tatbighable root = educationalTopics.getRoot();

        if (root instanceof Block)
            BlockRepository.getRepository().create((Block) root, session);
        else if (root instanceof EducationalTopicsLesson)
            EducationalTopicsLessonRepository.getRepository().create((EducationalTopicsLesson) root, session);


        session.save(educationalTopics);
        tx.commit();
        session.close();
    }

    public EducationalTopics readByEducationalMajorWithBlocks(EducationalMajor educationalMajor){
        Session session = HibernateUtil.getSessionFactory().openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<EducationalTopics> criteria = builder.createQuery(EducationalTopics.class);
        Root<EducationalTopics> educationalTopicsRoot = criteria.from( EducationalTopics.class );
        ParameterExpression<EducationalMajor> major = builder.parameter(EducationalMajor.class);

        criteria.select(educationalTopicsRoot);
        criteria.where(builder.equal(educationalTopicsRoot.get("educationalMajor"), major));

        TypedQuery<EducationalTopics> query = session.createQuery(criteria);
        query.setParameter(major, educationalMajor);

        EducationalTopics educationalTopics = query.getSingleResult();

        Tatbighable root = educationalTopics.getRoot();
        root.getRootId();

        session.close();
        return educationalTopics;
    }
}
