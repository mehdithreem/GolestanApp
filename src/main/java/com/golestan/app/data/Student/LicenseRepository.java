package com.golestan.app.data.Student;

import com.golestan.app.domain.Student.License;
import com.golestan.app.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by mehdithreem on 5/23/2017 AD.
 */
class LicenseRepository {
    public void create(License license) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(license);

        tx.commit();
        session.close();
    }

    public License read(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        License license = session.get(License.class, id);
        session.close();
        return license;
    }
}
