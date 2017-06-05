package com.golestan.app.domain.EducationalTopics;

import com.golestan.app.domain.AttendedCourse.AttendedCourse;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nahal on 5/20/2017 AD.
 */

@Entity
@Table(name = "BLOCK")
public class Block extends Tatbighable {
    @Column(name="name")
    private String name;

    @Column(name="unit_per_block")
    private Integer unitPerBlock;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Tatbighable> tatbighables;

    @Enumerated(EnumType.STRING)
    @Column( name = "TATBIGHED_MODE")
    private TatbighMode tatbighMode;

    public Block(String name, Integer unitPerBlock) {
        this.unitPerBlock = unitPerBlock;
        this.tatbighables = new ArrayList<Tatbighable>();
        this.name = name;
        tatbighMode = TatbighMode.SOME;
    }

    protected Block() {
    }

    public void addTatbighable(Tatbighable tatbighable) {
        this.tatbighables.add(tatbighable);
    }

    public TatbighMode getTatbighMode() {
        return tatbighMode;
    }

    public void setTatbighMode(TatbighMode tatbighMode) {
        this.tatbighMode = tatbighMode;
    }

    public Integer getUnitPerBlock() {
        return unitPerBlock;
    }

    public void setUnitPerBlock(Integer unitPerBlock) {
        this.unitPerBlock = unitPerBlock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tatbighable> getTatbighables() {
        return tatbighables;
    }

    public void setTatbighables(List<Tatbighable> tatbighables) {
        this.tatbighables = tatbighables;
    }

    public ITatbighed tatbigh(List<AttendedCourse> attendedCourses) {
        if (tatbighMode == TatbighMode.ALL)
            return tatbighAll(attendedCourses);
        else if (tatbighMode == TatbighMode.SOME)
            return tatbighSome(attendedCourses);
        else if (tatbighMode == TatbighMode.ONE)
            return tatbighOne(attendedCourses);

        return new MyTatbighed(false, 0);
    }

    private ITatbighed tatbighAll(List<AttendedCourse> attendedCourses) {
        Boolean result = true;
        Integer total = 0;
        for(Tatbighable tatbighable : tatbighables) {
            ITatbighed tatbighed = tatbighable.tatbigh(attendedCourses);
            result = result && tatbighed.isTatbighed();
            total = total + tatbighed.tatbighedCount();
        }

        return new MyTatbighed(result, total);
    }

    private ITatbighed tatbighSome(List<AttendedCourse> attendedCourses) {
        Integer total = 0;
        for(Tatbighable tatbighable : tatbighables) {
            ITatbighed tatbighed = tatbighable.tatbigh(attendedCourses);
            total = total + tatbighed.tatbighedCount();
        }

        return new MyTatbighed(total >= unitPerBlock , total);
    }

    private ITatbighed tatbighOne(List<AttendedCourse> attendedCourses) {
        Boolean result = false;
        Integer total = 0;
        for(Tatbighable tatbighable : tatbighables) {
            ITatbighed tatbighed = tatbighable.tatbigh(attendedCourses);
            result = result || tatbighed.isTatbighed();
            total = total + tatbighed.tatbighedCount();
        }

        return new MyTatbighed(result, total);
    }

    public Integer minUnit() {
        return unitPerBlock;
    }
}
