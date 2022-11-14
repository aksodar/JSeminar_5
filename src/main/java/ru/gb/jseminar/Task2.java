package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task2 {

    // Вам дан массив путей, где пути[i] = [”Город А”, “Город Б”] означают, что существует прямой путь, идущий от
    // ”Город А” до“Город Б”. Верните город назначения, то есть город без какого-либо пути, ведущего в другой город.
    // Пример 1: Input: s = [["Москва","Самара"], ["Курск","Пенза"],["Самара","Курск"]]  Output: Пенза
    // Пример 2: Input: s = [["Москва","Самара"]]  Output: Самара
    public static void main(final String[] args) {
        Map<String,String>map = new HashMap<>();
        Task2 task2 = new Task2();
        System.out.println(task2.getFinalCity(map));
        map.put("Москва","Самара");
        map.put("Курск","Пенза");
        map.put("Самара","Курск");

    }

    public String getFinalCity(final Map<String, String> map){
        for (String value: map.values()) {
            if(!map.containsKey(value)){
                return value;
            }
        }
        return "0";
        //throw new IllegalStateException();

    }

}
