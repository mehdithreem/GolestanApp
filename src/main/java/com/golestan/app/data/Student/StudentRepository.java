package com.golestan.app.data.Student;

import com.golestan.app.domain.AttendedCourse.AttendedCourse;
import com.golestan.app.domain.Student.License;
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

    private SemesterStatusRepository semesterStatusRepository = new SemesterStatusRepository();

    public void create(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        for(SemesterStatus semesterStatus: student.getSemesterIdentifierCourseGetterMap().values())
            this.semesterStatusRepository.create(semesterStatus);

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

        student.getSemesterIdentifierCourseGetterMap();
        for(SemesterStatus semesterStatus: student.getSemesterIdentifierCourseGetterMap().values()) {
            SemesterStatus temp = semesterStatus;
            List<AttendedCourse> dummy = semesterStatus.getAttendedCourses();
            for(AttendedCourse attendedCourse: dummy) {
                attendedCourse.getId();
                attendedCourse.getCourseUniqueId();
            }
        }

        session.close();
        return student;
    }

    public void updateAttendedCourses(SemesterStatus semesterStatus) {
        this.semesterStatusRepository.updateAttendedCourses(semesterStatus);
    }

    public void createLicense(SemesterStatus semesterStatus, License license) {
        this.semesterStatusRepository.createLicense(semesterStatus, license);
    }
}
