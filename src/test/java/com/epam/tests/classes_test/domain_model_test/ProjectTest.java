package com.epam.tests.classes_test.domain_model_test;


import com.epam.training.student_Uladzimir_Vinnik.classes.domain_model.candies.Candy;
import com.epam.training.student_Uladzimir_Vinnik.classes.domain_model.candies.CandyBase;
import com.epam.training.student_Uladzimir_Vinnik.classes.domain_model.giftbox.GiftBox;
import com.epam.training.student_Uladzimir_Vinnik.classes.domain_model.util.Finding;
import com.epam.training.student_Uladzimir_Vinnik.classes.domain_model.util.Sorting;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjectTest {

    @Test
    public void shouldClassesAreInProperPackages() {
        assertEquals("package com.epam.training.student_Uladzimir_Vinnik.classes.domain_model.candies", CandyBase.class.getPackage().toString(), "Class CandyBase is not in package 'com.epam.tat.domainmodel.candies'");
        assertEquals("package com.epam.training.student_Uladzimir_Vinnik.classes.domain_model.candies", Candy.class.getPackage().toString(), "Class Candy is not in package 'com.epam.tat.domainmodel.candies'");
        assertEquals("package com.epam.training.student_Uladzimir_Vinnik.classes.domain_model.giftbox", GiftBox.class.getPackage().toString(), "Class GiftBox is not in package 'com.epam.tat.domainmodel.giftbox'");
        assertEquals("package com.epam.training.student_Uladzimir_Vinnik.classes.domain_model.util", Finding.class.getPackage().toString(), "Interface Finding is not in package 'com.epam.tat.domainmodel.util'");
        assertEquals("package com.epam.training.student_Uladzimir_Vinnik.classes.domain_model.util", Sorting.class.getPackage().toString(), "Interface Sorting is not in package 'com.epam.tat.domainmodel.util'");
    }

    @Test
    public void shouldCandyGetWeightReturnWeight() {
        Candy testCandy = new Candy("Bounty", 18);
        assertEquals(18, testCandy.getWeight(), "Method of 'getWeight' of Candy return wrong value");
    }

    @Test
    public void shouldCandySetWeightChangeWeightValue() {
        Candy testCandy = new Candy("Bounty", 18);
        testCandy.setWeight(5);
        assertEquals(5, testCandy.getWeight(), "Candy has wrong weight after set using 'setWeight' call");
    }
}
