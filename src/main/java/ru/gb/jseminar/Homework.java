package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    // Пусть дан список сотрудников:Иван Иванов (и остальные, полный текст дз будет на платформе)
    // Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
    // Отсортировать по убыванию популярности.

    public static void main(final String[] args) {
        Homework hw = new Homework();
        String text = "Ева,Дарахвелидзе,89010348765;Ева,Дарахвелидзе,89010344345;Андрей,Иванов,89050377654;Дмитрий,Пономаренко,89344322343;";
        System.out.println(hw.searchForDuplicateNames(text));
    }

    public Map<Integer, List<String>> searchForDuplicateNames(final String inputText) {
        
        Map<String, List<String>> phoneBook = new HashMap<>();
        
        for (String item : inputText.toLowerCase().split(";")) {
            List<String> inputTextList = Arrays.asList(item.split(","));
            String person = inputTextList.get(0) + " " + inputTextList.get(1);
            if (!phoneBook.containsKey(person)) {
                List<String> phones = new ArrayList<>();
                phones.add(inputTextList.get(2));
                phoneBook.put(person, phones);
            } else {
                String phones = inputTextList.get(2);
                phoneBook.get(person).addAll(Arrays.asList(phones));
            }
        }

        Map<Integer, List<String>> phonesCounter = new TreeMap<>(Collections.reverseOrder());
        
        for (String person : phoneBook.keySet()) {
            if (phoneBook.get(person).size() > 1) {
                Integer counter = phoneBook.get(person).size();
                if (!phonesCounter.containsKey(counter)){
                    List<String> namesList = new ArrayList<>();
                    namesList.add(person);
                    phonesCounter.put(counter, namesList);
                } else {
                    String values = person;
                    phonesCounter.get(counter).addAll(Arrays.asList(values));
                }
            }
        }
        return phonesCounter;
    }
}
