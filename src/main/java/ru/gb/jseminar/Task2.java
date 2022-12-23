package ru.gb.jseminar;

import java.util.*;

public class Task2 {

    // Вам дан массив путей, где пути[i] = [”Город А”, “Город Б”] означают, что существует прямой путь, идущий от
    // ”Город А” до“Город Б”. Верните город назначения, то есть город без какого-либо пути, ведущего в другой город.
    // Пример 1: Input: s = [["Москва","Самара"], ["Курск","Пенза"],["Самара","Курск"]]  Output: Пенза
    // Пример 2: Input: s = [["Москва","Самара"]]  Output: Самара
    public static void main(final String[] args) {
        Task2 t = new Task2();
        Map<String,String> city= new HashMap<>();
        city.put("Москва","Самара");
        city.put("Курск","Пенза");
        city.put("Самара","Курск");
        System.out.println(t.getFinalCity(city));
    }

    public String getFinalCity(final Map<String, String> map){
        for(String item: map.keySet()){
            if(!map.containsKey(map.get(item))){
                return map.get(item);
            }
        }
        return "";
    }



}
