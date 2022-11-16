package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Task0 {

    // Дана последовательность чисел. Необходимо вернуть (сумму) количество
    // уникальных чисел
    // [1,2,3,2] -> 1,3 -> 2
    public static void main(final String[] args) {
        Task0 task = new Task0();
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 2));
        Logger log = Logger.getLogger(Task0.class.getName());
        log.info(task.getSumOfUniqueValues(list).toString());
        // System.out.println(task.getSumOfUniqueValues(list));

    }

    public Integer getSumOfUniqueValues(final List<Integer> list) {
        Map<Integer, Integer> newDict = new HashMap<Integer, Integer>();
        for (int item : list) {
            // newDict.putIfAbsent(item, count++);
            newDict.put(item, 1 + newDict.getOrDefault(item, 0));

        }
        int count = 0;
        for (int value : newDict.values()) {
            if (value == 1)
                count++;
        }

        System.out.println(newDict);

        return count;
    }

}
