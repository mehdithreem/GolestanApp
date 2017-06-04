package com.golestan.app.data.AttendanceConditions;

import com.golestan.app.domain.AttendedCourse.AttendedCourse;
import com.golestan.app.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by mehdithreem on 5/23/2017 AD.
 */
public class AttendedCourseRepository {
    private static AttendedCourseRepository theRepository = new AttendedCourseRepository();
    public static AttendedCourseRepository getRepository() {
        return theRepository;
    }

    public void create(AttendedCourse attendedCourse) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(attendedCourse);
        tx.commit();
        session.close();
    }
}
