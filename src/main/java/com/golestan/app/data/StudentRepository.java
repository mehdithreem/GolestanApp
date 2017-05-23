package com.golestan.app.data;

/**
 * Created by mehdithreem on 5/23/2017 AD.
 */
public class StudentRepository {
    private static StudentRepository theRepository = new StudentRepository();
    public static StudentRepository getRepository() {
        return theRepository;
    }


}
