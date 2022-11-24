package ru.gb.jseminar;

import java.util.*;
import java.util.logging.Logger;

public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    // Пусть дан список сотрудников:Иван Иванов (и остальные, полный текст дз будет на платформе)
    // Пусть дан список сотрудников в формате строки
    // "Ева,Дарахвелидзе,89010348765;Ева,Дарахвелидзе,89010344345;Андрей,Иванов,89050377654;Дмитрий,Пономаренко,89344322343;"
    // Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
    // Отсортировать по убыванию популярности.
    public static void main(final String[] args) {

        Homework hw = new Homework();

        String text = "Елена,Макагон,89010348765;Денис,Ивванов,375291234567;Елена,Макагон,89010344345;" +
                "Андрей,Иванов,89050377654;Елена,Макагон,89010345050;Дмитрий,Пономаренко,89344322343;" +
                "Денис,Ивванов,375296781519;Денис,Ивванов,375291234567;Андрей,Иванов,12345678912;Денис,Ивванов," +
                "375297654321";

        Logger log = Logger.getLogger(Homework.class.getName());
        Map<String, List<String>> phonebook = hw.createPhonebook(text);
        log.info("phonebook:  " + phonebook.toString().replaceAll("[{*}]", ""));
        log.info("Contacts with more than 1 number:  " +
                hw.getMoreThanOneNumgber(phonebook).toString().replaceAll("[{*}]", ""));

    }

    public Map<String, List<String>> createPhonebook(String text) {

        List<String> contacts = Arrays.asList(text.split(";"));
        Map<String, List<String>> phonebook = new HashMap<>();

        for (String item: contacts) {
            List<String> temp = Arrays.asList(item.split(","));
            String key = temp.get(0) + " " + temp.get(1);

            if(!phonebook.containsKey(key)) {
                List<String> value = new ArrayList<>();
                value.add(temp.get(2));
                phonebook.put(key, value);
            } else {
                String value = temp.get(2);
                phonebook.get(key).addAll(Arrays.asList(value));
            }
        }
        return phonebook;
    }

    public Map<Integer, List<String>> getMoreThanOneNumgber(Map<String, List<String>> phonebook) {

        Map<Integer, List<String>> result = new TreeMap<>(Collections.reverseOrder());

        for (String item: phonebook.keySet()) {
            if (phonebook.get(item).size() > 1) {
                int key = phonebook.get(item).size();
                if (!result.containsKey(key)) {
                    List<String> value = new ArrayList<>();
                    value.add(item);
                    result.put(key, value);
                } else {
                    String value = item;
                    result.get(key).addAll(Arrays.asList(value));
                }
            }
        }
        return result;
    }

}