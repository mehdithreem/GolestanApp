package com.golestan.app.application;

import com.golestan.app.data.CourseOfferRepository;
import com.golestan.app.domain.AttendanceConditions.AttendanceConditions;
import com.golestan.app.domain.CourseOffer.CourseOffer;
import com.golestan.app.domain.SemesterIdentifier;
import com.golestan.app.domain.Student.Student;

import java.util.List;

/**
 * Created by mehdithreem on 5/23/2017 AD.
 */
public class NtekhabVahed {
    private static NtekhabVahed theRepository = new NtekhabVahed();
    public static NtekhabVahed getInstance() {
        return theRepository;
    }


    private static SemesterIdentifier currentSemester = new SemesterIdentifier(1395,2);

    public List<CourseOffer> getCurrentSemesterCourseOffers() {
        return CourseOfferRepository.getRepository().readBySemesterWithCourse(currentSemester);
    }

    public boolean getCourseOffer(Student student, CourseOffer courseOffer) {
        boolean result = AttendanceConditions.getInstance().isMojaz(student, courseOffer);
        if (result) {
            student.registerCourseOffer(courseOffer, currentSemester);
        }

        return result;
    }
}
