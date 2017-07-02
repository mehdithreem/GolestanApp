package com.golestan.app.data.Student;

import com.golestan.app.domain.Student.License;
import com.golestan.app.domain.Student.SemesterStatus;
import com.golestan.app.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by mehdithreem on 5/23/2017 AD.
 */
class SemesterStatusRepository {
    private LicenseRepository licenseRepository = new LicenseRepository();

    public void create(SemesterStatus semstat) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        for (License license : semstat.getLicenses())
            this.licenseRepository.create(license);

        session.save(semstat);
        tx.commit();
        session.close();
    }

    public void updateAttendedCourses(SemesterStatus semesterStatus){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.update(semesterStatus);

        tx.commit();
        session.close();
    }

    public void createLicense(SemesterStatus semesterStatus, License license) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        licenseRepository.create(license);
        session.update(semesterStatus);

        tx.commit();
        session.close();
    }
}
