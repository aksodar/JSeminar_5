package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.TreeMap;

public class Task3 {

    // Дана строка. Необходимо написать метод, который отсортирует слова в строке по длине с помощью TreeMap.
    // Строки с одинаковой длиной не должны “потеряться”.
    //Мороз и солнце день чудесный Еще ты дремлешь друг прелестный

    public static void main(final String[] args) {
        String someStr = "Мороз и солнце день чудесный Еще ты дремлешь друг прелестный";
        Task3 task3 = new Task3();
        System.out.println(task3.getSortedIncludesWords(someStr));
    }

    public TreeMap <Integer, List<String>> getSortedIncludesWords(final String  text){
        TreeMap <Integer, List<String>> dimension = new TreeMap<>();
        List<String> someList = Arrays.asList(text.toLowerCase().split(" "));
        for (String item : someList) {
            if (dimension.containsKey(item.length())){
                List<String> temp = dimension.get(item.length());
                temp.add(item);
                dimension.put(item.length(),temp);
            } else {
                List<String> temp = new ArrayList<>(List.of(item));
                dimension.put(item.length(),temp);

            }
            
        }

        return dimension;
    }

}
