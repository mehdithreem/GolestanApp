package com.golestan.app.domain.Student;

import javax.persistence.*;

/**
 * Created by nahal on 5/19/2017 AD.
 */

@Entity
@Table( name = "LICENSE")
public class License {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    public License() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
