package com.golestan.app.data;

import com.golestan.app.domain.EducationalMajor.EducationalMajor;
import com.golestan.app.domain.EducationalTopics.EducationalTopics;
import com.golestan.app.util.HibernateUtil;
import org.hibernate.Session;

/**
 * Created by nahal on 6/3/2017 AD.
 */
public class EducationalTopicsRepository {
    private static EducationalTopicsRepository theRepository = new EducationalTopicsRepository();
    public static EducationalTopicsRepository getRepository() {
        return theRepository;
    }

    //create ...
    // read should be with major and orientation
    public EducationalTopics read(Integer major_id, Integer orientation_id ){
        Session session = HibernateUtil.getSessionFactory().openSession();
        EducationalTopics educationalTopics = null; //= session.get(EducationalTopics.class, major_id, orientation_id);
        session.close();
        return educationalTopics;
    }
}
