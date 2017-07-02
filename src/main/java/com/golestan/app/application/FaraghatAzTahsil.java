package com.golestan.app.application;

import com.golestan.app.data.EducationalTopics.EducationalTopicsRepository;
import com.golestan.app.domain.AttendedCourse.AttendedCourse;
import com.golestan.app.domain.EducationalMajor.EducationalMajor;
import com.golestan.app.domain.EducationalTopics.EducationalTopics;
import com.golestan.app.domain.Student.Student;

import java.util.List;

/**
 * Created by nahal on 6/3/2017 AD.
 */
public class FaraghatAzTahsil {
    private static FaraghatAzTahsil theRepository = new FaraghatAzTahsil();
    public static FaraghatAzTahsil getInstance() {
        return theRepository;
    }

    public void FareghKon(Student student){
        List<AttendedCourse> attendedCourses = student.getAttendedCourses();
        EducationalMajor educationalMinor = student.getEducationalMinor();
        boolean tatbighedMinor = true;

        if (educationalMinor != null) {
            EducationalTopics educationalTopics = EducationalTopicsRepository
                    .getRepository()
                    .readByEducationalMajorWithBlocks(educationalMinor);

            tatbighedMinor = educationalTopics.isTatbighed(attendedCourses);

            if (tatbighedMinor)
                System.out.println("- Minor Tatbighed.");
            else
                System.out.println("- Minor Not Tatbighed");
        }

        boolean tatbighed = FareghKonMajor(student, attendedCourses);

        if (tatbighed)
            System.out.println("- Major Tatbighed.");
        else
            System.out.println("- Major Not Tatbighed");

        if (tatbighed && tatbighedMinor)
            System.out.println("Tatbighed.");
        else
            System.out.println("Not Tatbighed");
    }

    private boolean FareghKonMajor(Student student, List<AttendedCourse> attendedCourses) {
        EducationalMajor educationalMajor = student.getEducationalMajor();
        EducationalTopics educationalTopics = EducationalTopicsRepository
                .getRepository()
                .readByEducationalMajorWithBlocks(educationalMajor);

        return educationalTopics.isTatbighed(attendedCourses);
    }
}
