package com.epam.training.student_Uladzimir_Vinnik.collections.optional_task;

import java.io.*;

/**
 * Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.
 */

public class ChangeOfStringInTheFile {

    private static final String FILE_PATH = "src/test/resources/FileWithStrings.txt";

    private static String getDataFromTheFile(String filePath) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
            StringBuilder stringBuilder = new StringBuilder();
            while(bufferedReader.ready()) {
                stringBuilder.append(bufferedReader.readLine()).append("\n");
            }
            return stringBuilder.toString();
        }
    }

    private static void writeDataToTheFile(String filePath, String data) throws IOException{
        try( BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))){
            bufferedWriter.write(data);
        }
    }

    private static String getChangingLines(String line){
        StringBuilder stringBuilder = new StringBuilder();
        String[] words = line.split("\n");

        for (int i = words.length-1; i >= 0; i-- ){
            stringBuilder.append(words[i]).append("\n");
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) throws IOException {
        String dataFromFile = getDataFromTheFile(FILE_PATH);

        String changedData = getChangingLines(dataFromFile);

        writeDataToTheFile(FILE_PATH, changedData);

    }
}
