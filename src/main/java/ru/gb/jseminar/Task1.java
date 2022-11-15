package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Task1 {

    // Дана последовательность чисел. Необходимо вернуть число совпадающих пар в этой последовательности
    // Пример 1:     In: arr = [1, 2]  Out: 0
    // Пример 2:     In: arr = [1, 1, 2]  Out: 1
    // Пример 3:     In: arr = [1, 1, 1, 2, 2]  Out: 4
    public static void main(final String[] args) {
        List<Integer> someList = new ArrayList<>(Arrays.asList(1, 2));
        Task1 task1 = new Task1();
        System.out.println(task1.getNumberOfCouples(someList));

    }

    public Integer getNumberOfCouples(final List<Integer> list){
        
        List<Integer> temp = new ArrayList<>();
        int count = 0;
        for (Integer integer : list) {
            temp.add(integer);
        }
        
        for (Integer itemA : list) {
            int k = itemA;
            temp.remove(itemA);
            for (Integer itemZ : temp) {
                if (k == itemZ){ 
                    count++;
                } 
            }
        }
               
        return count;
    }

}
