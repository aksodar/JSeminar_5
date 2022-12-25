package ru.gb.jseminar;

import java.util.*;

public class Task1 {

    // Дана последовательность чисел. Необходимо вернуть число совпадающих пар в
    // этой последовательности
    // Пример 1: In: arr = [1, 2] Out: 0
    // Пример 2: In: arr = [1, 1, 2] Out: 1
    // Пример 3: In: arr = [1, 1, 1, 2, 2] Out: 4
    public static void main(final String[] args) {
        List<Integer> array = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 2));
        Task1 db = new Task1();
        System.out.println(db.getNumberOfCouples(array));
    }

    public Integer getNumberOfCouples(final List<Integer> list) {
        Map<Integer, Integer> book = new HashMap<>();
        for (Integer i : list) {
            if (!book.containsKey(i)) {
                book.put(i, 0);
            } else {
                book.put(i, book.get(i));
            }
        }
        int count = 0;
        for (Integer j : book.keySet()) {
            if (book.get(j) == 0) {
                count = count + 1;
            }
        }
        return count;
    }

}
