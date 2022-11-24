package ru.gb.jseminar;

import java.util.*;

public class Task0 {

    // Дана последовательность чисел. Необходимо вернуть сумму уникальных чисел
    public static void main(final String[] args) {
        Task0 task0 = new Task0();
        List<Integer> list = new ArrayList<>(List.of(1,3,2,4,3));
        System.out.println(task0.getSumOfUniqueValues(list));
    }

    public Integer getSumOfUniqueValues(final List<Integer> list){
        Map<Integer, Integer> checkMap = new HashMap<>();
        int result = 0;
        for (Integer item: list) {
            checkMap.put(item, 1 + checkMap.getOrDefault(item, 0));
        }
        for (Integer item: checkMap.values()){
            if (item == 1) {
                result++;
            }
        }
        return result;
    }

}
