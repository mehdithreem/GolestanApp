package com.golestan.app;

import com.golestan.app.application.FaraghatAzTahsil;
import com.golestan.app.application.NtekhabVahed;
import com.golestan.app.data.AttendanceConditions.AttendedCourseRepository;
import com.golestan.app.data.Course.CourseRepository;
import com.golestan.app.data.CourseOffer.CourseOfferRepository;
import com.golestan.app.data.EducationalMajor.EducationalMajorRepository;
import com.golestan.app.data.EducationalTopics.EducationalTopicsRepository;
import com.golestan.app.data.Person.IndividualRepository;
import com.golestan.app.data.Student.StudentRepository;
import com.golestan.app.domain.AttendedCourse.AttendedCourse;
import com.golestan.app.domain.AttendedCourse.AttendedCourseFromThisUni;
import com.golestan.app.domain.Course.Course;
import com.golestan.app.domain.Course.MinimumRequiredCourseUnitCondition;
import com.golestan.app.domain.Course.PishniaziCondition;
import com.golestan.app.domain.CourseOffer.CourseOffer;
import com.golestan.app.domain.CourseOffer.GenderCondition;
import com.golestan.app.domain.CourseOffer.UniEntryCondition;
import com.golestan.app.domain.EducationalMajor.EducationalMajor;
import com.golestan.app.domain.EducationalMajor.Major;
import com.golestan.app.domain.EducationalMajor.Orientation;
import com.golestan.app.domain.EducationalTopics.*;
import com.golestan.app.domain.Person.Individual;
import com.golestan.app.domain.SemesterIdentifier;
import com.golestan.app.domain.Student.SemesterStatus;
import com.golestan.app.domain.Student.Student;
import com.golestan.app.util.HibernateUtil;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void createChart() {
        EducationalTopicsLesson lesson1 = new EducationalTopicsLesson("ریاضی ۱", 3, CourseType.Theory, 101);
        EducationalTopicsLesson lesson2 = new EducationalTopicsLesson("ریاضی ۲", 3, CourseType.Theory, 102);
        EducationalTopicsLesson lesson3 = new EducationalTopicsLesson("معارف اسلامی", 3, CourseType.Theory, 103);

        Block blockAsli = new Block("دروس اصلی", 9);
        blockAsli.setTatbighMode(TatbighMode.ALL);
        blockAsli.addTatbighable(lesson1);
        blockAsli.addTatbighable(lesson2);
        blockAsli.addTatbighable(lesson3);

        EducationalTopicsLesson lesson4 = new EducationalTopicsLesson("تئوری گراف", 3, CourseType.Theory, 104);
        EducationalTopicsLesson lesson5 = new EducationalTopicsLesson("اقتصاد", 3, CourseType.Theory, 105);

        Block blockEkhtiariAsli = new Block("دروس اختیاری اصلی", 3);
        blockEkhtiariAsli.setTatbighMode(TatbighMode.SOME);
        blockEkhtiariAsli.addTatbighable(lesson4);
        blockEkhtiariAsli.addTatbighable(lesson5);

        EducationalTopicsLesson lesson6 = new EducationalTopicsLesson("شبکه‌های کامپیوتری", 3, CourseType.Theory, 106);
        EducationalTopicsLesson lesson7 = new EducationalTopicsLesson("انتقال داده", 3, CourseType.Theory, 107);

        Block blockCN = new Block("دروس تخصصی شبکه", 3);
        blockCN.setTatbighMode(TatbighMode.SOME);
        blockCN.addTatbighable(lesson6);
        blockCN.addTatbighable(lesson7);

        EducationalTopicsLesson lesson8 = new EducationalTopicsLesson("طراحی شئ‌گرا", 3, CourseType.Theory, 108);
        EducationalTopicsLesson lesson9 = new EducationalTopicsLesson("مهندسی نرم‌افزار", 3, CourseType.Theory, 109);

        Block blockSE = new Block("دروس تخصصی نرم‌افزار", 3);
        blockSE.setTatbighMode(TatbighMode.SOME);
        blockSE.addTatbighable(lesson8);
        blockSE.addTatbighable(lesson9);

        Block blockEkhtiariTakhasosi = new Block("دروس اختیاری تخصصی", 3);
        blockEkhtiariTakhasosi.setTatbighMode(TatbighMode.ONE);
        blockEkhtiariTakhasosi.addTatbighable(blockCN);
        blockEkhtiariTakhasosi.addTatbighable(blockSE);

        Block blockEkhtiari = new Block("دروس اختیاری", 9);
        blockEkhtiari.setTatbighMode(TatbighMode.ALL);
        blockEkhtiari.addTatbighable(blockEkhtiariAsli);
        blockEkhtiari.addTatbighable(blockEkhtiariTakhasosi);

        Block rootBlock = new Block("ریشه", 9);
        rootBlock.setTatbighMode(TatbighMode.ALL);
        rootBlock.addTatbighable(blockAsli);
        rootBlock.addTatbighable(blockEkhtiari);

        EducationalMajor major1 = new EducationalMajor(
                new Major("Computer"),
                new Orientation("Software"),
                1392
        );

        EducationalMajorRepository.getRepository().create(major1);

        EducationalTopics topics = new EducationalTopics(major1, rootBlock);
        EducationalTopicsRepository.getRepository().create(topics);
    }

    public static void createMinorChart() {
        EducationalTopicsLesson lesson1 = new EducationalTopicsLesson("ریاضیات گسسته", 3, CourseType.Theory, 401);
        EducationalTopicsLesson lesson2 = new EducationalTopicsLesson("ساختمان داده", 3, CourseType.Theory, 402);

        Block blockAsli = new Block("دروس اصلی", 6);
        blockAsli.setTatbighMode(TatbighMode.ALL);
        blockAsli.addTatbighable(lesson1);
        blockAsli.addTatbighable(lesson2);

        EducationalTopicsLesson lesson4 = new EducationalTopicsLesson("الگوریتم ۱", 3, CourseType.Theory, 403);
        EducationalTopicsLesson lesson5 = new EducationalTopicsLesson("الگوریتم ۲", 3, CourseType.Theory, 404);

        Block blockAlgorithm = new Block("دروس تخصصی الگوریتم", 6);
        blockAlgorithm.setTatbighMode(TatbighMode.ALL);
        blockAlgorithm.addTatbighable(lesson4);
        blockAlgorithm.addTatbighable(lesson5);

        EducationalTopicsLesson lesson6 = new EducationalTopicsLesson("بهینه‌سازی ۱", 3, CourseType.Theory, 405);
        EducationalTopicsLesson lesson7 = new EducationalTopicsLesson("بهینه‌سازی ۲", 3, CourseType.Theory, 406);

        Block blockOptimization = new Block("دروس تخصصی بهینه‌سازی", 6);
        blockOptimization.setTatbighMode(TatbighMode.ALL);
        blockOptimization.addTatbighable(lesson6);
        blockOptimization.addTatbighable(lesson7);

        Block blockTakhasosi = new Block("دروس تخصصی", 6);
        blockTakhasosi.setTatbighMode(TatbighMode.ONE);
        blockTakhasosi.addTatbighable(blockOptimization);
        blockTakhasosi.addTatbighable(blockAlgorithm);

        Block rootBlock = new Block("ریشه", 9);
        rootBlock.setTatbighMode(TatbighMode.ALL);
        rootBlock.addTatbighable(blockAsli);
        rootBlock.addTatbighable(blockTakhasosi);

        EducationalMajor major1 = new EducationalMajor(
                new Major("Computer"),
                new Orientation("Minor CS"),
                1392
        );

        EducationalMajorRepository.getRepository().create(major1);

        EducationalTopics topics = new EducationalTopics(major1, rootBlock);
        EducationalTopicsRepository.getRepository().create(topics);
    }

    public static void initializeNtekhabVahed() {
        // create courses
        Course riazi1 = new Course("ریاضی ۱", 3, 101);
        riazi1.addCondtion(new MinimumRequiredCourseUnitCondition("حداقل واحد درس ریاضی ۱"));
        CourseRepository.getRepository().create(riazi1);

        Course riazi2 = new Course("ریاضی ۲", 3, 102);
        riazi2.addCondtion(new PishniaziCondition("پیش نیازی ریاضی ۱", riazi1));
        CourseRepository.getRepository().create(riazi2);

        Course andishe = new Course("اندیشه اسلامی", 3, 203);
        CourseRepository.getRepository().create(andishe);

        Course graph = new Course("نظریه گراف", 3, 104);
        CourseRepository.getRepository().create(graph);

        Course eco = new Course("اقتصاد مهندسی", 3, 105);
        CourseRepository.getRepository().create(eco);

        Course oo = new Course("مدل سازی شئ گرا", 3, 108);
        CourseRepository.getRepository().create(oo);

        Course soft2 = new Course("مهندسی نرم‌افزار ۲", 3, 109);
        CourseRepository.getRepository().create(soft2);

        // create course offers
        CourseOffer riazi1OldOffer = new CourseOffer("Class 1", "09:00AM", new SemesterIdentifier(1395, 1), riazi1);
        CourseOffer andisheOldOffer = new CourseOffer("Class 2", "10:30AM", new SemesterIdentifier(1395, 1), andishe);
        CourseOffer graphOldOffer = new CourseOffer("Class 3", "14:00PM", new SemesterIdentifier(1395, 1), graph);
        CourseOffer ecoOldOffer = new CourseOffer("Class 5", "16:00PM", new SemesterIdentifier(1395, 1), eco);

        CourseOfferRepository.getRepository().create(riazi1OldOffer);
        CourseOfferRepository.getRepository().create(andisheOldOffer);
        CourseOfferRepository.getRepository().create(graphOldOffer);
        CourseOfferRepository.getRepository().create(ecoOldOffer);

        CourseOffer riazi1Offer = new CourseOffer("Class 3", "10:30AM", new SemesterIdentifier(1395, 2), riazi1);
        CourseOffer riazi2Offer = new CourseOffer("Class 4", "10:30AM", new SemesterIdentifier(1395, 2), riazi2);
        CourseOffer ooOffer = new CourseOffer("Class 8", "09:00AM", new SemesterIdentifier(1395, 2), oo);
        CourseOffer soft2Offer = new CourseOffer("Class 12", "14:00AM", new SemesterIdentifier(1395, 2), soft2);

        riazi1Offer.addCondtiotion(new GenderCondition("مردانه"));
        riazi2Offer.addCondtiotion(new UniEntryCondition("ورودی ۹۵ای ها"));

        CourseOfferRepository.getRepository().create(riazi1Offer);
        CourseOfferRepository.getRepository().create(riazi2Offer);
        CourseOfferRepository.getRepository().create(ooOffer);
        CourseOfferRepository.getRepository().create(soft2Offer);

        EducationalMajor major = EducationalMajorRepository.getRepository().readByMajorOrientationYear(
                new Major("Computer"),
                new Orientation("Software"),
                1392
        );

        EducationalMajor minor = EducationalMajorRepository.getRepository().readByMajorOrientationYear(
                new Major("Computer"),
                new Orientation("Minor CS"),
                1392
        );

        // create individual
        Individual individual = new Individual("09102005", "نهال", "میرزایی");
        IndividualRepository.getRepository().create(individual);

        Student student = new Student(individual, "810192489", major);
        student.addMinor(minor);

        // create last semester
        SemesterStatus semesterStatusOld = new SemesterStatus(individual.getFirstName() + individual.getLastName(), student.getStudentNumber(), new SemesterIdentifier(1395, 1));

        AttendedCourse riazi1Attended = new AttendedCourseFromThisUni(individual.getFirstName() + individual.getLastName(), student.getStudentNumber(), riazi1OldOffer);
        AttendedCourse andisheAttended = new AttendedCourseFromThisUni(individual.getFirstName() + individual.getLastName(), student.getStudentNumber(), andisheOldOffer);
        AttendedCourse graphAttended = new AttendedCourseFromThisUni(individual.getFirstName() + individual.getLastName(), student.getStudentNumber(), graphOldOffer);
        AttendedCourse ecoAttended = new AttendedCourseFromThisUni(individual.getFirstName() + individual.getLastName(), student.getStudentNumber(), ecoOldOffer);

        andisheAttended.setManualTatbighUniqueId(103);

        AttendedCourseRepository.getRepository().create(riazi1Attended);
        AttendedCourseRepository.getRepository().create(andisheAttended);
        AttendedCourseRepository.getRepository().create(graphAttended);
        AttendedCourseRepository.getRepository().create(ecoAttended);

        semesterStatusOld.addAttendedCourse(riazi1Attended);
        semesterStatusOld.addAttendedCourse(andisheAttended);
        semesterStatusOld.addAttendedCourse(graphAttended);
        semesterStatusOld.addAttendedCourse(ecoAttended);

        // create this semester
        SemesterStatus semesterStatus = new SemesterStatus(individual.getFirstName() + individual.getLastName(), student.getStudentNumber(), new SemesterIdentifier(1395, 2));

        student.addSemesterStatus(semesterStatusOld);
        student.addSemesterStatus(semesterStatus);

        StudentRepository.getRepository().create(student);
    }

    public static void initializeNtekhabVahedMinor() {
        // create courses
        Course dm = new Course("ساختمان گسسته", 3, 401);
        CourseRepository.getRepository().create(dm);

        Course ds = new Course("ساختمان داده", 3, 402);
        ds.addCondtion(new PishniaziCondition("پیش نیازی ساختمان گسسته", dm));
        CourseRepository.getRepository().create(ds);

        Course alg1 = new Course("الگوریتم مقدماتی", 3, 403);
        CourseRepository.getRepository().create(alg1);

        Course alg2 = new Course("الگوریتم پیشرفته", 3, 404);
        alg2.addCondtion(new PishniaziCondition("پیش نیازی الگوریتم مقدماتی", alg1));
        CourseRepository.getRepository().create(alg2);

        // create course offers
        CourseOffer dmOffer = new CourseOffer("Class 401", "09:00AM", new SemesterIdentifier(1395, 2), dm);
        CourseOffer dsOffer = new CourseOffer("Class 403", "10:30AM", new SemesterIdentifier(1395, 2), ds);
        CourseOffer alg1Offer = new CourseOffer("Class 410", "14:00PM", new SemesterIdentifier(1395, 2), alg1);
        CourseOffer alg2Offer = new CourseOffer("Class 402", "16:00PM", new SemesterIdentifier(1395, 2), alg2);

        CourseOfferRepository.getRepository().create(dmOffer);
        CourseOfferRepository.getRepository().create(dsOffer);
        CourseOfferRepository.getRepository().create(alg1Offer);
        CourseOfferRepository.getRepository().create(alg2Offer);
    }

    public static void NtekhabVahedScenario() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter student id:");

        String sid = scan.nextLine();
        Student student = StudentRepository.getRepository().readByStudentNumber(sid);

        System.out.println("Hello " + student.getIndividual().getFirstName());

        List<CourseOffer> courseOffers = NtekhabVahed.getInstance().getCurrentSemesterCourseOffers();

        while (true) {
            System.out.println("This semester course offers: ");
            for (CourseOffer courseOffer : courseOffers)
                System.out.println(courseOffer.getId().toString() + " : " + courseOffer.getCourse().getName() + " (" + courseOffer.getCourse().getCourseUniqueId() + ") ");

            System.out.println("Your courses this semester: ");
            for (AttendedCourse attendedCourse : student.getAttendedCourses(NtekhabVahed.getCurrentSemester()))
                System.out.println(attendedCourse.getCourseName() + " (" + attendedCourse.getCourseUniqueId() + ")");

            System.out.println("Enter id [add 10000 for getting as minor]: ");
            int targetId = scan.nextInt();
            boolean minor = (targetId >= 10000);
            if (minor)
                targetId -= 10000;

            if (targetId <= 0)
                break;

            CourseOffer target = null;
            for (CourseOffer courseOffer : courseOffers)
                if (courseOffer.getId() == targetId) {
                    target = courseOffer;
                    break;
                }

            boolean result = false;
            if (!minor)
                result = NtekhabVahed.getInstance().getCourseOffer(student, target);
            else {
                result = NtekhabVahed.getInstance().getCourseOfferAsMinor(student, target);
                System.out.println("=== MINOR ===");
            }

            if (result)
                System.out.println("Successful");
            else
                System.out.println("You cannot attend this course.");
        }

        System.out.println("end");
    }

    public static void NtekhabVahedAuto(String sid) {
        Student student = StudentRepository.getRepository().readByStudentNumber(sid);

        System.out.println("Hello " + student.getIndividual().getFirstName());

        List<CourseOffer> courseOffers = NtekhabVahed.getInstance().getCurrentSemesterCourseOffers();

        for (CourseOffer courseOffer : courseOffers) {
            if (NtekhabVahed.getInstance().getCourseOffer(student, courseOffer))
                System.out.println(courseOffer.getCourse().getName() + " successful");
            else if (NtekhabVahed.getInstance().getCourseOfferAsMinor(student, courseOffer))
                System.out.println(courseOffer.getCourse().getName() + " successful");
            else
                System.out.println(courseOffer.getCourse().getName() + " unsuccessful");
        }

        System.out.println("This semester course offers: ");
        for (CourseOffer courseOffer : courseOffers)
            System.out.println(courseOffer.getId().toString() + " : " + courseOffer.getCourse().getName() + " (" + courseOffer.getCourse().getCourseUniqueId() + ") ");

        System.out.println("Your courses this semester: ");
        for (AttendedCourse attendedCourse : student.getAttendedCourses(NtekhabVahed.getCurrentSemester()))
            System.out.println(attendedCourse.getCourseName() + " (" + attendedCourse.getCourseUniqueId() + ")");

        System.out.println("end");
    }

    public static void FaraghatAzTahsilScenario() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nEnter student id:");

//        String sid = scan.nextLine();
        String sid = "810192489";  // #TODO remove this

        NtekhabVahedAuto(sid); // #TODO remove this

        Student student = StudentRepository.getRepository().readByStudentNumber(sid);

        FaraghatAzTahsil.getInstance().FareghKon(student);
    }

    public static void main(String[] args) {
        System.out.println("App started");

        createChart();
        createMinorChart();
        initializeNtekhabVahed();
        initializeNtekhabVahedMinor();

//        NtekhabVahedScenario();
        FaraghatAzTahsilScenario();

        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        HibernateUtil.shutdown();
    }
}
