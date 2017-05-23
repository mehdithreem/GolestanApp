package com.golestan.app.data;

import com.golestan.app.domain.Student.SemesterStatus;
import com.golestan.app.domain.Student.Student;
import com.golestan.app.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by mehdithreem on 5/23/2017 AD.
 */
public class StudentRepository {
    private static StudentRepository theRepository = new StudentRepository();
    public static StudentRepository getRepository() {
        return theRepository;
    }

    public void create(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        for(SemesterStatus semesterStatus: student.getSemesterIdentifierCourseGetterMap().values())
            SemesterStatusRepository.getRepository().create(semesterStatus);

        session.save(student);
        tx.commit();
        session.close();
    }

}
