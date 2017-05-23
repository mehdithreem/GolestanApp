package com.golestan.app.domain.AttendanceConditions;

import com.golestan.app.domain.Condition;
import com.golestan.app.domain.CourseOffer.CourseOffer;
import com.golestan.app.domain.Student.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mehdithreem on 5/23/2017 AD.
 */
public class AttendanceConditions {
    private static AttendanceConditions singleton = new AttendanceConditions();
    public static AttendanceConditions getRepository() {
        return singleton;
    }

    private List<Condition> conditions;

    public AttendanceConditions() {
        this.conditions = new ArrayList<Condition>();

        this.conditions.add(new GPACondition("حداکثر واحد اخذ شده بر حسب معدل"));
        this.conditions.add(new OverlapCondition("عدم همپوشانی دروس اخذ شده"));
        this.conditions.add(new EducationalTopicsMatchCondition("تطابق با سرفصل"));
    }

    public boolean isMojaz(Student student, CourseOffer courseOffer) {
        return true;
    }
}
