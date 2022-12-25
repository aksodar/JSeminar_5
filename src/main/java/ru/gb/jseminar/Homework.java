package ru.gb.jseminar;

import java.util.*;
import java.util.Map.Entry;

public class Homework {

// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
// Написать программу, которая выведет список людей с их телефонами
// Отсортировать по количеству телефонов
    public static void main(final String[] args) {
        Map<String, List<String>> phonebook = new TreeMap<>();
        Homework hw = new Homework();

        hw.getAddPhone(phonebook, "Иванов", "+79119009090");
        hw.getAddPhone(phonebook, "Иванов", "+79458761324");
        hw.getAddPhone(phonebook, "Петров", "+74956778899");
        hw.getAddPhone(phonebook, "Сидоров", "+79002220033");
        hw.getAddPhone(phonebook, "Фандорин", "+74951000202");
        hw.getAddPhone(phonebook, "Фандорин", "+79008001000");
        hw.getAddPhone(phonebook, "Фандорин", "+79874567128");
        System.out.println(phonebook);
        hw.getSortPhoneBook(phonebook);

    }

    public Map<String, List<String>> getAddPhone(Map<String, List<String>> phonebook, String key, String value) {

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

    public void getSortPhoneBook(Map<String, List<String>> phonebook) {
        Map<Integer, List<String>> sortedPhoneBook = new TreeMap<>();
        for (String name : phonebook.keySet()) {
            if (!sortedPhoneBook.containsKey(phonebook.get(name).size())) {
                List<String> tmp = new ArrayList<>();
                tmp.add(name);
                sortedPhoneBook.put(phonebook.get(name).size(), tmp);
            } else {
                List<String> tmp1 = sortedPhoneBook.get(phonebook.get(name).size());
                tmp1.add(name);
                sortedPhoneBook.put(phonebook.get(name).size(), tmp1);
            }
        }
        for (Entry<Integer, List<String>> entry : sortedPhoneBook.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
    }
}

