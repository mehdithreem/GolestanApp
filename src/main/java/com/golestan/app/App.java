package com.golestan.app;

import com.golestan.app.data.ConditionRepository;
import com.golestan.app.data.CourseOfferRepository;
import com.golestan.app.data.CourseRepository;
import com.golestan.app.domain.Condition;
import com.golestan.app.domain.Course.Course;
import com.golestan.app.domain.Course.MinimumRequiredCourseUnitCondition;
import com.golestan.app.domain.CourseOffer.CourseOffer;
import com.golestan.app.domain.CourseOffer.GenderCondition;
import com.golestan.app.domain.CourseOffer.UniEntryCondition;
import com.golestan.app.domain.Person.Individual;
import com.golestan.app.domain.SemesterIdentifier;
import com.golestan.app.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("App started");

//        Course riazi = new Course("Riazi 1", 3, 10);
//
//        riazi.addCondtion(new MinimumRequiredCourseUnitCondition("حداقل واحد درس ریاضی ۱"));
//
//        CourseRepository.getRepository().create(riazi);
//
//        System.out.println(riazi.getId());

//        Course riaziRead = CourseRepository.getRepository().read(4);
//
//        for (Condition cond : riaziRead.getConditions())
//            System.out.print(cond.getTitle());

//        CourseOffer courseOffer = new CourseOffer("Class4", "10:30AM", new SemesterIdentifier(1396,2), riaziRead);
//
//        courseOffer.addCondtiotion(new UniEntryCondition("ورودی ۹۵ای ها"));
//
//        CourseOfferRepository.getRepository().create(courseOffer);

//        CourseOffer readCourseOffer = CourseOfferRepository.getRepository().readWithCourse(6);
//
//        if (readCourseOffer.getCourse() == null)
//            System.out.println("Course didn't loaded");
//        else
//            System.out.println(readCourseOffer.getCourse().getName());

        List<CourseOffer> readCourseOffers = CourseOfferRepository.getRepository().readBySemesterWithCourse(new SemesterIdentifier(1396,2));

        System.out.println(readCourseOffers.size());


//        CourseOffer riazi = new CourseOffer();
//
//        System.out.println("CourseOffer comitted");

//        Query q = session.createQuery("From Individual ");
//
//        List<Individual> resultList = q.getResultList();
//        System.out.println("num of individuals:" + resultList.size());
//        for (Individual next : resultList) {
//            System.out.println("next individual: " + next);
//        }

        HibernateUtil.shutdown();
    }
}
