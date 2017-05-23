package com.golestan.app.data;

/**
 * Created by mehdithreem on 5/23/2017 AD.
 */
public class LicenseRepository {
    private static LicenseRepository theRepository = new LicenseRepository();
    public static LicenseRepository getRepository() {
        return theRepository;
    }
}
