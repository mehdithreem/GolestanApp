package com.golestan.app;

import com.golestan.app.domain.Person.Individual;
import com.golestan.app.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("App started");
        Session session = HibernateUtil.getSessionFactory().openSession();

        System.out.println("Session Created");

        session.beginTransaction();

        Individual example = new Individual();
        example.setFirstName("MMahdi");
        example.setLastName("Mahdizadeh");
        example.setNationalId("09101200");

        session.save(example);

        session.getTransaction().commit();

        System.out.println("Indiv comitted");

        Query q = session.createQuery("From Individual ");

        List<Individual> resultList = q.getResultList();
        System.out.println("num of individuals:" + resultList.size());
        for (Individual next : resultList) {
            System.out.println("next individual: " + next);
        }

        HibernateUtil.shutdown();
    }
}
