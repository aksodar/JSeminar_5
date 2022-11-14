package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class  Task0 {

    // Дана последовательность чисел. Необходимо вернуть сумму уникальных чисел
    //[1, 2, 3, 2]
    public static void main(final String[] args) {
        Task0 t0 = new Task0();
        List<Integer> taskList = new ArrayList<>(List.of(1, 2, 4, 33, 1, 100));
        System.out.println(t0.getSumOfUniqueValues(taskList));

    }

    public Integer getSumOfUniqueValues(final List<Integer> list) {
        Map<Integer, Integer> checkMap = new HashMap<>();
        for (Integer item : list) {
            checkMap.put(item, 1 + checkMap.getOrDefault(item, 0));

        }
        int result = 0;
        for (Integer item: checkMap.values()){
            if (item==1){
                result++;
            }
        }
        return result;
    }

}
