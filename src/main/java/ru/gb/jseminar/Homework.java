package ru.gb.jseminar;

import java.util.Arrays;
//import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.util.TreeMap;
//import java.util.logging.Logger;

public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1
    // человек может иметь несколько телефонов.
    // Пусть дан список сотрудников:Иван Иванов (и остальные, полный текст дз будет
    // на платформе)
    // Написать программу, которая найдет и выведет повторяющиеся имена с
    // количеством повторений.
    // Отсортировать по убыванию популярности.

    // Пусть дан список сотрудников в формате строки
    // "Ева,Дарахвелидзе,89010348765;Ева,Дарахвелидзе,89010344345;Андрей,Иванов,89050377654;Дмитрий,Пономаренко,89344322343;"
    // Написать программу, которая найдет и выведет повторяющиеся имена с
    // количеством повторений.
    // Отсортировать по убыванию популярности.
    public static void main(final String[] args) {
        Homework hw = new Homework();
        String text = "Ева,Дарахвелидзе,89010348765;Ева,Дарахвелидзе,89010344345;Андрей,Иванов,89050377654;Дмитрий,Пономаренко,89344322343;Андрей,Иванов,89150377654;Ева,Дарахвелидзе,89010344346;";
        // Logger log = Logger.getLogger(Homework.class.getName());
        // log.info("Result is:" + hw.creationOfContacts(text));
        Map<String, Integer> result = hw.creationOfContacts(text);

        result.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);

    }

    public Map<String, Integer> creationOfContacts(String text) {
        Map<Long, List<String>> initialContactMap = new HashMap<Long, List<String>>();
        Map<String, Integer> finalContactMap = new HashMap<String, Integer>();

        String[] contacts = text.split(";");
        for (String item : contacts) {
            List<String> compilation = Arrays.asList(item.split(","));
            initialContactMap.putIfAbsent(Long.parseLong(compilation.get(2)),
                    Arrays.asList(compilation.get(0), compilation.get(1)));
        }
        for (List<String> item : initialContactMap.values()) {
            finalContactMap.put(String.join(" ", item),
                    1 + finalContactMap.getOrDefault(String.join(" ", item), 0));
        }
        return finalContactMap;
    }

}
