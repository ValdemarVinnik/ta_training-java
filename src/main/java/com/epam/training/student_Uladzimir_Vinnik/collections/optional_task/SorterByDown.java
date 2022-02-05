package com.epam.training.student_Uladzimir_Vinnik.collections.optional_task;

import java.util.Arrays;
import java.util.List;

/**
 * Не используя вспомогательных объектов, переставить отрицательные
 * элементы данного списка в конец, а положительные — в начало списка.
 */

public class SorterByDown {
    private static List<Integer> sortDown(List<Integer> list){
        int box;
        for (int i = 0; i <= list.size(); i++){
            for(int j = 0; j < list.size()-(i+1); j++){
                if (list.get(j) < list.get(j+1)){
                    box = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, box);
                }
            }
        }
        return list;
    }

    private static void printList(List<Integer> list){
        list.forEach((d) ->System.out.print(d+" "));
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(-7,-5,-4,-2,-1,2,4,5,6);

        printList(sortDown(list));
    }
}
