package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Task3 {

    // Дана строка. Необходимо написать метод, который отсортирует слова в строке по длине с помощью TreeMap.
    // Строки с одинаковой длиной не должны “потеряться”.
    public static void main(final String[] args) {
        Task3 t3 = new Task3();
        String text = "Мороз и солнце день чудесный ещё ты дремлешь друг мороз";
        System.out.println(t3.getSortedIncludesWords(text));
    }

    public Map<Integer, List<String>>  getSortedIncludesWords(String text){
        String[] splited = text.split(" ");
        Map <Integer, List<String>> sortedText = new TreeMap<>();
        for (String word: splited){
            if (!sortedText.containsKey(word.length())){
                List<String> temp2 = new ArrayList<>();
                temp2.add(word);
                sortedText.put(word.length(), temp2);
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
