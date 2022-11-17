package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

public class Task3 {

    // Дана строка. Необходимо написать метод, который отсортирует слова в строке по
    // длине с помощью TreeMap.
    // Строки с одинаковой длиной не должны “потеряться”.
    public static void main(final String[] args) {
        Task3 task = new Task3();
        Logger log = Logger.getLogger(Task1.class.getName());
        String text = "Мороз и солнце день чудесный Еще ты дремлешь друг прелестный";
        log.info("\nInput string:\t" + text + "\nSorted words:\t"
                + task.getSortedIncludesWords(text));
    }

    public String getSortedIncludesWords(String text) {
        List<String> textList = Arrays.asList(text.toLowerCase().split(" "));
        Map<Integer, List<String>> map = new TreeMap<>();
        for (String word : textList) {
            if (map.containsKey(word.length())) {
                List<String> value = map.get(word.length());
                value.add(word);
                map.put(word.length(), value);
            } else {
                List<String> value = new ArrayList<>(List.of(word));
                map.put(word.length(), value);
            }
        }
        StringBuilder result = new StringBuilder();
        map.forEach((k, v) -> result.append(v.toString()));
        return result.toString().replace("[", "").replace("]", " ").replace(",", "");
    }

}
