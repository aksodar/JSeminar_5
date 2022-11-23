package ru.gb.jseminar;

import java.util.*;

public class Homework {
    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    // Пусть дан список сотрудников в формате строки
    // "Ева,Дарахвелидзе,89010348765;Ева,Дарахвелидзе,89010344345;Андрей,Иванов,89050377654;Дмитрий,Пономаренко,89344322343;"
    // Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
    // Отсортировать по убыванию популярности.
    public static void main(final String[] args) {
        Homework hw = new Homework();
        String input = "Ева,Дарахвелидзе,89010348765;Ева,Дарахвелидзе,89010344345;Андрей,Иванов,89050377654;Дмитрий,Пономаренко,89344322343;";
        System.out.println(hw.phoneBook(input));
        hw.recurringNames(hw.phoneBook(input));
    }

    public Map<String, List<String>> phoneBook(String data) {
        String[] dataArray = data.split(";");
        Map<String, List<String>> phoneBook = new TreeMap<>();

        for (String item : dataArray) {
            String[] dataTemp = item.split(",");
            String name = dataTemp[0] + " " + dataTemp[1];
            String number = dataTemp[2];
            List<String> temp = new ArrayList<>();
            if (phoneBook.containsKey(name)) {
                temp = phoneBook.get(name);
            }
            temp.add(number);
            phoneBook.put(name, temp);

        }
        return phoneBook;
    }

    public String recurringNames(Map<String, List<String>> phoneBook) {
        Map<Integer, List<String>> sortedByNumbers = new TreeMap<>(Collections.reverseOrder());

        for (String key : phoneBook.keySet()) {

            Integer value = phoneBook.get(key).size();
            if (!sortedByNumbers.containsKey(value)) {
                sortedByNumbers.put(phoneBook.get(key).size(), new ArrayList<String>());
                sortedByNumbers.get(value).add(key);
            } else {
                sortedByNumbers.get(value).add(key);
            }


        }
        System.out.println(sortedByNumbers);
        return sortedByNumbers.toString();
    }

}
