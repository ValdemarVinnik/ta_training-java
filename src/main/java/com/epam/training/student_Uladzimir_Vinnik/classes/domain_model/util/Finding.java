package com.epam.training.student_Uladzimir_Vinnik.classes.domain_model.util;


import com.epam.training.student_Uladzimir_Vinnik.classes.domain_model.candies.Candy;

import java.util.*;

public interface Finding {

    /**
     * No actions are required within the interface
     */

    List<Candy> findCandiesByNameStartedWith(char candyNameFirstLetter);

    List<Candy> findCandiesByWeightInRange(int weightFrom, int weightTo);
}
