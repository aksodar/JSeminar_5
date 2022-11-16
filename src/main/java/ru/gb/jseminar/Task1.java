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
    public static void main(final String[] args) {
        List<Integer> lst = new ArrayList<>(List.of(1, 1, 1, 1, 2, 2, 2, 2)); // ответ 12
        Task1 tsk = new Task1();
        Logger log = Logger.getLogger(Task1.class.getName());
        log.info(String.valueOf(tsk.getNumberOfCouples(lst)));
    }

    public Integer getNumberOfCouples(final List<Integer> list){
        int count = 0;
        Map<Integer, Integer> checkMap = new HashMap<>();
        for (int i: list) {
            checkMap.put(i,1 + checkMap.getOrDefault(i, 0));
        }
        System.out.println(checkMap);
        for (int j: checkMap.values()){
            if (j > 1){
                count = count + (j-1)*(1+(j-1))/2 ;
            }
        }
        return count;
    }
}