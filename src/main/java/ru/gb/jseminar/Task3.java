package ru.gb.jseminar;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Task3 {

    // Дана строка. Необходимо написать метод, который отсортирует слова в строке по длине с помощью TreeMap.
    // Строки с одинаковой длиной не должны “потеряться”.
    public static void main(final String[] args) {
        Task3 task3 = new Task3();
        String text = "Мороз и солнце день и чудесный день";
        System.out.println(task3.getSortedIncludesWords(text));

    }

    public Map<Integer, List<String>> getSortedIncludesWords(String text){
        Map<Integer, List<String>> sortedText = new TreeMap<>();
        String[] splited = text.split(" "); 
        for (String word : splited) {
            if (!sortedText.containsKey(word.length())){
                List<String> temp = new ArrayList<>();
                temp.add(word);
                sortedText.put(word.length(), temp);
        }
            else{
                List<String> temp = sortedText.get(word.length());
                temp.add(word);
                sortedText.put(word.length(), temp);    
            }
            
        }
        return sortedText;
    }

}
