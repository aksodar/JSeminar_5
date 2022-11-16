package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task0 {

    // Дана последовательность чисел. Необходимо вернуть сумму уникальных чисел
    public static void main(final String[] args) {
        Task0 tk = new Task0();
        List<Integer> taskList = new ArrayList<>(List.of(1, 2, 2, 4, 1, 100));
        System.out.println(tk.getSumOfUniqueValues(taskList));
    }

    public Integer getSumOfUniqueValues(final List<Integer> list){
        Map<Integer, Integer> checkMap = new HashMap<>();
        for (Integer item: list) {
                checkMap.put(item,1+checkMap.getOrDefault(item, 0));
            }
        Integer result = 0;
        for (Integer item: checkMap.values()){
            if (item == 1){
                result++;
            }
        }
        System.out.println(checkMap);
        return result;
    }

}
