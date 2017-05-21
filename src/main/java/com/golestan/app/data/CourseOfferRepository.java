package com.golestan.app.data;

import com.golestan.app.domain.Condition;
import com.golestan.app.domain.Course.Course;
import com.golestan.app.domain.CourseOffer.CourseOffer;
import com.golestan.app.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by mehdithreem on 5/21/2017 AD.
 */
public class CourseOfferRepository {
    private static CourseOfferRepository theRepository = new CourseOfferRepository();
    public static CourseOfferRepository getRepository() {
        return theRepository;
    }

    private CourseOfferRepository() {
    }

    public void create(CourseOffer coffer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(coffer);
        for (Condition cond : coffer.getConditions())
            ConditionRepository.getRepository().create(cond);
        tx.commit();
        session.close();
    }

    public CourseOffer read(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CourseOffer coff = session.get(CourseOffer.class, id);
        session.close();
        return coff;
    }

    public CourseOffer readWithAttendedCourseFromThisUni(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CourseOffer coff = session.get(CourseOffer.class, id);

        coff.getAttendedCourses();

        session.close();
        return coff;
    }

    public CourseOffer readWithCourse(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CourseOffer coff = session.get(CourseOffer.class, id);

        coff.getCourse().getId();

        session.close();
        return coff;
    }
}
