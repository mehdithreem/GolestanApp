package com.golestan.app.data;

import com.golestan.app.domain.AttendedCourse.AttendedCourse;
import com.golestan.app.domain.Student.License;
import com.golestan.app.domain.Student.SemesterStatus;
import com.golestan.app.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by mehdithreem on 5/23/2017 AD.
 */
public class SemesterStatusRepository {
    private static SemesterStatusRepository theRepository = new SemesterStatusRepository();
    public static SemesterStatusRepository getRepository() {
        return theRepository;
    }

    public void create(SemesterStatus semstat) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        for (License license : semstat.getLicenses())
            LicenseRepository.getRepository().create(license);

        for (AttendedCourse attendedCourse : semstat.getAttendedCourses())
            AttendedCourseRepository.getRepository().create(attendedCourse);

        session.save(semstat);
        tx.commit();
        session.close();
    }
}
