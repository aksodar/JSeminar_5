package ru.gb.jseminar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Task2 {

    // Вам дан массив путей, где пути[i] = [”Город А”, “Город Б”] означают, что существует прямой путь, идущий от
    // ”Город А” до“Город Б”. Верните город назначения, то есть город без какого-либо пути, ведущего в другой город.
    // Пример 1: Input: s = [["Москва","Самара"], ["Курск","Пенза"],["Самара","Курск"]]  Output: Пенза
    // Пример 2: Input: s = [["Москва","Самара"]]  Output: Самара
    public static void main(final String[] args) {
        Map<String, String> wayMap = new HashMap<>();
        wayMap.put("Москва", "Самара");
       // wayMap.put("Курск", "Пенза");
       // wayMap.put("Самара", "Курск");

        Task2 tsk = new Task2();
        Logger log = Logger.getLogger(Task2.class.getName());
        log.info(String.valueOf(tsk.getFinalCity(wayMap)));
    }

    public String getFinalCity(final Map<String, String> map) {
       for (String endCity : map.values()) {
           if (!map.containsKey(endCity)) {
               return endCity;
           }
       }
       throw new IllegalStateException();
    }
}