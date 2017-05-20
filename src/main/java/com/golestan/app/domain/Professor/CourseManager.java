package com.golestan.app.domain.Professor;

import com.golestan.app.domain.CourseOffer.CourseOffer;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by nahal on 5/19/2017 AD.
 */

@Embeddable
public class CourseManager {
    @OneToMany(fetch = FetchType.EAGER)
    private List<CourseOffer> courseOfferList;
}
