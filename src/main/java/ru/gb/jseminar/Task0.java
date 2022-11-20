package ru.gb.jseminar;

import java.util.*;

public class Task0 {

    // Дана последовательность чисел. Необходимо вернуть сумму уникальных чисел
    // [1,2,3,2]
    public static void main(final String[] args) {
        Task0 t0 = new Task0();
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 2));
        System.out.println(t0.getSumOfUniqueValues(list));

    }

    public Integer getSumOfUniqueValues(final List<Integer> list){
        Map<Integer, Integer> dict = new HashMap<>();
        for(int item: list) {
            dict.put(item, 1 + dict.getOrDefault(item, 0));
        }
        int count = 0;
        for(int value: dict.values()) {
            if(value == 1) count ++;
        }

        return count;
    }

}
