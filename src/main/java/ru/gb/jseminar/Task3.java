package ru.gb.jseminar;

import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;

public class Task3 {

    // Дана строка. Необходимо написать метод, который отсортирует слова в строке по длине с помощью TreeMap.
    // Строки с одинаковой длиной не должны “потеряться”.
    public static void main(final String[] args) {
        String s = "Мороз и солнце день чудесный день";
        
        Task3 task = new Task3();
        System.out.println(task.getSortedIncludesWords(s));
        
    }

    public Map<Integer, List <String>> getSortedIncludesWords(final String text){
        Map<Integer, List<String>> sortedText = new TreeMap<>();
        String[] splited = text.split(" ");
        for (String word : splited) {
            if (!sortedText.containsKey(word.length())){
                List<String> temp2 = new ArrayList<>();
                temp2.add(word);
                // sortedText.put(word.length(), Arrays.asList(word));
                sortedText.put(word.length(), temp2);
            } else {
                List<String> temp = sortedText.get(word.length());
                temp.add(word);
                sortedText.put(word.length(), temp);
            }
        }
        return sortedText;
    }

}
