package com.epam.training.student_Uladzimir_Vinnik.collections.optional_task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Занести стихотворение в список. Провести сортировку по возрастанию длин строк.
 */
public class ListByLinesLengthSorter {
    private static final String FILE_PATH = "src/test/resources/Song.txt";

    private static List<String> getDataFromTheFile(String filePath) throws IOException {
        List<String> list = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {

            while (bufferedReader.ready()) {
                list.add(bufferedReader.readLine().trim());
            }
            return list;
        }
    }

    private static List<String> sortByLength(List<String> list){
        list.sort(Comparator.comparing(String::length));
         return list;
    }

    private static void printList(Collection<String> list) {
        list.forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {
        List<String> list = getDataFromTheFile(FILE_PATH);
        printList(sortByLength(list));

    }
}
