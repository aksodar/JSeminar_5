package ru.gb.jseminar;

import java.util.HashMap;
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
        Map<String, String> dict = new HashMap<String, String>();
        dict.put("Москва", "Самара");
        dict.put("Курск", "Пенза");
        dict.put("Самара", "Курск");

        Logger log = Logger.getLogger(Task2.class.getName());
        log.info(task.getFinalCity(dict).toString());

    }

    public String getFinalCity(final Map<String, String> map) {

        for (String value : map.values()) {
            if (!map.containsKey(value)) {
                return value;
            }

        }
        throw new IllegalStateException();

    }

}
