package com.golestan.app.data;

/**
 * Created by mehdithreem on 5/23/2017 AD.
 */
public class AttendedCourseRepository {
    private static AttendedCourseRepository theRepository = new AttendedCourseRepository();
    public static AttendedCourseRepository getRepository() {
        return theRepository;
    }
}
