package ru.gb.jseminar;

import java.util.*;

public class Task3 {

    // Дана строка. Необходимо написать метод, который отсортирует слова в строке по длине с помощью TreeMap.
    // Строки с одинаковой длиной не должны “потеряться”.
    public static void main(final String[] args) {
        String text = "Мороз и солнце день чудесный Еще ты дремлешь друг прелестный";
        Task3 task3 = new Task3();
        System.out.println(task3.getSortedIncludesWords(text));

    }

    public String getSortedIncludesWords(final String text){
        String result = text.toLowerCase();
        List<String> splitText = List.of(result.split(" "));
        Map<Integer,List<String>> map = new TreeMap<>();
        for (String word : splitText){
            if (map.containsKey(word.length())){
                map.get(word.length()).add(word);

            }
            else {
                List<String> temp = new ArrayList<>();
                temp.add(word);
                map.put(word.length(),temp);

            }
        }

        return map.toString();
    }

}
