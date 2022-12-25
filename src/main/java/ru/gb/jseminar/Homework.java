package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1
    // человек может иметь несколько телефонов.

    // Написать программу, которая выведет список людей с их телефонами
    // Отсортировать по колличеству телефонов.
    public static void main(final String[] args) {
        Map<String, List<String>> phonebook = new TreeMap<>();
        Homework obj = new Homework();

        obj.addPhone(phonebook, "Люк Скайвокер", "444-222");
        obj.addPhone(phonebook, "Дарт Вейдер", "555-333");
        obj.addPhone(phonebook, "Лея Орегано", "567-897");
        obj.addPhone(phonebook, "C3PO", "785-345");
        obj.addPhone(phonebook, "R2D2", "567-555");
        obj.addPhone(phonebook, "Люк Скайвокер", "333-432");
        obj.addPhone(phonebook, "R2D2", "987-234");
        obj.addPhone(phonebook, "R2D2", "111-111");

        System.out.println(phonebook);
        obj.printSortPhonebook(phonebook);

    }

    public Map<String, List<String>> addPhone(Map<String, List<String>> phonebook, String key, String value) {

        if (!phonebook.containsKey(key)) {
            List<String> tmp1 = new ArrayList<>();
            tmp1.add(value);
            phonebook.put(key, tmp1);
        } else {
            List<String> tmp = phonebook.get(key);
            tmp.add(value);
            phonebook.put(key, tmp);

        }
        return phonebook;
    }

    public void printSortPhonebook(Map<String, List<String>> phonebook) {
        Map<Integer, List<String>> sortedPhonebook = new TreeMap<>();
        for (String name : phonebook.keySet()) {
            if (!sortedPhonebook.containsKey(phonebook.get(name).size())) {
                List<String> tmp = new ArrayList<>();
                tmp.add(name);
                sortedPhonebook.put(phonebook.get(name).size(), tmp);
            } else {
                List<String> tmp1 = sortedPhonebook.get(phonebook.get(name).size());
                tmp1.add(name);
                sortedPhonebook.put(phonebook.get(name).size(), tmp1);
            }
        }
        for (Entry<Integer, List<String>> entry : sortedPhonebook.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
    }

}
