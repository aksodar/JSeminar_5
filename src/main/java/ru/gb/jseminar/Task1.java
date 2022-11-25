package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Task1 {

    // Дана последовательность чисел. Необходимо вернуть число совпадающих пар в этой последовательности
    // Пример 1:     In: arr = [1, 2]  Out: 0
    // Пример 2:     In: arr = [1, 1, 2]  Out: 1
    // Пример 3:     In: arr = [1, 1, 1, 2, 2]  Out: 4
    // n/2 *(n-1)
    public static void main(final String[] args) {
        Task1 tk1 = new Task1();
        List<Integer> list = new ArrayList<>(List.of(1, 1, 1, 1, 1, 2, 2));
        Logger lg = Logger.getLogger(Task1.class.getName());
        lg.info(String.valueOf(tk1.getNumberOfCouples(list)));

    }

    public Integer getNumberOfCouples(final List<Integer> list) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer item : list) {
            map.put(item, 1 + map.getOrDefault(item, 0));
        }
        System.out.println(map);
        Integer count = 0;
        for (Integer item : map.values()) {
            if (item > 1) {
                count += (item * (item - 1)) / 2;
            }
        }
        return count;
    }

}
