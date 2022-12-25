package ru.gb.jseminar;

import java.util.*;

public class Task3 {

    // Дана строка. Необходимо написать метод, который отсортирует слова в строке по длине с помощью TreeMap.
    // Строки с одинаковой длиной не должны “потеряться”.
    public static void main(final String[] args) {
        Task3 task = new Task3();
        String text = "Мороз и солнце день чудесный, и попу ждем";
        System.out.println(task.getSortedIncludesWords(text));
    }

    public Map<Integer, List<String>> getSortedIncludesWords(String text){
        Map<Integer, List<String>> sortedText = new TreeMap<>();
        String[] splited = text.split(" ");
        for (String word : splited) {
            if(!sortedText.containsKey(word.length())){
                List<String> temp = new ArrayList<>();
                temp.add(word);
                // sortedText.put(word.length(), Arrays.asList(word));
                sortedText.put(word.length(), temp);
            }
        else {
            List<String> temp2 = sortedText.get(word.length());
            temp2.add(word);
            sortedText.put(word.length(), temp2);
            }   
        }
        return sortedText;
    }

}



