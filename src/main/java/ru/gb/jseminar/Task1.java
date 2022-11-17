package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.logging.Logger;

public class Task1 {

    // Дана последовательность чисел. Необходимо вернуть число совпадающих пар в этой последовательности
    // Пример 1:     In: arr = [1, 2]  Out: 0
    // Пример 2:     In: arr = [1, 1, 2]  Out: 1
    // Пример 3:     In: arr = [1, 1, 1, 2, 2]  Out: 4
        // (1+(n-1))/2*(n-1)

    public static void main(final String[] args) {
        Task1 task = new Task1();
        Logger log = Logger.getLogger(Task1.class.getName());
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 2, 1, 7, 3, 4, 2, 1, 5));
        log.info(String.valueOf(task.getNumberOfCouples(list)));
    }

    public Integer getNumberOfCouples(final List<Integer> list){
        Map<Integer, Integer> hm = new HashMap<>();
        for(int item: list) {
            hm.put(item, 1+hm.getOrDefault(item, 0));
        }
        int result = 0;
        for(int item: hm.values()) {
            if (item > 1) {
                result += (item*(item-1))/2;
            }
        }
        return result;
    }

}
