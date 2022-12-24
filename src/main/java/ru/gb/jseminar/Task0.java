package ru.gb.jseminar;

import java.util.*;

public class Task0 {

    // Дана последовательность чисел. Необходимо вернуть сумму уникальных чисел
    public static void main(final String[] args) {
        Task0 task = new Task0();
        List<Integer> dano = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 3, 7, 77, 123));
        System.out.println(task.getSumOfUniqueValues(dano));
    }

    public Integer getSumOfUniqueValues(final List<Integer> list) {
        Map<Integer, Integer> counts = new HashMap<>();
        int count = 0;
        for (int i : list) {
            if (counts.containsValue(i)) {
                continue;
            }
            counts.put(count, i);
            if (counts.size() > 0) {
                count = count + counts.get(count);
            }
        }
        System.out.println(counts.entrySet());
        System.out.println(count);
        return 0;
    }

}
