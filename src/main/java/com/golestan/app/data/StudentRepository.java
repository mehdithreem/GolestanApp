package com.golestan.app.data;

import com.golestan.app.domain.AttendedCourse.AttendedCourse;
import com.golestan.app.domain.Student.SemesterStatus;
import com.golestan.app.domain.Student.Student;
import com.golestan.app.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

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

    public Student readByStudentNumber(String studentNumber) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
        Root<Student> studentRoot = criteria.from( Student.class );
        ParameterExpression<String> studentNumberParam = builder.parameter(String.class);

        criteria.select(studentRoot);
        criteria.where(builder.equal(studentRoot.get("studentNumber"), studentNumberParam));

        TypedQuery<Student> query = session.createQuery(criteria);
        query.setParameter(studentNumberParam, studentNumber);

        Student student = query.getSingleResult();

        for(SemesterStatus semesterStatus: student.getSemesterIdentifierCourseGetterMap().values()) {
            List<AttendedCourse> dummy = semesterStatus.getAttendedCourses();
        }

        session.close();
        return student;
    }

}
