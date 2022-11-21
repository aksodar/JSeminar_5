package ru.gb.jseminar;

import java.lang.reflect.Array;
import java.util.*;

public class Task3 {

    // Дана строка. Необходимо написать метод, который отсортирует слова в строке по длине с помощью TreeMap.
    // Строки с одинаковой длиной не должны “потеряться”.
    public static void main(final String[] args) {
        Task3 task3 = new Task3();
        String moroz_text = "Мороз и солнце день чуедсный Еще ты дремлишь друг прелестный";
        System.out.println(task3.getSortedIncludesWords(moroz_text));

    }

    public String getSortedIncludesWords(final String text){
        List<String> text_to_mass = Arrays.asList(text.toLowerCase().split(" "));
        Map<Integer,List<String>> dict = new TreeMap<>();
        for (String item: text_to_mass) {
            if(dict.containsKey(item.length())){
                List<String> temp = dict.get(item.length());
                temp.add(item);
                dict.put(item.length(), temp);
            }else {
                dict.put(item.length(),new ArrayList<>(List.of(item)));
            }
        }
        StringBuilder string_text = new StringBuilder();
        for (List<String> item: dict.values()) {
            string_text.append(item);
        }
        return String.valueOf(string_text).replace("[", " ").replace("]", "");
    }

}
