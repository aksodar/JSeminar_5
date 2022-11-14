package ru.gb.jseminar;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Task3 {

    // Дана строка. Необходимо написать метод, который отсортирует слова в строке по длине с помощью TreeMap.
    // Строки с одинаковой длиной не должны “потеряться”.
    public static void main(final String[] args) {
        String text = "Мороз и солнце день чудесный еще ты дремлешь друг прелестный";
        Task3 task3 = new Task3();
        System.out.println(task3.getSortedIncludesWords(text));


    }

    public String getSortedIncludesWords(String text) {
        String result = text.toLowerCase();
        List<String> list = List.of(result.split(" "));
        Map<Integer, List<String>> map = new TreeMap<>();
        for (String words : list) {
            if (map.containsKey(words.length())) {
                //     map.get(words.length()).add.(words);
            } else {

            }



        }

        return result;
    }
}
