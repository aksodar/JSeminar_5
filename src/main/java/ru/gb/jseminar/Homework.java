package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1
    // человек может иметь несколько телефонов.

    // Написать программу, которая выведет список людей с их телефонами
    // Отсортировать по количеству телефонов.
    public static void main(final String[] args) {
        Homework hw = new Homework();
        List<ArrayList<String>> initialPhone = new ArrayList<>();
        initialPhone.add(new ArrayList<>(Arrays.asList("Иванов Федор Петрович", "8-911-240-41-80")));
        initialPhone.add(new ArrayList<>(Arrays.asList("Степанова Ирина Геннадьевна", "8-921-736-37-34")));
        initialPhone.add(new ArrayList<>(Arrays.asList("Степанова Ирина Геннадьевна", "8-910-888-73-06")));
        initialPhone.add(new ArrayList<>(Arrays.asList("Луговая Мария Игоревна", "8-950-345-16-08")));
        initialPhone.add(new ArrayList<>(Arrays.asList("Иванов Иван Петрович", "8-950-003-40-43")));
        initialPhone.add(new ArrayList<>(Arrays.asList("Иванов Иван Петрович", "8-911-340-11-22")));
        initialPhone.add(new ArrayList<>(Arrays.asList("Иванов Иван Петрович", "8-921-789-23-44")));
        initialPhone.add(new ArrayList<>(Arrays.asList("Белов Аркадий Алексеевич", "8-921-234-17-22")));
        initialPhone.add(new ArrayList<>(Arrays.asList("Белов Аркадий Алексеевич", "8-981-097-56-78")));
        Map<String, List<String>> mapBook = hw.getTelephoneBook(initialPhone);
        System.out.println("--------------------------------------------------------");
        System.out.println("Несортированный справочник номеров: --> \n" + mapBook);
        System.out.println("--------------------------------------------------------");
        System.out.println(
                "Справочник отсортирован по кол-ву номеров абонентов: --> \n" + hw.sortedPopularTelephoneBook(mapBook));
    }

    public Map<String, List<String>> getTelephoneBook(final List<ArrayList<String>> initialList) {
        Map<String, List<String>> phoneBook = new HashMap<>();
        for (ArrayList<String> item : initialList) {
            if (!phoneBook.containsKey(item.get(0))) {
                List<String> tempList = new ArrayList<>();
                tempList.add(item.get(1));
                phoneBook.put(item.get(0), tempList);
            } else {
                List<String> tempList2 = phoneBook.get(item.get(0));
                tempList2.add(item.get(1));
                phoneBook.put(item.get(0), tempList2);
            }
        }

        return phoneBook;
    }

    // сортируем по кол-ву телефонов в порядке убывания (сначала больше телефонов)
    public Map<Integer, Map<String, List<String>>> sortedPopularTelephoneBook(
            final Map<String, List<String>> listToPopularSort) {
        Map<Integer, Map<String, List<String>>> tempMap = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<String, List<String>> element : listToPopularSort.entrySet()) {
            Map<String, List<String>> temp = new HashMap<>();
            temp.put(element.getKey(), element.getValue());
            if (tempMap.containsKey(element.getValue().size())) {
                for (Map.Entry<String, List<String>> el : tempMap.get(element.getValue().size()).entrySet()) {
                    temp.put(el.getKey(), el.getValue());
                }
            }
            tempMap.put(element.getValue().size(), temp);
        }
        return tempMap;
    }
}
