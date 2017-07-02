package com.golestan.app.domain.MinorConditions;

import com.golestan.app.domain.AttendanceConditions.GPACondition;
import com.golestan.app.domain.Condition;
import com.golestan.app.domain.Course.MinimumRequiredCourseUnitCondition;
import com.golestan.app.domain.CourseOffer.CourseOffer;
import com.golestan.app.domain.Student.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mehdithreem on 7/2/2017 AD.
 */
public class MinorConditions {
    private static MinorConditions singleton = new MinorConditions();
    public static MinorConditions getInstance() {
        return singleton;
    }

    private List<Condition> conditions;

    public MinorConditions() {
        this.conditions = new ArrayList<Condition>();

        this.conditions.add(new MinimumRequiredGPA("حداقل واحد اخذ شده برای Minor"));
        this.conditions.add(new MinimumRequiredCourseUnitCondition("حداقل واحد مورد نیاز برای Minor"));
    }

    public boolean isMojaz(Student student) {
        for( Condition condition: this.conditions) {
            if (!condition.is_justify(student, null))
                return false;
        }

        return true;
    }
}
