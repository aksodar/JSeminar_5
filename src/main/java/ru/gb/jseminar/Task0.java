package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;


public class Task0 {

    // Дана последовательность чисел. Необходимо вернуть количество уникальных чисел
    public static void main(final String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,1));
        Task0 t0 = new Task0();
        Logger log = Logger.getLogger(Task0.class.getName());
        log.info(String.valueOf(t0.getNumberOfUniqueValues(numbers)));
    }

    public Integer getNumberOfUniqueValues(final List<Integer> list){
        Map<Integer, Integer> numCounter = new HashMap<Integer, Integer>();
        for (int item : list){
            numCounter.put(item, 1 + numCounter.getOrDefault(item, 0));
        }
        int counter = 0;
        for (int value : numCounter.values()) {
            if (value == 1) counter++;
        }
        return counter;
    }
}
