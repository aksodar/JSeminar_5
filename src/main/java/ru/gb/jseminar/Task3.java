package ru.gb.jseminar;

import com.sun.source.tree.Tree;

import java.util.*;

public class Task3 {

    // Дана строка. Необходимо написать метод, который отсортирует слова в строке по длине с помощью TreeMap.
    // Строки с одинаковой длиной не должны “потеряться”.
    public static void main(final String[] args) {
        Task3 t3 = new Task3();
        String text = "Мороз и солнце день чудесный " +
                "Еще ты дремлешь друг прелестный " +
                "Пора красавица проснись " +
                "открой сомкнуты негой взоры " +
                "навстречу северной Авроры " +
                "звездою севера явись ";
        System.out.println(t3.getSortedIncludesWords(text));
    }

    public String getSortedIncludesWords(String text){
        String[] textArray = text.toLowerCase().split(" ");
        Map<Integer, List<String>> result = new TreeMap<>();
        for (String item : textArray){
            List<String> temp;
            if (result.containsKey(item.length())){
                temp = result.get(item.length());
                temp.add(item);
            }
            else{
                temp = new ArrayList<>(List.of(item));
            }
            result.put(item.length(), temp);
        }

        return result.toString();
    }

}
