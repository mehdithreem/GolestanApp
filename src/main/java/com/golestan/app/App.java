package com.golestan.app;

import com.golestan.app.application.NtekhabVahed;
import com.golestan.app.data.*;
import com.golestan.app.domain.AttendedCourse.AttendedCourse;
import com.golestan.app.domain.AttendedCourse.AttendedCourseFromOtherUni;
import com.golestan.app.domain.AttendedCourse.AttendedCourseFromThisUni;
import com.golestan.app.domain.Condition;
import com.golestan.app.domain.Course.Course;
import com.golestan.app.domain.Course.MinimumRequiredCourseUnitCondition;
import com.golestan.app.domain.Course.PishniaziCondition;
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
    public static void initialize() {
        Course riazi1 = new Course("Riazi 1", 3, 10);
        riazi1.addCondtion(new MinimumRequiredCourseUnitCondition("حداقل واحد درس ریاضی ۱"));

        CourseRepository.getRepository().create(riazi1);

        Course riazi2 = new Course("Riazi 2", 3, 12);
        riazi2.addCondtion(new PishniaziCondition("پیش نیازی ریاضی ۱", riazi1));

        CourseRepository.getRepository().create(riazi2);

        CourseOffer riazi1OldOffer = new CourseOffer("Class 1", "09:00AM", new SemesterIdentifier(1395,1), riazi1);
        CourseOffer riazi1Offer = new CourseOffer("Class 3", "10:30AM", new SemesterIdentifier(1395,2), riazi1);
        CourseOffer riazi2Offer = new CourseOffer("Class 4", "10:30AM", new SemesterIdentifier(1395,2), riazi2);

        riazi1Offer.addCondtiotion(new GenderCondition("مردانه"));
        riazi2Offer.addCondtiotion(new UniEntryCondition("ورودی ۹۵ای ها"));

        CourseOfferRepository.getRepository().create(riazi1OldOffer);
        CourseOfferRepository.getRepository().create(riazi1Offer);
        CourseOfferRepository.getRepository().create(riazi2Offer);

        Individual individual = new Individual("09102005", "Mohammad Mahdi", "Mahdizdeh");
        IndividualRepository.getRepository().create(individual);

        Student student = new Student(individual, "810192558", null);

        SemesterStatus semesterStatusOld = new SemesterStatus(individual.getFirstName() + individual.getLastName(), student.getStudentNumber(), new SemesterIdentifier(1395, 1));

        AttendedCourse riazi1Attended = new AttendedCourseFromThisUni(individual.getFirstName() + individual.getLastName(), student.getStudentNumber(), riazi1OldOffer);
        AttendedCourseRepository.getRepository().create(riazi1Attended);

        semesterStatusOld.addAttendedCourse(riazi1Attended);

        SemesterStatus semesterStatus = new SemesterStatus(individual.getFirstName() + individual.getLastName(), student.getStudentNumber(), new SemesterIdentifier(1395, 2));

        student.addSemesterStatus(semesterStatusOld);
        student.addSemesterStatus(semesterStatus);

        StudentRepository.getRepository().create(student);
    }


    public static void main(String[] args) {
        System.out.println("App started");

        initialize();

        List<CourseOffer> courseOffers = NtekhabVahed.getInstance().getCurrentSemesterCourseOffers();

        // print offers



//        AttendedCourse attCourse = new AttendedCourseFromThisUni("Ali", "132", courseOffer);
//
//        AttendedCourseRepository.getRepository().create(attCourse);
//
//        AttendedCourse attCourse2 = new AttendedCourseFromOtherUni("Ali", "214", "Riazi1", 3, CourseType.Theory);
//
//        AttendedCourseRepository.getRepository().create(attCourse2);
//        Individual ind = new Individual("123456", "nahal", "mir");
//
//        IndividualRepository.getRepository().create(ind);
//
//        Student student = new Student(ind,"12341", null);
//
//        SemesterStatus semesterStatus = new SemesterStatus(ind.getFirstName(), student.getStudentNumber(), new SemesterIdentifier(96, 1));
//
//        student.addSemesterStatus(semesterStatus);
//
//        StudentRepository.getRepository().create(student);

        Student student = StudentRepository.getRepository().readByStudentNumber("12341");

        for(SemesterStatus semesterStatus: student.getSemesterIdentifierCourseGetterMap().values())
            System.out.println(semesterStatus.getStatus());


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
