package com.epam.training.student_Uladzimir_Vinnik.collections.optional_task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ListSorterFromFile {
    private static final String FILE_PATH = "src/test/resources/Song.txt";

    private static List<String> getDataFromTheFile(String filePath) throws IOException {
        List<String> list = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {

            while (bufferedReader.ready()) {
                list.add(bufferedReader.readLine());
            }
            return list;
        }
    }

    private static List<String> getSortingList(List<String> list) {
        Collections.sort(list);
        return list;
    }

    private static void printList(Collection<String> list) {
        list.forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {
        printList(getSortingList(getDataFromTheFile(FILE_PATH)));
    }
}
