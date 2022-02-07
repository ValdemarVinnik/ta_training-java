package com.epam.training.student_Uladzimir_Vinnik.collections.list_processor.impl;

import com.epam.training.student_Uladzimir_Vinnik.collections.list_processor.IListProcessor;
import com.epam.training.student_Uladzimir_Vinnik.collections.list_processor.exception.ListProcessorException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Function Description:
 * Complete the functions below. All methods must work with list of String.
 * <p>
 * In case of incorrect input values or inability to perform an action, the method should throw an appropriate
 * exception.
 */
public class ListProcessor implements IListProcessor {

    /**
     * Find the second by length string in a list.
     * <p>
     * Ex.:
     * From list:
     * {"a", "aa", "aaaaa", "aaaa", "aaa"}
     * will be return "aaaa"
     *
     * @param list - input data
     * @return second by length string in the input list
     */
    @Override
    public String getSecondStringByLength(List<String> list) {
        if (list == null) throw new ListProcessorException("The list is null...");
        if (list.size() < 2) throw new ListProcessorException("The list is wrong...");

        list.sort((o1, o2) -> o2.length() - o1.length());

        return list.get(1);
    }

    /**
     * Sort list by string length.
     * <p>
     * Ex.:
     * From list:
     * {"a", "aa", "aaA", "aAa", "aaa", "Aa"}
     * will be return
     * {"a", "Aa", "aa", "aAa", "aaA", "aaa"}
     *
     * @param list - input data
     * @return sort list by string length
     */
    @Override
    public List<String> getSortedListByLength(List<String> list) {
        if (list == null) throw new ListProcessorException("The list is null...");
        if (list.size() < 1) throw new ListProcessorException("The list is wrong...");

        list.sort(Comparator.comparingInt(String::length));
        return list;
    }

    /**
     * Sort list or array by count of vowels in string.
     * If the number of vowels in several words is the same, the order is alphabetical.
     * <p>
     * Ex.:
     * From list:
     * {"Puma", "Nike", "Timberland", "Adidas"}
     * will be return
     * {"Nike", "Puma", "Adidas", "Timberland"}
     *
     * @param list - input data
     * @return sort list by string length
     */
    @Override
    public List<String> getSortedListByCountOfVowels(List<String> list) {
        if (list == null) throw new ListProcessorException("The list is null...");
        if (list.size() < 1) throw new ListProcessorException("The list is wrong...");

        int countVowels = 0;
        for (String each: list) {countVowels += getCountOfVowels(each);}

        if(countVowels == 0) throw new ListProcessorException("There is no one vowels! ");

        list.sort(Comparator.comparing(ListProcessor::getCountOfVowels).thenComparing(String::compareTo));

        return list;
    }

    private static int getCountOfVowels(String word) {
        int count = 0;

        List<String> vowels = Arrays.asList("a", "e", "y", "u", "i", "o");
        for (String letter : word.trim().split("")) {
            if (vowels.contains(letter.toLowerCase())) {
                count++;
            }
        }
        return count;
    }

    /**
     * Sort list or array by count of consonants in string.
     * If the number of consonants in several words is the same, the order is alphabetical.
     * <p>
     * Ex.:
     * From list:
     * {"Puma", "Nike", "Timberland", "Adidas"}
     * will be return
     * {"Nike", "Puma", "Adidas", "Timberland"}
     *
     * @param list - input data
     * @return sort list by string length
     */
    @Override
    public List<String> getSortedListByCountOfConsonants(List<String> list) {
        if (list == null) throw new ListProcessorException("The list is null...");
        if (list.size() < 1) throw new ListProcessorException("The list is wrong...");

        int countConsonants = 0;
        for (String each: list) {countConsonants += getCountOfConsonants(each);}

        if(countConsonants == 0) throw new ListProcessorException("There are NO any consonants! ");

        list.sort(Comparator.comparing(ListProcessor::getCountOfConsonants).thenComparing(String::compareTo));

        return list;
    }

    private static int getCountOfConsonants(String word) {
        int count = 0;

        List<String> vowels = Arrays.asList("q", "w", "r", "t", "p", "s", "d", "f", "g",
                "h", "j", "k", "l", "z", "x", "c", "v", "b", "n", "m");
        for (String letter : word.trim().split("")) {
            if (vowels.contains(letter.toLowerCase())) {
                count++;
            }
        }
        return count;
    }

    /**
     * Change by places first and last symbols in each second string of list.
     * <p>
     * Ex.:
     * From list:
     * {"Puma", "Nike", "Timberland", "Adidas"}
     * will be return
     * {"Puma", "eikN", "Timberland", "sdidaA"}
     *
     * @param list - input data
     * @return sort list by string length
     */
    @Override
    public List<String> changeByPlacesFirstAndLastSymbolsInEachSecondStringOfList(List<String> list) {
        if (list == null) throw new ListProcessorException("The list is null...");
        if (list.size() < 2) throw new ListProcessorException("The list is wrong...");

        for (int i = 0; i < list.size(); i++) {
            if (i % 2 != 0) {
                list.set(i, getChangeByPlacesFirstAndLastSymbols(list.get(i)));
            }
        }
        return list;
    }

    private String getChangeByPlacesFirstAndLastSymbols(String word) {
        String[] letters = word.trim().split("");
        String box;
        box = letters[0];
        letters[0] = letters[letters.length - 1];
        letters[letters.length - 1] = box;

        StringBuilder stringBuilder = new StringBuilder();
        for (String letter : letters) {
            stringBuilder.append(letter);
        }
        return stringBuilder.toString();
    }

    /**
     * Revert strings of list.
     * <p>
     * Ex.:
     * From list:
     * {"Puma", "Nike", "Timberland", "Adidas"}
     * will be return
     * {"amuP", "ekiN", "dnalrebmiT", "sadidA"}
     *
     * @param list - input data
     * @return sort list by string length
     */
    @Override
    public List<String> reverseStringsOfList(List<String> list) {
        if (list == null) throw new ListProcessorException("The list is null...");
        if (list.size() < 1) throw new ListProcessorException("The list is wrong...");

        return list.stream().map(ListProcessor::getReversWord).collect(Collectors.toList());
    }

    private static String getReversWord(String word) {
        return new StringBuilder(word).reverse().toString();
    }
}
