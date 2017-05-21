package com.golestan.app.data;

import com.golestan.app.domain.Condition;
import com.golestan.app.domain.Course.Course;
import com.golestan.app.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by mehdithreem on 5/21/2017 AD.
 */
public class ConditionRepository {
    private static ConditionRepository theRepository = new ConditionRepository();
    public static ConditionRepository getRepository() {
        return theRepository;
    }

    public void create(Condition condition) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(condition);
        tx.commit();
        session.close();
    }
}
