package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;

public class Task3 {

    // Дана строка. Необходимо написать метод, который отсортирует слова в строке по длине с помощью TreeMap.
    // Строки с одинаковой длиной не должны “потеряться”.
    public static void main(final String[] args) {
        Task3 t3 = new Task3();
        String text = "Мороз и солнце день чудесный Еще ты дремлешь друг прелестный";
        System.out.println(t3.getSortedIncludesWords(text));

    }

    public String getSortedIncludesWords(final String text){
        List<String> splitText = List.of(text.split(" "));
        Map<Integer, List<String>> map = new TreeMap<>();
        for(String word: splitText) {
            if(map.containsKey(word.length())) {
                map.get(word.length()).add(word);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(word);
                map.put(word.length(), temp);
            }
        }
        return map.toString();
    }

}
