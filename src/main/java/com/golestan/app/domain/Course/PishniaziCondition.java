package com.golestan.app.domain.Course;

import com.golestan.app.application.NtekhabVahed;
import com.golestan.app.domain.AttendedCourse.AttendedCourse;
import com.golestan.app.domain.Condition;
import com.golestan.app.domain.CourseOffer.CourseOffer;
import com.golestan.app.domain.Semester;
import com.golestan.app.domain.SemesterIdentifier;
import com.golestan.app.domain.Student.License;
import com.golestan.app.domain.Student.SemesterStatus;
import com.golestan.app.domain.Student.Student;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.List;

/**
 * Created by mehdithreem on 5/20/2017 AD.
 */

@Entity
@DiscriminatorValue("PISHNIAZI")
public class PishniaziCondition extends Condition {

    @OneToOne
    private Course pishniaz;

    public PishniaziCondition(String title, Course pishniaz) {
        super(title);
        this.pishniaz = pishniaz;
    }

    protected PishniaziCondition() {}

    public boolean is_justify(Student student, CourseOffer courseOffer) {
        for( SemesterStatus semesterStatus:  student.getSemesterIdentifierCourseGetterMap().values()) {
            List <AttendedCourse> attendedCourses = semesterStatus.getAttendedCourses();
            for( AttendedCourse attendedCourse : attendedCourses){
                if(attendedCourse.getCourseUniqueId().equals(pishniaz.getCourseUniqueId()))
                    return true;
            }
        }

        for(License license : student.getSemesterIdentifierCourseGetterMap().get(NtekhabVahed.getCurrentSemester()).getLicenses()) {
            if (license.getTitle().equals("Minor Get") && license.getCourseUniqueId().equals(courseOffer.getCourse().getCourseUniqueId())) {
                System.out.print("Minor Get pishniaz license used");
                return true;
            }
        }

        System.out.println("Pishniazi " + this.pishniaz.getName() + " failed");
        return false;
    }
}
