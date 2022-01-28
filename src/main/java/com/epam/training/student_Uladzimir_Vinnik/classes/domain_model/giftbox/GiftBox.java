package com.epam.training.student_Uladzimir_Vinnik.classes.domain_model.giftbox;


import com.epam.training.student_Uladzimir_Vinnik.classes.domain_model.candies.Candy;
import com.epam.training.student_Uladzimir_Vinnik.classes.domain_model.util.Finding;
import com.epam.training.student_Uladzimir_Vinnik.classes.domain_model.util.Sorting;

import java.util.ArrayList;
import java.util.List;


/**
 * Class Description:
 * Implement interfaces: Sorting and Finding and
 * their methods for sorting candies by name or weight and
 * finding candies by parameters.
 * <p>
 */
public class GiftBox implements Finding, Sorting {
    /**
     * No actions are required for class variable candiesList.
     */
    private List<Candy> candiesList;

    /**
     * No actions are required for constructor GiftBox().
     */
    public GiftBox() {
        candiesList = new ArrayList<Candy>();
    }

    /**
     * No actions are required for method addCandy().
     */
    public void addCandy(Candy candy) {
        this.candiesList.add(candy);
    }

    /**
     * Implement sorting of candiesList by its names in ascending order
     * and return sorted by name ascending list of candies.
     */
    @Override
    public List<Candy> sortCandiesByNameAsc() {
        if (candiesList == null || candiesList.isEmpty()) {
            throw new UnsupportedOperationException(" candleList is empty or null.");
        }
        Candy candyBox;
        for (int i = 0; i < candiesList.size(); i++) {
            for (int j = 0; j < candiesList.size() - (i + 1); j++) {
                if (candiesList.get(j).getName().compareTo(candiesList.get(j + 1).getName()) > 0) {
                    candyBox = candiesList.get(j);
                    candiesList.set(j, candiesList.get(j + 1));
                    candiesList.set(j + 1, candyBox);
                }
            }
        }
        return candiesList;
    }

    /**
     * Implement sorting of candiesList by its weight in ascending order
     * and return sorted by weight ascending list of candies.
     */
    @Override
    public List<Candy> sortCandiesByWeightAsc() {
        if (candiesList == null || candiesList.isEmpty()) {
            throw new UnsupportedOperationException(" candleList is empty or null.");
        }
        Candy candyBox;
        for (int i = 0; i < candiesList.size(); i++) {
            for (int j = 0; j < candiesList.size() - (i + 1); j++) {
                if (candiesList.get(j).getWeight() > candiesList.get(j + 1).getWeight()) {
                    candyBox = candiesList.get(j);
                    candiesList.set(j, candiesList.get(j + 1));
                    candiesList.set(j + 1, candyBox);
                }
            }
        }
        return candiesList;
    }

    /**
     * Implement selection of candies from candiesList with names started with candyNameFirstLetter
     * and return list of candies which names started with candyNameFirstLetter in name ascending list of candies.
     */
    @Override
    public List<Candy> findCandiesByNameStartedWith(char candyNameFirstLetter) {
        if (candiesList == null || candiesList.isEmpty()) {
            throw new UnsupportedOperationException(" candleList is empty or null.");
        }

        List<Candy> candyByFirstLetter = new ArrayList<>();
        for (Candy each : candiesList) {
            if (each.getName().length() > 0) {
                if (String.valueOf(candyNameFirstLetter).equalsIgnoreCase(each.getName().split("")[0])) {
                    candyByFirstLetter.add(each);
                }
            }
        }
        return candyByFirstLetter;
    }

    /**
     * Implement selection ot candies from candiesList so that its [weightFrom <= weight => weightTo]
     * and return list of candies with weight in range [weightFrom, weightTo] in weight ascending list of candies.
     */
    @Override
    public List<Candy> findCandiesByWeightInRange(int weightFrom, int weightTo) {
        if (candiesList == null || candiesList.isEmpty()) {
            throw new UnsupportedOperationException(" candleList is empty or null.");
        }

        List<Candy> candyInRange = new ArrayList<>();
        for (Candy each : candiesList) {
            if (each.getWeight() >= weightFrom && each.getWeight() <= weightTo) {
                candyInRange.add(each);
            }
        }
        return candyInRange;
    }

    public void printCandies() {
        for (Candy each : candiesList) {
            System.out.print(String.format("%s  %d;  ", each.getName(), each.getWeight()));
        }
        System.out.println();
    }

    public void printCandies(List<Candy> candies) {
        for (Candy each : candies) {
            System.out.print(String.format("%s  %d;  ", each.getName(), each.getWeight()));
        }
        System.out.println();
    }

}
