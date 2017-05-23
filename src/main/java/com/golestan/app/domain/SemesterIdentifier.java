package com.golestan.app.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by mehdithreem on 5/20/2017 AD.
 */

@Embeddable
public class SemesterIdentifier {
    @Column(name= "YEAR")
    private Integer year;
    @Column(name= "SEMESTER")
    private Integer semester;

    public static final Integer firstSemester = 0;
    public static final Integer secondSemester = 1;

    public SemesterIdentifier() {
        this.year = null;
        this.semester = null;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public SemesterIdentifier(Integer year, Integer semester) {
        this.semester = semester;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SemesterIdentifier that = (SemesterIdentifier) o;

        if (!year.equals(that.year)) return false;
        return semester.equals(that.semester);
    }

    @Override
    public int hashCode() {
        int result = year.hashCode();
        result = 31 * result + semester.hashCode();
        return result;
    }
}
