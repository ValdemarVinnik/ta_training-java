package com.epam.training.student_Uladzimir_Vinnik.collections.optional_task;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/***
 *  Создать список из элементов каталога и его подкаталогов.
 */

public class ListOfFiles {
    private static final String DIRECTORY_PATH = "src/main/java/com/epam/training/student_Uladzimir_Vinnik";
    private static List<String> files = new ArrayList<>();

    private static List<String> createList(String directoryPath) {

        File file = new File(directoryPath);

        if (file.isDirectory()) {
            searchNewDirectory(file);
        }
        return files;
    }

    private static void searchNewDirectory(File file) {
        if (file.isDirectory()) {
            files.add(file.getName());
            for (File each : Objects.requireNonNull(file.listFiles())) {
                if (each.isFile()) {
                    files.add(each.getName());
                } else {
                    searchNewDirectory(each);
                }
            }

        }
    }

    private static void printList(List<String> list) {
        list.forEach((s) -> System.out.printf("%s \n", s));
    }

    public static void main(String[] args) {
        printList(createList(DIRECTORY_PATH));
    }
}
