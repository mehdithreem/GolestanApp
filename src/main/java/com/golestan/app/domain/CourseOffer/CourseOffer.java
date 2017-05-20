package com.golestan.app.domain.CourseOffer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

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


}
