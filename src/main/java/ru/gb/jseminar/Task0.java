package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task0 {

    // Дана последовательность чисел. Необходимо вернуть сумму уникальных чисел
    public static void main(final String[] args) {
        Task0 task0 = new Task0();    
        System.out.println(task0.getSumOfUniqueValues(new ArrayList<>(Arrays.asList(1,2,3,4,4))));
    }

    public Integer getSumOfUniqueValues(final List<Integer> list){
        Map<Integer, Integer> unique = new HashMap<>();
        int result = 0;
        for (Integer i : list) {
            int count = unique.getOrDefault(i,0)+1;
            unique.put(i, count);
            if (count == 1) 
                result = result + i;
            else
            if (count == 2) 
                result = result - i;
        }
        return result;
    }
}
