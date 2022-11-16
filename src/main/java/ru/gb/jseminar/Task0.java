package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Task0 {

    // Дана последовательность чисел. Необходимо вернуть сумму уникальных чисел
    public static void main(final String[] args) {
        List<Integer> someList = new ArrayList<>(Arrays.asList(2, 2, 1, 3, 5, 1, 5, 6, 7));
        Task0 task0 = new Task0();
        System.out.println(task0.getSumOfUniqueValues(someList));

    }

    public Integer getSumOfUniqueValues(final List<Integer> list){
        Map <Integer, Integer> hm = new HashMap<>();
        for (Integer integer : list) {
            if (hm.containsKey(integer)){
                hm.put(integer, hm.get(integer) +1);
            } else{
                hm.put(integer, 1);
            }
        }
        int count = 0;
        for (Entry<Integer, Integer> integer : hm.entrySet()) {
            if(integer.getValue() == 1) count++;

            
        }

        return count;
    }

}
