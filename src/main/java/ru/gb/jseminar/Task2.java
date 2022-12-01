package ru.gb.jseminar;

import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task2 {

    // Вам дан массив путей, где пути[i] = [”Город А”, “Город Б”] означают, что существует прямой путь, идущий от
    // ”Город А” до“Город Б”. Верните город назначения, то есть город без какого-либо пути, ведущего в другой город.
    // Пример 1: Input: s = [["Москва","Самара"], ["Курск","Пенза"],["Самара","Курск"]]  Output: Пенза
    // Пример 2: Input: s = [["Москва","Самара"]]  Output: Самара
    public static void main(final String[] args) {
        Map <String, String> map = new HashMap<>();
        map.put("Москва", "Самара");
        map.put("Курск", "Пенза");
        map.put("Самара", "Курск");
        Task2 task2 = new Task2();
        Logger log = Logger.getLogger(Task2.class.getName());
        log.info(task2.getFinalCity(map));
        
    }

    public String getFinalCity(final Map<String, String> map){
        List<String> keys = new ArrayList<String>();
        List<String> values = new ArrayList<String>();
        String finalCity = "";
        for (var item : map.entrySet()) {
            keys.add(item.getKey());
            values.add(item.getValue());
        }
        for (int i = 0; i < values.size(); i++) {
            for (int j = 0; j < values.size(); j++) {
                if (values.get(j) != keys.get(i)) {
                    finalCity = values.get(j);
                }
            }
        }
        return finalCity;
    }

}
