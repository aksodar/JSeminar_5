package ru.gb.jseminar;

import java.util.*;

public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    // Пусть дан список сотрудников:Иван Иванов (и остальные, полный текст дз будет на платформе)
    // Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
    // Отсортировать по убыванию популярности.
    public static void main(final String[] args) {
        Homework hw = new Homework();
        System.out.println(hw);
        String text = "Иван,Иванов,89050377654;" +
                "Дмитрий,Дмитрьев,89344322343;" +
                "Дмитрий,Дмитрьев,89344322234;" +
                "Дмитрий,Дмитрьев,89343462343;" +
                "Амина,Третьякова,89010398365;" +
                "Амина,Третьякова,89010334785;" +
                "Галина,Васильева,89053457654;";
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
                Integer key =map.get(item).size();
                if (!treeMap .containsKey(key)){
                    List<String> valuesList = new ArrayList<>();
                    valuesList.add(item);
                    treeMap.put(key, valuesList);
                }
                else {
                    String values = item;
                    treeMap .get(key).addAll(Arrays.asList(values));
                }
            }
        }
        return treeMap;
    }
}