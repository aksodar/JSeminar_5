package ru.gb.jseminar;

import java.util.*;

public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    // Написать программу, которая выведет список людей с их телефонами.
    // Отсортировать по количеству телефонов.
    public static void main(final String[] args) {
        Homework hw = new Homework();
        System.out.println(hw);
        String text = "Иван,Иванов,012345;" +
                "Петров,Пётр,123456;" +
                "Петров,Пётр,234567;" +
                "Сидоров,Сидор,345678;" +
                "Сидоров,Сидор,456789;" +
                "Сидоров,Сидор,567890;" +
                "Пупкин,Василий,678901;";
        System.out.println(hw.phoneBook(text));
        System.out.println(hw.search(hw.phoneBook(text)));
    }

    public Map<String, List<String>> phoneBook(final String text) {
        Map<String, List<String>> map = new HashMap<>();
        for (String item : text.split(";")) {
            List<String> list = Arrays.asList(item.split(","));
            String key = list.get(0).toLowerCase() + " " + list.get(1).toLowerCase();
            if (!map.containsKey(key)) {
                List<String> values = new ArrayList<>();
                values.add(list.get(2));
                map.put(key, values);
            } else {
                String values = list.get(2);
                map.get(key).addAll(Arrays.asList(values));
            }
        }
        return map;
    }

    public Map<Integer, List<String>> search(Map<String, List<String>> map){
        Map<Integer, List<String>> treeMap = new TreeMap<>(Collections.reverseOrder());
        for (String item : map.keySet()) {
            if (map.get(item).size() > 0) {
                Integer key = map.get(item).size();
                if (!treeMap.containsKey(key)){
                    List<String> valuesList = new ArrayList<>();
                    valuesList.add(item);
                    treeMap.put(key, valuesList);
                }
                else {
                    String values = item;
                    treeMap.get(key).addAll(Arrays.asList(values));
                }
            }
        }
        return treeMap;
    }
}
