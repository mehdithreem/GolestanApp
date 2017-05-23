package com.golestan.app.data;

import com.golestan.app.domain.Person.Individual;
import com.golestan.app.domain.Student.License;
import com.golestan.app.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by nahal on 5/23/2017 AD.
 */
public class IndividualRepository {
    private static IndividualRepository theRepository = new IndividualRepository();
    public static IndividualRepository getRepository() {
        return theRepository;
    }

    public void create(Individual individual) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(individual);

        tx.commit();
        session.close();
    }

    public Individual read(String nid) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Individual individual = session.get(Individual.class, nid);
        session.close();
        return individual;
    }
}
