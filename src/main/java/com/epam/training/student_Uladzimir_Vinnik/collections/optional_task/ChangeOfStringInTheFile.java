package com.epam.training.student_Uladzimir_Vinnik.collections.optional_task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.
 */

public class ChangeOfStringInTheFile {

    private static final String FILE_PATH = "src/test/resources/FileWithStrings.txt";

    private static List<String> getDataFromTheFile(String filePath) throws IOException {
        List<String> list = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){

            while(bufferedReader.ready()) {
                list.add(bufferedReader.readLine());
            }
            return list;
        }
    }

    private static boolean writeDataToTheFile(String filePath, List<String> data) throws IOException{
        if (data == null || data.size() == 0){ return false;}
        try( BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))){
            for (int i = data.size()-1; i >= 0; i-- ){
                bufferedWriter.write(data.get(i) +"\n");
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        List<String> list = getDataFromTheFile(FILE_PATH);

        writeDataToTheFile(FILE_PATH, list);
    }
}
