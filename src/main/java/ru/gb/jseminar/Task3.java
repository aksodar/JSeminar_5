package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Task3 {

    // Дана строка. Необходимо написать метод, который отсортирует слова в строке по длине с помощью TreeMap.
    // Строки с одинаковой длиной не должны “потеряться”.
    public static void main(final String[] args) {
    Task3 t = new Task3();
    String text = "Мороз и солнце день чудесный день";
        System.out.println(t.getSortedIncludesWords(text));

    }

    public Map<Integer, List<String>> getSortedIncludesWords(String text){
        Map<Integer, List<String>> sorttext = new TreeMap<>();
        String[] splitted = text.split(" ");
        for (String item: splitted){
            if (!sorttext.containsKey(item.length())){
                List<String> temp2 = new ArrayList<>();
                temp2.add(item);
                sorttext.put(item.length(),temp2);
            }
            else{
                List<String> temp = sorttext.get(item.length());
                temp.add(item);
                sorttext.put(item.length(),temp);
            }
        }

     return sorttext;
    }


}
