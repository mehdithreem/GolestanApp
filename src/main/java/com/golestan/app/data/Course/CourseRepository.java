package com.golestan.app.data.Course;

import com.golestan.app.data.ConditionRepository;
import com.golestan.app.domain.Condition;
import com.golestan.app.domain.Course.Course;
import com.golestan.app.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by mehdithreem on 5/21/2017 AD.
 */
public class CourseRepository {
    private static CourseRepository theRepository = new CourseRepository();
    public static CourseRepository getRepository() {
        return theRepository;
    }

    private CourseRepository() {
    }

    public void create(Course course) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(course);

        for (Condition cond : course.getConditions())
            ConditionRepository.getRepository().create(cond);

        tx.commit();
        session.close();
    }

    public Course read(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Course course = session.get(Course.class, id);
        session.close();
        return course;
    }
}
