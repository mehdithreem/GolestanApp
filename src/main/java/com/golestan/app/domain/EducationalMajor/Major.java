package com.golestan.app.domain.EducationalMajor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by nahal on 5/19/2017 AD.
 */

@Entity
@Table(name = "Major")
public class Major {

    @OneToMany(fetch = FetchType.EAGER)
    private List<Orientation> orientationList;
}
