
package ru.gb.jseminar;

import java.util.*;

public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    // Написать программу, которая выведет список людей с их телефонами
    // Отсортировать по количеству телефонов.
    public static void main(final String[] args) {
        Homework hw = new Homework();
        Map<String, List<String>> phonebook = new HashMap<>();
        phonebook.put("Белый И.А.", Arrays.asList("574154711"));
        phonebook.put("Черный О.Ю.", Arrays.asList("599006910", "595577365", "599392618"));
        phonebook.put("Краснов К.М.", Arrays.asList("555996325", "557918009"));
        phonebook.put("Чижик П.Ж.", Arrays.asList("511146879", "557352323","556874534","559459867"));

        hw.SortPhonebook(phonebook);
    }

    public void SortPhonebook(Map<String, List<String>> phonebook){
        System.out.println(phonebook);
        System.out.println();

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

