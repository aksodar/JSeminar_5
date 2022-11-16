package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Task0 {

    // Дана последовательность чисел. Необходимо вернуть количество уникальных чисел
    //{1, 2, 3, 2} -> 1, 3 -> 2.
    public static void main(final String[] args) {
        List<Integer> lst = new ArrayList<>(List.of(1, 2, 4, 33, 1, 100, 4)); // ответ 3
        Task0 tsk = new Task0();
        Logger log = Logger.getLogger(Task0.class.getName());
        log.info(String.valueOf(tsk.getSumOfUniqueValues(lst)));

    }

    public Integer getSumOfUniqueValues(final List<Integer> list){
        int count = 0;
        Map<Integer, Integer> checkMap = new HashMap<>();
        for (int i: list) {
            checkMap.put(i,1 + checkMap.getOrDefault(i, 0));
        }
        System.out.println(checkMap);
        for (int j: checkMap.values()){
            if (j == 1){
                count++;
            }
        }
        return count;
    }
}
