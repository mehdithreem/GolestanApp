package com.golestan.app.data;

import com.golestan.app.domain.Condition;
import com.golestan.app.domain.Course.Course;
import com.golestan.app.domain.CourseOffer.CourseOffer;
import com.golestan.app.domain.SemesterIdentifier;
import com.golestan.app.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by mehdithreem on 5/21/2017 AD.
 */
public class CourseOfferRepository {
    private static CourseOfferRepository theRepository = new CourseOfferRepository();
    public static CourseOfferRepository getRepository() {
        return theRepository;
    }

    private CourseOfferRepository() {
    }

    public void create(CourseOffer coffer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(coffer);
        for (Condition cond : coffer.getConditions())
            ConditionRepository.getRepository().create(cond);
        tx.commit();
        session.close();
    }

    public CourseOffer read(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CourseOffer coff = session.get(CourseOffer.class, id);
        session.close();
        return coff;
    }

    public CourseOffer readWithAttendedCourseFromThisUni(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CourseOffer coff = session.get(CourseOffer.class, id);

        coff.getAttendedCourses();

        session.close();
        return coff;
    }

    public CourseOffer readWithCourse(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CourseOffer coff = session.get(CourseOffer.class, id);

        coff.getCourse().getId();

        session.close();
        return coff;
    }

    public List<CourseOffer> readBySemesterWithCourse(SemesterIdentifier id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<CourseOffer> criteria = builder.createQuery(CourseOffer.class);
        Root<CourseOffer> courseOfferRoot = criteria.from( CourseOffer.class );
        ParameterExpression<SemesterIdentifier> semester = builder.parameter(SemesterIdentifier.class);

        criteria.select(courseOfferRoot);
        criteria.where(builder.equal(courseOfferRoot.get("semesterIdentifier"), semester));

        TypedQuery<CourseOffer> query = session.createQuery(criteria);
        query.setParameter(semester, id);

        List<CourseOffer> courseOffers = query.getResultList();

        for (CourseOffer coff: courseOffers)
            coff.getCourse().getId();

        session.close();
        return courseOffers;
    }
}
