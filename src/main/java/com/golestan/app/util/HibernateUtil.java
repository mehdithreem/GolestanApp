package com.golestan.app.util;

/**
 * Created by mehdithreem on 5/19/2017 AD.
 */
import com.golestan.app.domain.AttendanceConditions.EducationalTopicsMatchCondition;
import com.golestan.app.domain.AttendanceConditions.GPACondition;
import com.golestan.app.domain.AttendanceConditions.OverlapCondition;
import com.golestan.app.domain.AttendedCourse.AttendedCourse;
import com.golestan.app.domain.AttendedCourse.AttendedCourseFromOtherUni;
import com.golestan.app.domain.AttendedCourse.AttendedCourseFromThisUni;
import com.golestan.app.domain.Condition;
import com.golestan.app.domain.Course.*;
import com.golestan.app.domain.CourseOffer.CourseOffer;
import com.golestan.app.domain.CourseOffer.GenderCondition;
import com.golestan.app.domain.CourseOffer.UniEntryCondition;
import com.golestan.app.domain.EducationalMajor.EducationalMajor;
import com.golestan.app.domain.EducationalMajor.Major;
import com.golestan.app.domain.EducationalMajor.Orientation;
import com.golestan.app.domain.EducationalTopics.Block;
import com.golestan.app.domain.EducationalTopics.EducationalTopics;
import com.golestan.app.domain.EducationalTopics.EducationalTopicsLesson;
import com.golestan.app.domain.EducationalTopics.Tatbighable;
import com.golestan.app.domain.Employee.Employee;
import com.golestan.app.domain.Person.Individual;
import com.golestan.app.domain.Professor.CourseManager;
import com.golestan.app.domain.Professor.Professor;
import com.golestan.app.domain.SemesterIdentifier;
import com.golestan.app.domain.Student.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                    .configure( "hibernate.cfg.xml" )
                    .build();

            System.out.println("1");

            Metadata metadata = new MetadataSources( standardRegistry )
                    .addPackage("com.golestan.app.domain")
                    .addAnnotatedClass(Condition.class)
                    .addAnnotatedClass(SemesterIdentifier.class)
                    .addPackage("com.golestan.app.domain.AttendedCourse")
                        .addAnnotatedClass(AttendedCourse.class)
                        .addAnnotatedClass(AttendedCourseFromOtherUni.class)
                        .addAnnotatedClass(AttendedCourseFromThisUni.class)
                    .addPackage("com.golestan.app.domain.Course")
                        .addAnnotatedClass(Course.class)
                        .addAnnotatedClass(ExclusiveCourseCondition.class)
                        .addAnnotatedClass(HamniaziCondition.class)
                        .addAnnotatedClass(MinimumRequiredCourseUnitCondition.class)
                        .addAnnotatedClass(PishniaziCondition.class)
                    .addPackage("com.golestan.app.domain.CourseOffer")
                        .addAnnotatedClass(CourseOffer.class)
                        .addAnnotatedClass(GenderCondition.class)
                        .addAnnotatedClass(UniEntryCondition.class)
                    .addPackage("com.golestan.app.domain.EducationalMajor")
                        .addAnnotatedClass(EducationalMajor.class)
                        .addAnnotatedClass(Major.class)
                        .addAnnotatedClass(Orientation.class)
                    .addPackage("com.golestan.app.domain.EducationalTopics")
                        .addAnnotatedClass(Tatbighable.class)
                        .addAnnotatedClass(Block.class)
                        .addAnnotatedClass(EducationalTopics.class)
                        .addAnnotatedClass(EducationalTopicsLesson.class)
                    .addPackage("com.golestan.app.domain.Person")
                        .addAnnotatedClass(Individual.class)
                        .addAnnotatedClass(Character.class)
                    .addPackage("com.golestan.app.domain.Employee")
                        .addAnnotatedClass(Employee.class)
                    .addPackage("com.golestan.app.domain.Professor")
                        .addAnnotatedClass(CourseManager.class)
                        .addAnnotatedClass(Professor.class)
                    .addPackage("com.golestan.app.domain.Student")
                        .addAnnotatedClass(SemesterStatus.class)
                        .addAnnotatedClass(GraduatedMatchForm.class)
                        .addAnnotatedClass(GuestStudent.class)
                        .addAnnotatedClass(License.class)
                        .addAnnotatedClass(Student.class)
                    .getMetadataBuilder()
                    .applyImplicitNamingStrategy( ImplicitNamingStrategyJpaCompliantImpl.INSTANCE )
                    .build();

            System.out.println("2");

            return metadata.getSessionFactoryBuilder().build();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }

}