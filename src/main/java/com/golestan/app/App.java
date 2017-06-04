package com.golestan.app;

import com.golestan.app.application.NtekhabVahed;
import com.golestan.app.data.*;
import com.golestan.app.data.EducationalMajor.EducationalMajorRepository;
import com.golestan.app.data.EducationalTopics.EducationalTopicsRepository;
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
import com.golestan.app.domain.EducationalMajor.Major;
import com.golestan.app.domain.EducationalMajor.Orientation;
import com.golestan.app.domain.EducationalTopics.Block;
import com.golestan.app.domain.EducationalTopics.CourseType;
import com.golestan.app.domain.EducationalTopics.EducationalTopics;
import com.golestan.app.domain.EducationalTopics.EducationalTopicsLesson;
import com.golestan.app.domain.Person.Individual;
import com.golestan.app.domain.SemesterIdentifier;
import com.golestan.app.domain.Student.SemesterStatus;
import com.golestan.app.domain.Student.Student;
import com.golestan.app.util.HibernateUtil;

import java.util.List;
import java.util.Scanner;


public class App {
    public static void initializeDB() {
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

    public static void NtekhabVahedScenario() {
        Student student = StudentRepository.getRepository().readByStudentNumber("810192558");

        System.out.println("Hello " + student.getIndividual().getFirstName());

        List<CourseOffer> courseOffers = NtekhabVahed.getInstance().getCurrentSemesterCourseOffers();

        for(CourseOffer courseOffer: courseOffers)
            System.out.println(courseOffer.getId().toString() + " : " + courseOffer.getCourse().getName());

        Scanner scan = new Scanner(System.in);
        int targetId = scan.nextInt();

        CourseOffer target = null;
        for(CourseOffer courseOffer: courseOffers)
            if (courseOffer.getId() == targetId) {
                target = courseOffer;
                break;
            }

        if (NtekhabVahed.getInstance().getCourseOffer(student, target))
            System.out.println("Successful");
        else
            System.out.println("You cannot attend this course.");
    }


    public static void main(String[] args) {
        System.out.println("App started");

        initializeDB();

//        NtekhabVahedScenario();

        EducationalTopicsLesson lesson1 = new EducationalTopicsLesson("riazi1", 3, CourseType.Theory, 10);
        EducationalTopicsLesson lesson2 = new EducationalTopicsLesson("riazi2", 3, CourseType.Theory, 12);

        Block blockAsli = new Block(6);
        blockAsli.addEducationalTopicsLesson(lesson1);
        blockAsli.addEducationalTopicsLesson(lesson2);

        EducationalTopicsLesson lesson3 = new EducationalTopicsLesson("economics1", 3, CourseType.Theory, 34);
        EducationalTopicsLesson lesson4 = new EducationalTopicsLesson("graph theory", 3, CourseType.Theory, 36);

        Block blockEkhtiari = new Block(3);
        blockEkhtiari.addEducationalTopicsLesson(lesson3);
        blockEkhtiari.addEducationalTopicsLesson(lesson4);

        EducationalMajor major1 = new EducationalMajor(
                new Major("Computer"),
                new Orientation("Software"),
                1392
        );

        EducationalMajor major2 = new EducationalMajor(
                new Major("Computer"),
                new Orientation("Hardware"),
                1392
        );

        EducationalMajorRepository.getRepository().create(major1);
        EducationalMajorRepository.getRepository().create(major2);

        EducationalTopics topics = new EducationalTopics(major1);
        topics.addBlock(blockAsli);
        topics.addBlock(blockEkhtiari);

        EducationalTopicsRepository.getRepository().create(topics);

        EducationalTopics readTopic = EducationalTopicsRepository.getRepository().readByEducationalMajorWithBlocks(major1);

        System.out.println(readTopic.getEducationalMajor().getMajor().getName());
        System.out.println(readTopic.getEducationalMajor().getOrientation().getName());

        System.out.println(readTopic.getBlocks().size());
        for(Block block : readTopic.getBlocks()) {
            System.out.println("\tBLOCK: " + String.valueOf(block.getId()));
            System.out.println(block.getUnitPerBlock());
            for(EducationalTopicsLesson lesson : block.getEducationalTopicsLessons()) {
                System.out.println("\t\tLESSON: " + lesson.getName());
                System.out.println(lesson.getCourseUniqueId());
            }
        }

        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        HibernateUtil.shutdown();
    }
}
