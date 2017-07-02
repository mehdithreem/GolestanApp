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

    @Column(name = "course_unique_id")
    private Integer courseUniqueId;

    public License(String title) {
        this.title = title;
    }

    protected License() {}

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

    public Integer getCourseUniqueId() {
        return courseUniqueId;
    }

    public void setCourseUniqueId(Integer courseUniqueId) {
        this.courseUniqueId = courseUniqueId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        License license = (License) o;

        if (!title.equals(license.title)) return false;
        return courseUniqueId != null ? courseUniqueId.equals(license.courseUniqueId) : license.courseUniqueId == null;
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + (courseUniqueId != null ? courseUniqueId.hashCode() : 0);
        return result;
    }
}
