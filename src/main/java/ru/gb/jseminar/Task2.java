package ru.gb.jseminar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task2 {

    // Вам дан массив путей, где пути[i] = [”Город А”, “Город Б”] означают, что существует прямой путь, идущий от
    // ”Город А” до“Город Б”. Верните город назначения, то есть город без какого-либо пути, ведущего в другой город.
    // Пример 1: Input: s = [["Москва","Самара"], ["Курск","Пенза"],["Самара","Курск"]]  Output: Пенза
    // Пример 2: Input: s = [["Москва","Самара"]]  Output: Самара
    public static void main(final String[] args) {
        Task2 t2 = new Task2();
        Map<String, String> map = new HashMap<>();
        map.put("Москва", "Самара");
        map.put("Курск", "Пенза");
        map.put("Самара", "Курск");
        System.out.println(t2.getFinalCity(map));
    }

    public String getFinalCity(final Map<String, String> map) {
        for (String item : map.values())
            if (!map.containsKey(item)) return item;
        throw new IllegalStateException();

    }

}
