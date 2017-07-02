package com.golestan.app.domain.EducationalTopics;


import com.golestan.app.domain.AttendedCourse.AttendedCourse;

import javax.persistence.*;
import java.util.List;

/**
 * Created by nahal on 5/20/2017 AD.
 */


@Entity
@Table(name = "Educational_Topics_Lesson")
public class EducationalTopicsLesson extends Tatbighable {

    @Column( name = "NAME")
    private String name;

    @Column( name = "COURSE_UNIT")
    private int courseUnit;

    @Enumerated(EnumType.STRING)
    @Column( name = "COURSE_TYPE")
    private CourseType courseType;

    @Column(name="COURSE_UNIQUE_ID")
    private Integer courseUniqueId;

    public EducationalTopicsLesson(String name, int courseUnit, CourseType courseType, Integer courseUniqueId) {
        this.name = name;
        this.courseUnit = courseUnit;
        this.courseType = courseType;
        this.courseUniqueId = courseUniqueId;
    }

    protected EducationalTopicsLesson() {
    }

    public Integer getCourseUniqueId() {
        return courseUniqueId;
    }

    public void setCourseUniqueId(Integer courseUniqueId) {
        this.courseUniqueId = courseUniqueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourseUnit() {
        return courseUnit;
    }

    public void setCourseUnit(int courseUnit) {
        this.courseUnit = courseUnit;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    public ITatbighed tatbigh(List<AttendedCourse> attendedCourses) {
        Boolean tatbighed = false;
        Integer tatbighCount = 0;

        for(AttendedCourse attendedCourse: attendedCourses) {
            if (attendedCourse.getCourseUniqueId().equals(courseUniqueId)) {
                tatbighed = true;
                tatbighCount = courseUnit;
                attendedCourses.remove(attendedCourse);

                System.out.println("\t\t"
                        + attendedCourse.getCourseName()
                        + " (" + attendedCourse.getCourseUniqueId() + ") tatbighed with " +
                        this.name + " (" + this.courseUniqueId + ")");

                break;
            }
        }

        if (tatbighed == true) {
            for(AttendedCourse attendedCourse: attendedCourses) {
                if (attendedCourse.getManualTatbighUniqueId().equals(courseUniqueId)) {
                    tatbighed = true;
                    tatbighCount = courseUnit;
                    attendedCourses.remove(attendedCourse);

                    System.out.println("\t\t"
                            + attendedCourse.getCourseName()
                            + " (" + attendedCourse.getCourseUniqueId() + ") MANUALLY tatbighed with " +
                            this.name + " (" + this.courseUniqueId + ")");

                    break;
                }
            }
        }

        return new MyTatbighed(tatbighed, tatbighCount);
    }

    public Integer minUnit() {
        return courseUnit;
    }
}
