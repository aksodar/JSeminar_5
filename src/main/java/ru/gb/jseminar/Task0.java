package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Task0 {

    // Дана последовательность чисел. Необходимо вернуть сумму уникальных чисел
    // [1,2,3,2] -> 2
    public static void main(final String[] args) {
        Task0 task0 = new Task0();
        List<Integer> list = new ArrayList<Integer>(List.of(1, 2, 3, 2, 5, 8, 9, 2));
        Logger log = Logger.getLogger(Task0.class.getName());
        log.info(String.valueOf(task0.getSumOfUniqueValues(list)));

    }

    public Integer getSumOfUniqueValues(final List<Integer> list) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer item : list) {
            map.put(item, 1 + map.getOrDefault(item, 0));
        }
        System.out.println(map);
        Integer count = 0;
        for (Integer item : map.values()) {
            if (item == 1) {
                count++;
            }
        }
        return count;
    }

}
