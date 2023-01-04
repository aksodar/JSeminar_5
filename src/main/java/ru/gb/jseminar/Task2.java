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
        Map <String, String> trip = new HashMap<>();
        trip.put("Москва","Самара");
        trip.put("Курск","Пенза2");
        trip.put("Самара","Курск");
        Task2 fg = new Task2();
        System.out.println(fg.getFinalCity(trip));


    }

    public String getFinalCity(final Map<String, String> map){
        for (String s : map.keySet()){
            if (map.containsKey(map.get(s))){
                return  map.get(s);
            }
        }
        return "";
    }

}
