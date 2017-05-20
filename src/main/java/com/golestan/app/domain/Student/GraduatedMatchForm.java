package com.golestan.app.domain.Student;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.util.List;
import java.util.Map;

/**
 * Created by nahal on 5/19/2017 AD.
 */

@Embeddable
public class GraduatedMatchForm {

    @ElementCollection
    private Map<String, String> matchForm;

    public Map<String, String> getMatchForm() {
        return matchForm;
    }

    public void setMatchForm(Map<String, String> matchForm) {
        this.matchForm = matchForm;
    }
}
