package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    // Написать программу, которая выведет список людей с их телефонами и
    // Отсортировать по убыванию популярности.
    public static void main(final String[] args) {
        Map<String, List<Integer>> phonebook = new HashMap<>();
        phonebook.put("Иванов", List.of(8900, 8901));
        phonebook.put("Дмитриев", List.of(8902));
        phonebook.put("Кузин", List.of(8903, 8904,8905));
        phonebook.put("Смирнов", List.of(8906, 8907));
        Homework hw = new Homework();
        hw.sortPrint(phonebook);
    }
    public void sortPrint(final Map<String, List<Integer>> map) {
        Map<Integer, List<String>> sizetel = new TreeMap<>();
        for (String i : map.keySet()) {
            int a = map.get(i).size();
            if (sizetel.containsKey(a)) {
                List<String> b = new ArrayList<>();
                b.addAll(sizetel.get(a));
                b.add(i);
                sizetel.put(a, b);
            } else {
                sizetel.put(a, Arrays.asList(i));
            }
        }
        for (Integer i : sizetel.keySet()) {
            for (String j : sizetel.get(i)) {
                System.out.println(j + ": " + map.get(j));
            }
        }
    }
}

