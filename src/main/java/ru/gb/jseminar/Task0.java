package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Task0 {

    // Дана последовательность чисел. Необходимо вернуть сумму уникальных чисел
    // (количество)
    // [1,2,3,2] -> 1,3 -> 2
    public static void main(final String[] args) {
        Task0 task = new Task0();
        Logger log = Logger.getLogger(Task0.class.getName());
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 2, 6, 3, 1, 9));
        log.info("\nList:\t" + list.toString() + "\nUnique values:\t" + task.getSumOfUniqueValues(list).toString());
    }

    public Integer getSumOfUniqueValues(final List<Integer> list) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int number : list) {
            int count = 1;
            if (map.containsKey(number)) {
                count = count + 1;
            }
            System.out.println(count);
            map.put(number, count); // map.getOrDefault(number, 0);
        }
        for (int value : map.values()) {
            if (value == 1) {
                result++;
            }
        }
        return result;
    }

}
