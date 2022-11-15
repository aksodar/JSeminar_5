package ru.gb.jseminar;


import java.util.HashMap;

import java.util.Map;


public class Task2 {

    // Вам дан массив путей, где пути[i] = [”Город А”, “Город Б”] означают, что существует прямой путь, идущий от
    // ”Город А” до“Город Б”. Верните город назначения, то есть город без какого-либо пути, ведущего в другой город.
    // Пример 1: Input: s = [["Москва","Самара"], ["Курск","Пенза"],["Самара","Курск"]]  Output: Пенза
    // Пример 2: Input: s = [["Москва","Самара"]]  Output: Самара
    public static void main(final String[] args) {
        Map<String, String> route = new HashMap<>();
        route.put("Москва","Самара");
        //route.put("Курск","Пенза");
        //route.put("Самара","Курск");
       
        Task2 task2 = new Task2();
        System.out.println(task2.getFinalCity(route));
    }

    public String getFinalCity(final Map<String, String> map){
        String city = "";
        for (String item : map.values()) {
            if(!item.equals(map.get(item))){
                city = item;
            }
        }

        return city;
    }

}
