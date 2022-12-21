package ru.gb.jseminar;

import java.util.*;

public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    // Написать программу, которая выведет список людей с их телефонами
    // Отсортировать по количеству телефонов.
    public static void main(final String[] args) {
        Map<String, List<String>> phonebook = new HashMap<>();
        phonebook.put("Иванов И.И.", Arrays.asList("+79532435678"));
        phonebook.put("Петров П.П.", Arrays.asList("+79532435676", "+79532435677", "+79532435679"));
        phonebook.put("Сидоров С.С.", Arrays.asList("+79532435671", "+79532435672"));
        Homework hw = new Homework();
        hw.getSortedPhonebook(phonebook);
    }

    public void getSortedPhonebook(Map<String, List<String>> phonebook){
        System.out.println(phonebook);

        Map<Integer, String> countNumbers = new TreeMap<>();

        for (String i : phonebook.keySet()) {
            List phones = phonebook.get(i);
            countNumbers.put(phones.size(), i);
        }

        for (int i = countNumbers.size(); i > 0; i--) {
            System.out.println(countNumbers.get(i) + phonebook.get(countNumbers.get(i)).toString());
        }
    }
}
