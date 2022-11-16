package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

public class Task3 {

    // Дана строка. Необходимо написать метод, который отсортирует слова в строке по
    // длине с помощью TreeMap.
    // Строки с одинаковой длиной не должны “потеряться”.
    // Мороз и солнце день чудесный Еще ты дремлешь друг прелестный
    public static void main(final String[] args) {
        Task3 task = new Task3();
        String text = "Мороз и солнце день чудесный Еще ты дремлешь друг прелестный";
        Logger log = Logger.getLogger(Task3.class.getName());
        log.info(task.getSortedIncludesWords(text).toString());

    }

    public String getSortedIncludesWords(String text) {
        String nText = text.toLowerCase();
        List<String> splitText = List.of(nText.split(" "));
        Map<Integer, List<String>> map = new TreeMap<Integer, List<String>>();
        for (String word : splitText) {
            if (map.containsKey(word.length())) {
                map.get(word.length()).add(word);
            } else {
                List<String> col = new ArrayList<>();
                col.add(word);
                map.put(word.length(), col);
            }

        }

        return map.toString();
    }

}
