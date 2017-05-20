package com.golestan.app.domain.Professor;

import com.golestan.app.domain.CourseOffer.CourseOffer;

import javax.persistence.*;
import java.util.List;

/**
 * Created by nahal on 5/19/2017 AD.
 */

@Entity
@Table( name = "COURSE_MANAGER")
public class CourseManager {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;

    @OneToMany(fetch = FetchType.EAGER)
    private List<CourseOffer> courseOfferList;
}
