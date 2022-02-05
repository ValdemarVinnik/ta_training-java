package com.epam.training.student_Uladzimir_Vinnik.collections.list_processor;

import java.util.List;

public interface IListProcessor {

	String getSecondStringByLength(List<String> list);

	List<String> getSortedListByLength(List<String> list);

	List<String> getSortedListByCountOfVowels(List<String> list);

	List<String> getSortedListByCountOfConsonants(List<String> list);

	List<String> changeByPlacesFirstAndLastSymbolsInEachSecondStringOfList(List<String> list);

	List<String> reverseStringsOfList(List<String> list);
}
