package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task0 {

    // Дана последовательность чисел. Необходимо вернуть сумму уникальных чисел
    public static void main(final String[] args) {
        Task0 t0 = new Task0();
        List<Integer> listInt = new ArrayList<>(List.of(1, 2, 3, 2));
        System.out.println(t0.getSumOfUniqueValues(listInt));
    }

    public Integer getSumOfUniqueValues(final List<Integer> list) {
        Map<Integer, Integer> mapList = new HashMap<>();
        for (int item : list) {
            mapList.put(item,1+mapList.getOrDefault(item,0));
        }
        int result = 0;
        for (int item : mapList.values())
            if (item == 1)
                result++;

        return result;
    }

}
