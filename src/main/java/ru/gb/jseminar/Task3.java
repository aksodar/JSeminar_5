package ru.gb.jseminar;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Task3 {

    // Дана строка. Необходимо написать метод, который отсортирует слова в строке по длине с помощью TreeMap.
    // Слова с одинаковой длиной не должны “потеряться”.
    public static void main(final String[] args) {

        String text = "Мороз и солнце а день чудесный";
        Task3 task3 = new Task3();
        System.out.println(task3.getSortedIncludesWords(text));
    }

    public Map<Integer, List <String>> getSortedIncludesWords(String text){
        Map<Integer, List <String>> sortedText = new TreeMap<>();
        String[] splitted = text.split(" ");
        for (String word : splitted) {
            if (!sortedText.containsKey(word.length())){
                List <String> temp2 = new ArrayList<>();
                temp2.add(word);
                sortedText.put(word.length(), temp2);
            }
            else {
                List <String> temp = sortedText.get(word.length());
                temp.add(word);
                sortedText.put(word.length(), temp);
            }
        }
        return sortedText;
    }

}
