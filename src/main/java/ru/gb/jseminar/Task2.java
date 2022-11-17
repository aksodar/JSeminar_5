package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Task2 {

    // Вам дан массив путей, где пути[i] = [”Город А”, “Город Б”] означают, что существует прямой путь, идущий от
    // ”Город А” до“Город Б”. Верните город назначения, то есть город без какого-либо пути, ведущего в другой город.
    // Пример 1: Input: s = [["Москва","Самара"], ["Курск","Пенза"],["Самара","Курск"]]  Output: Пенза
    // Пример 2: Input: s = [["Москва","Самара"]]  Output: Самара
    public static void main(final String[] args) {
        Map<String, String> rout = new HashMap<String, String>();
        rout.put("Moscow","Samara");
        rout.put("Kursk","Penza");
        rout.put("Samara","Kursk");
        Task2 t2 = new Task2();
        Logger log = Logger.getLogger(Task2.class.getName());
        log.info(String.valueOf(t2.getFinalCity(rout)));
    }

    public String getFinalCity(final Map<String, String> map){
        for (String value : map.values()){
            if (!map.containsKey(value)){
                return value;
            }
        }
        throw new IllegalStateException();
    }
}
