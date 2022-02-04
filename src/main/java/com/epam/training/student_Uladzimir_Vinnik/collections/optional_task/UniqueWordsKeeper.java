package com.epam.training.student_Uladzimir_Vinnik.collections.optional_task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Э''
 */
public class UniqueWordsKeeper {
    private static final String FILE_PATH = "src/test/resources/FileWithEnglishText.text";

    private static String getDataFromTheFile(String filePath) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){

            while(bufferedReader.ready()) {
                stringBuilder.append(bufferedReader.readLine());
            }
            return stringBuilder.toString();
        }
    }

    private static Set<String> convertToSet(String string){
        Set<String> set = new HashSet<>();
        if(string != null){
            set.addAll(Arrays.asList(string.split("\\W+")));
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
