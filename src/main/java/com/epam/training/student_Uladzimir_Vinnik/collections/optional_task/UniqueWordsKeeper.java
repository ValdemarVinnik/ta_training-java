package com.epam.training.student_Uladzimir_Vinnik.collections.optional_task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * Задан файл с текстом на английском языке. Выделить все различные слова.
 * Слова, отличающиеся только регистром букв, считать одинаковыми. Использовать класс HashSet.
 */
public class UniqueWordsKeeper {
    private static final String FILE_PATH = "src/test/resources/FileWithEnglishText.text";

    private static String getDataFromTheFile(String filePath) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {

            while (bufferedReader.ready()) {
                stringBuilder.append(bufferedReader.readLine());
            }
            return stringBuilder.toString();
        }
    }

    private static Set<String> convertToSet(String string) {
        Set<String> controlSet = new HashSet<>();
        Set<String> set = new HashSet<>();
        if (string != null) {
            for (String each : string.split("[^’a-zA-Z0-9]")) {
                if (!controlSet.contains(each.toLowerCase(Locale.ENGLISH))) {
                    controlSet.add(each.toLowerCase());
                    set.add(each);
                }
            }
        }
        return set;
    }

    private static void printList(Collection<String> list) {
        list.forEach((s) -> System.out.printf("%s  ", s));
    }

    public static void main(String[] args) throws IOException {
        printList(convertToSet(getDataFromTheFile(FILE_PATH)));
    }
}
