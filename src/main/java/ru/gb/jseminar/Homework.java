package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1
    // человек может иметь несколько телефонов.
    // Пусть дан список сотрудников в формате строки
    // "Ева,Дарахвелидзе,89010348765;Ева,Дарахвелидзе,89010344345;Андрей,Иванов,89050377654;Дмитрий,Пономаренко,89344322343;"
    // Написать программу, которая найдет и выведет повторяющиеся имена с
    // количеством повторений.
    // Отсортировать по убыванию популярности.
    public static void main(final String[] args) {
        Homework hw = new Homework();
        String text = "Ева,Дарахвелидзе,89010348765;Ева,Дарахвелидзе,89010344345;Андрей,Иванов,89050377654;Дмитрий,Пономаренко,89344322343;";
        Logger log = Logger.getLogger(Homework.class.getName());
        log.info(hw.findContact(text));
    }

    public String findContact(String text) {
        Map<String, List<String>> map = new TreeMap<>();

        for (String contact : text.split(";")) {
            List<String> temp = List.of(contact.split(","));
            String name = temp.get(0) + " " + temp.get(1);
            String number = temp.get(2);
            if (!map.containsKey(name)) {
                List<String> value = new ArrayList<>();
                value.add(number);
                map.put(name, value);
            } else {
                map.get(name).addAll(Arrays.asList(number));
            }
        }

        Map<Integer, List<String>> result = new TreeMap<>(Collections.reverseOrder());

        for (String item : map.keySet()) {
            if (map.get(item).size() > 1) {

                int key = map.get(item).size();

                if (!result.containsKey(key)) {
                    List<String> value = new ArrayList<>();
                    value.add(item);
                    result.put(map.get(item).size(), value);
                } else {
                    String value = item;
                    result.get(key).addAll(Arrays.asList(value));
                }

            }

        }
        result.entrySet().stream();

        return result.toString().replaceAll("^\\{|\\}$", " ").replace("[", " ").replace("]", "");
    }
}
