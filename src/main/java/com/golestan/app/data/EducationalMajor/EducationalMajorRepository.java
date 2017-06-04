package com.golestan.app.data.EducationalMajor;

import com.golestan.app.domain.EducationalMajor.EducationalMajor;
import com.golestan.app.domain.EducationalMajor.Major;
import com.golestan.app.domain.EducationalMajor.Orientation;
import com.golestan.app.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

/**
 * Created by mehdithreem on 6/4/2017 AD.
 */
public class EducationalMajorRepository {
    private static EducationalMajorRepository theRepository = new EducationalMajorRepository();
    public static EducationalMajorRepository getRepository() {
        return theRepository;
    }

    public void create(EducationalMajor major) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(major);
        tx.commit();
        session.close();
    }

    public EducationalMajor readByMajorOrientationYear(Major major, Orientation orientation, Integer year) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<EducationalMajor> criteria = builder.createQuery(EducationalMajor.class);
        Root<EducationalMajor> educationalMajorRoot = criteria.from( EducationalMajor.class );

        ParameterExpression<Major> majorParam = builder.parameter(Major.class);
        ParameterExpression<Orientation> orientationParam = builder.parameter(Orientation.class);
        ParameterExpression<Integer> yearParam = builder.parameter(Integer.class);

        criteria.select(educationalMajorRoot);
        criteria.where(builder.equal(educationalMajorRoot.get("major"), majorParam),
                builder.equal(educationalMajorRoot.get("orientation"), orientationParam),
                builder.equal(educationalMajorRoot.get("year"), yearParam));

        TypedQuery<EducationalMajor> query = session.createQuery(criteria);
        query.setParameter(majorParam, major);
        query.setParameter(orientationParam, orientation);
        query.setParameter(yearParam, year);

        EducationalMajor educationalMajor = query.getSingleResult();

        session.close();
        return  educationalMajor;
    }
}
