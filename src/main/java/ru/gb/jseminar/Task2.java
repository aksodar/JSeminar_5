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
        Task2 task2 = new Task2();
        Map<String, String> cities = new HashMap<>();
        cities.put("Москва","Самара");
        cities.put("Курск","Пенза");
        cities.put("Самара","Курск");
        System.out.println(task2.getFinalCity(cities));
    }

    public String getFinalCity(final Map<String, String> map){
        for (String city: map.keySet() ) {
           if (!map.containsKey(map.get(city)))
             return map.get(city);
        }
        return "";
    }

}
