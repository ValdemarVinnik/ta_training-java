package com.epam.training.student_Uladzimir_Vinnik.fundamental.main_task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HelloUser {

    public void run() throws IOException {
        printMessage("Enter your name:");
        String userName = getStringFromConsole();

        while (!checkForValidity(userName)) {
            printMessage("try again...");
            userName = getStringFromConsole();
        }
        printMessage(String.format("Hello %s!", userName));
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

    private String getStringFromConsole() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        return reader.readLine();
    }

    private boolean checkForValidity(String string) {
        return (string != null && string.length() > 0);
    }

    public static void main(String[] args) throws IOException {
        new HelloUser().run();
    }
}
