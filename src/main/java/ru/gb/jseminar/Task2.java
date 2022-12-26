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
        Map<String, String> road = new HashMap<>();
        road.put("Moskov", "Samara");
        road.put("Kursk", "Penza");
        road.put("Samara", "Kursk");

        Task2 task = new Task2();
        System.out.println(task.getFinalCity(road));
    }

    public String getFinalCity(final Map<String, String> map) {
        for (String i : map.keySet()){
            if (!map.containsKey(map.get(i))){
                return map.get(i);
            }
        }
        return "";
    }
}

