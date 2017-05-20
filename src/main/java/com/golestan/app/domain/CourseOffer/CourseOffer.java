package com.golestan.app.domain.CourseOffer;

import com.golestan.app.domain.Condition;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by nahal on 5/20/2017 AD.
 */

@Entity
@Table(name = "CourseOffer")
public class CourseOffer {

    @Column( name = "PLACE")
    private String place;

    @Column( name = "DATE")
    private Date date;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Condition> policies;

}
