package com.golestan.app.domain.EducationalTopics;

/**
 * Created by mehdithreem on 6/5/2017 AD.
 */
public class MyTatbighed implements ITatbighed {
    private boolean isTatbighed;
    private Integer tatbighed;

    public MyTatbighed(boolean isTatbighed, Integer tatbighed) {
        this.isTatbighed = isTatbighed;
        this.tatbighed = tatbighed;
    }

    public boolean isTatbighed() {
        return isTatbighed;
    }

    public Integer tatbighedCount() {
        return tatbighed;
    }
}
