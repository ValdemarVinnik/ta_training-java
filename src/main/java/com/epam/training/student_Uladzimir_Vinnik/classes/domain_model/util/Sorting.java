package com.epam.training.student_Uladzimir_Vinnik.classes.domain_model.util;



import com.epam.training.student_Uladzimir_Vinnik.classes.domain_model.candies.Candy;

import java.util.List;

public interface Sorting {

    /**
     * No actions are required within the interface
     */
    List<Candy> sortCandiesByNameAsc();

    List<Candy> sortCandiesByWeightAsc();
}
