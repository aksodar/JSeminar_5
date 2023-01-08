package ru.gb.jseminar;

import java.util.*;

import static java.util.Arrays.*;

public class Task0 {

    // Дана последовательность чисел. Необходимо вернуть сумму уникальных чисел
    public static void main(final String[] args) {
        List<Integer> array = new ArrayList<>(asList(1, 2, 4, 5, 2, 9, 7));
        Task0 db = new Task0();
        System.out.println("sum " + db.getSumOfUniqueValues(array));
    }

    public Integer getSumOfUniqueValues(final List<Integer> list) {
        Map<Integer, Integer> dct = new HashMap<>();
        for (Integer i : list) {
            if (!dct.containsKey(i)) {
                dct.put(i, 0);
            } else {
                dct.put(i, dct.get(i) + 1);
            }
        }
        int sum = 0;
        for (Integer j : dct.keySet()) {
            if (dct.get(j) == 0) {
                sum += j;
            }
        }
        return sum;
    }
}