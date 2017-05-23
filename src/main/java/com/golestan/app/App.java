package com.golestan.app;

import com.golestan.app.data.AttendedCourseRepository;
import com.golestan.app.data.ConditionRepository;
import com.golestan.app.data.CourseOfferRepository;
import com.golestan.app.data.CourseRepository;
import com.golestan.app.domain.AttendedCourse.AttendedCourse;
import com.golestan.app.domain.AttendedCourse.AttendedCourseFromOtherUni;
import com.golestan.app.domain.AttendedCourse.AttendedCourseFromThisUni;
import com.golestan.app.domain.Condition;
import com.golestan.app.domain.Course.Course;
import com.golestan.app.domain.Course.MinimumRequiredCourseUnitCondition;
import com.golestan.app.domain.CourseOffer.CourseOffer;
import com.golestan.app.domain.CourseOffer.GenderCondition;
import com.golestan.app.domain.CourseOffer.UniEntryCondition;
import com.golestan.app.domain.EducationalMajor.EducationalMajor;
import com.golestan.app.domain.EducationalTopics.CourseType;
import com.golestan.app.domain.Person.Individual;
import com.golestan.app.domain.SemesterIdentifier;
import com.golestan.app.domain.Student.SemesterStatus;
import com.golestan.app.domain.Student.Student;
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
////
//        riazi.addCondtion(new MinimumRequiredCourseUnitCondition("حداقل واحد درس ریاضی ۱"));
////
//        CourseRepository.getRepository().create(riazi);
////
//        System.out.println(riazi.getId());

//        Course riaziRead = CourseRepository.getRepository().read(1);
////
//        for (Condition cond : riaziRead.getConditions())
//            System.out.print(cond.getTitle());
//
//        CourseOffer courseOffer = new CourseOffer("Class4", "10:30AM", new SemesterIdentifier(1396,2), riaziRead);
////
//        courseOffer.addCondtiotion(new UniEntryCondition("ورودی ۹۵ای ها"));
////
//        CourseOfferRepository.getRepository().create(courseOffer);

//        CourseOffer readCourseOffer = CourseOfferRepository.getRepository().readWithCourse(6);
//
//        if (readCourseOffer.getCourse() == null)
//            System.out.println("Course didn't loaded");
//        else
//            System.out.println(readCourseOffer.getCourse().getName());

//        List<CourseOffer> readCourseOffers = CourseOfferRepository.getRepository().readBySemesterWithCourse(new SemesterIdentifier(1396,2));
//
//        System.out.println(readCourseOffers.size());

//        AttendedCourse attCourse = new AttendedCourseFromThisUni("Ali", "132", courseOffer);
//
//        AttendedCourseRepository.getRepository().create(attCourse);
//
//        AttendedCourse attCourse2 = new AttendedCourseFromOtherUni("Ali", "214", "Riazi1", 3, CourseType.Theory);
//
//        AttendedCourseRepository.getRepository().create(attCourse2);

        Student student = new Student("12341", null);

        SemesterStatus semesterStatus = SemesterStatus();


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
