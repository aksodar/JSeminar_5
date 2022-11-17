package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Task1 {

    // Дана последовательность чисел. Необходимо вернуть число совпадающих пар в этой последовательности
    // Пример 1:     In: arr = [1, 2]  Out: 0
    // Пример 2:     In: arr = [1, 1, 2]  Out: 1
    // Пример 3:     In: arr = [1, 1, 1, 2, 2]  Out: 4
    public static void main(final String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,1,1,2,2));
        Task1 t1 = new Task1();
        Logger log = Logger.getLogger(Task1.class.getName());
        log.info(String.valueOf(t1.getNumberOfCouples(numbers)));
    }

    public Integer getNumberOfCouples(final List<Integer> list){
        Map<Integer, Integer> numCounter = new HashMap<Integer, Integer>();
        for (int item : list){
            numCounter.put(item, 1 + numCounter.getOrDefault(item, 0));
        }
        int pairs = 0;
        for (int value : numCounter.values()) {
            pairs += (double) value / 2 * ((double) value - 1);
        }
        return pairs;
    }

}
