package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.*;

public class Task2 {

    // Вам дан массив путей, где пути[i] = [”Город А”, “Город Б”] означают, что существует прямой путь, идущий от
    // ”Город А” до“Город Б”. Верните город назначения, то есть город без какого-либо пути, ведущего в другой город.
    // Пример 1: Input: s = [["Москва","Самара"], ["Курск","Пенза"],["Самара","Курск"]]  Output: Пенза
    // Пример 2: Input: s = [["Москва","Самара"]]  Output: Самара
    public static void main(final String[] args) {
        Task2 t2 = new Task2();
        Logger log = Logger.getLogger(Task2.class.getName());
        Map<String, String> s = new HashMap<>();
        s.put("Москва", "Самара");
        s.put("Курск", "Пенза");
        s.put("Самара", "Курск");

        log.info(s.toString());
        log.info(t2.getFinalCity(s).toString());
    }

    public String getFinalCity(final Map<String, String> map){
        for(String value: map.values()){
            if(!map.containsKey(value)) {
                return value;
            }
        }

        throw new IllegalStateException();
    }

}
