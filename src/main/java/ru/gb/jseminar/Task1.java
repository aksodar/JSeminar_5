package ru.gb.jseminar;

import java.util.*;
import java.util.logging.Logger;

public class Task1 {

    // Дана последовательность чисел. Необходимо вернуть число совпадающих пар в этой последовательности
    // Пример 1:     In: arr = [1, 2]  Out: 0
    // Пример 2:     In: arr = [1, 1, 2]  Out: 1
    // Пример 3:     In: arr = [1, 1, 1, 2, 2]  Out: 4
    public static void main(final String[] args) {
        Task1 task1 = new Task1();
        List<Integer> taskList = new ArrayList<>(Arrays.asList(1, 1, 1, 2, 2));
        Logger log = Logger.getLogger(Task1.class.getName());
        log.info(String.valueOf(task1.getNumberOfCouples(taskList)));
    }

    public Integer getNumberOfCouples(final List<Integer> list) {
        Map<Integer, Integer> checkMap = new HashMap();
        for (int item : list) {
            checkMap.put(item, 1 + checkMap.getOrDefault(item, 0));
        }
        int result = 0;
        for (int item : checkMap.values()) {
            if (item > 1) {
                result += (double) item / 2 * (item - 1);
            }
        }
        return result;
    }
}
