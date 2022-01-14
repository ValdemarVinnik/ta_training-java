package com.epam.training.student_Uladzimir_Vinnik.fundamental.main_task;

public class ReversArgs {
    public static void main(String[] args) {
        if (args == null)return;

        for (int i = args.length-1; i >= 0; i--){
            System.out.print(String.format("%s ",args[i]));
        }
    }
}
