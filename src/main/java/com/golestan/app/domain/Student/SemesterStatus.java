package com.golestan.app.domain.Student;

import com.golestan.app.data.AttendanceConditions.AttendedCourseRepository;
import com.golestan.app.domain.AttendedCourse.AttendedCourse;
import com.golestan.app.domain.AttendedCourse.AttendedCourseFromThisUni;
import com.golestan.app.domain.CourseOffer.CourseOffer;
import com.golestan.app.domain.SemesterIdentifier;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nahal on 5/19/2017 AD.
 */
@Entity
@Table(name = "SEMESTER_STATUS")
public class SemesterStatus {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "GPA")
    private int gpa;

    @Column(name = "STUDENT_FULL_NAME")
    private String studentFullName;

    @Column(name = "STUDENT_NUMBER")
    private String studentNumber;

    @Embedded
    private SemesterIdentifier semesterIdentifier;

    @OneToMany(fetch = FetchType.EAGER)
    private List<License> licenses;

    @OneToMany(fetch = FetchType.LAZY)
    private List<AttendedCourse> attendedCourses;

    public SemesterStatus(String fullName, String studentNumber, SemesterIdentifier semesterIdentifier) {
        this.studentFullName = fullName;
        this.studentNumber = studentNumber;
        this.status = "در حال اخذ";
        this.gpa = 0;
        this.licenses = new ArrayList<License>();
        this.attendedCourses = new ArrayList<AttendedCourse>();
        this.semesterIdentifier = semesterIdentifier;
    }

    protected SemesterStatus() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<AttendedCourse> getAttendedCourses() {
        return attendedCourses;
    }

    public void setAttendedCourses(List<AttendedCourse> attendedCourses) {
        this.attendedCourses = attendedCourses;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getGpa() {
        return gpa;
    }

    public void setGpa(int gpa) {
        this.gpa = gpa;
    }

    public List<License> getLicenses() {
        return licenses;
    }

    public void setLicenses(List<License> licenses) {
        this.licenses = licenses;
    }

    public String getStudentFullName() {
        return studentFullName;
    }

    public void setStudentFullName(String studentFullName) {
        this.studentFullName = studentFullName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void addAttendedCourse(AttendedCourse attendedCourse) {
        this.attendedCourses.add(attendedCourse);
    }

    public void addLicense(License license) {
        this.licenses.add(license);
    }


    public SemesterIdentifier getSemesterIdentifier() {
        return semesterIdentifier;
    }

    public void setSemesterIdentifier(SemesterIdentifier semesterIdentifier) {
        this.semesterIdentifier = semesterIdentifier;
    }

    public void register(CourseOffer courseOffer) {
        AttendedCourseFromThisUni attended = new AttendedCourseFromThisUni(studentFullName, studentNumber, courseOffer);
        AttendedCourseRepository.getRepository().create(attended);

        this.attendedCourses.add(attended);
    }

    public boolean findLicense(License license) {
        for(License l: licenses) {
            if (l.equals(license))
                return true;
        }
        return false;
    }
}
