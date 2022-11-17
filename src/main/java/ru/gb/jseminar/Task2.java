package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Task2 {

    // Вам дан массив путей, где пути[i] = [”Город А”, “Город Б”] означают, что
    // существует прямой путь, идущий от
    // ”Город А” до“Город Б”. Верните город назначения, то есть город без
    // какого-либо пути, ведущего в другой город.
    // Пример 1: Input: s = [["Москва","Самара"],
    // ["Курск","Пенза"],["Самара","Курск"]] Output: Пенза
    // Пример 2: Input: s = [["Москва","Самара"]] Output: Самара
    public static void main(final String[] args) {
        Task2 task = new Task2();
        Logger log = Logger.getLogger(Task1.class.getName());
        Map<String, String> map = new HashMap<>();
        map.putIfAbsent("Москва", "Самара");
        map.putIfAbsent("Курск", "Пенза");
        map.putIfAbsent("Самара", "Курск");
        log.info("\nMap\t" + map.toString() + "\nDestination city:\t"
                + task.getFinalCity(map).toString());
    }

    public String getFinalCity(final Map<String, String> map) {
        String result = "";
        for (String value : map.values()) {
            if (!map.containsKey(value)) {
                result = value;
            }
        }
        return result;
    }

}
