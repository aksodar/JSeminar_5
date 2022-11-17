package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Task0 {

    // Дана последовательность чисел. Необходимо вернуть сумму уникальных чисел
    public static void main(final String[] args) {
        Task0 task = new Task0();
        Logger log = Logger.getLogger(Task0.class.getName());
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 2, 1, 7, 3, 4, 2, 1, 5));
        log.info(String.valueOf(task.getSumOfUniqueValues(list)));

    }

    public Integer getSumOfUniqueValues(final List<Integer> list){
        Map<Integer, Integer> checkMap = new HashMap<>();
        int result = 0;
        for(int item: list) {
            checkMap.put(item, 1+checkMap.getOrDefault(item, 0));
        }
        for(int key: checkMap.keySet()) {
            if(checkMap.get(key) == 1) {
                result += key;
            }
        }
        return result;
    }

}
