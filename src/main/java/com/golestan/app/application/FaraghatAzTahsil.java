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
        EducationalMajor educationalMajor = student.getEducationalMajor();
        //repo is not implemented
        EducationalTopics educationalTopics = EducationalTopicsRepository
                                                .getRepository()
                                                .readByEducationalMajorWithBlocks(educationalMajor);
        List<AttendedCourse> attendedCourses = student.getAttendedCourses();
        boolean tatbighed = educationalTopics.IsTatbigh(attendedCourses);
    }
}
