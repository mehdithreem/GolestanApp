package com.golestan.app.data.EducationalMajor;

import static org.junit.Assert.*;

import com.golestan.app.domain.EducationalMajor.EducationalMajor;
import com.golestan.app.domain.EducationalMajor.Major;
import com.golestan.app.domain.EducationalMajor.Orientation;
import org.junit.Test;

/**
 * Created by mehdithreem on 6/4/2017 AD.
 */
public class EducationalMajorRepositoryTest {
    @Test
    public void Test() {
        EducationalMajor major1 = new EducationalMajor(
                new Major("Computer"),
                new Orientation("Software"),
                1392
        );

        EducationalMajor major2 = new EducationalMajor(
                new Major("Computer"),
                new Orientation("Hardware"),
                1392
        );

        EducationalMajorRepository.getRepository().create(major1);
        EducationalMajorRepository.getRepository().create(major2);

        EducationalMajor readMajor1 = EducationalMajorRepository.getRepository().readByMajorOrientationYear(
                new Major("Computer"),
                new Orientation("Software"),
                1392
        );

        assertEquals(major1.getId(), readMajor1.getId());

        EducationalMajor readMajor2 = EducationalMajorRepository.getRepository().readByMajorOrientationYear(
                new Major("Computer"),
                new Orientation("Hardware"),
                1392
        );

        assertEquals(major2.getId(), readMajor2.getId());
    }
}
