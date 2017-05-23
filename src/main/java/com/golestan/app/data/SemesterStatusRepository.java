package com.golestan.app.data;

import com.golestan.app.domain.Student.SemesterStatus;

/**
 * Created by mehdithreem on 5/23/2017 AD.
 */
public class SemesterStatusRepository {
    private static SemesterStatusRepository theRepository = new SemesterStatusRepository();
    public static SemesterStatusRepository getRepository() {
        return theRepository;
    }

    public void create(SemesterStatus semstat) {

    }
}
