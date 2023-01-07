package ru.gb.jseminar;

import java.util.*;

public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    // Написать программу, которая выведет список людей с их телефонами
    // Отсортировать по колличеству телефонов.
    public static void main(final String[] args) {
        Homework hw = new Homework();
        Map<String, List<String>> phoneBook = new HashMap<>();
        phoneBook.put("Иванов И.И.", Arrays.asList("21547895", "12547896", "235231"));
        phoneBook.put("Круглова И.В.", Arrays.asList("111222", "111333"));
        phoneBook.put("Сидоров М.М.", Arrays.asList("5554874"));
        phoneBook.put("Сундукова К.А.", Arrays.asList("11002233", "22001133"));
        phoneBook.put("Репин Т.И.", Arrays.asList("2135231"));
        phoneBook.put("Матвеева С.М.", Arrays.asList("215447896", "235221431"));
        phoneBook.put("Иванов С.И.", Arrays.asList("212145895", "325547896", "235200031"));
        phoneBook.put("Суворова Г.И.", Arrays.asList("215047890"));
        phoneBook.put("Ступин Г.П.", Arrays.asList("6633200", "9998740"));
        phoneBook.put("Карасева Е.И.", Arrays.asList("213265005", "77847896", "3320031"));
        phoneBook.put("Лужин О.Г.", Arrays.asList("478954731"));
        hw.displayBook(phoneBook);
        System.out.println(hw.sortedBook(phoneBook));
    }
    public void displayBook(final Map<String, List<String>> map) {
        for (var item : map.entrySet()) {
            System.out.printf("[%s: %s]\n", item.getKey(), item.getValue());
        }
    }
    public Map<Integer, Map<String, List<String>>> sortedBook(final Map<String, List<String>> phonebook) {
        Map<Integer, Map<String, List<String>>> sortBook = new TreeMap<>();
        for (var item : phonebook.entrySet()) {
            if (!sortBook.containsKey(item.getValue().size())) {
                Map<String, List<String>> temp = new HashMap<>();
                temp.put(item.getKey(), item.getValue());
                sortBook.put(item.getValue().size(), temp);
            } else {
                Map<String, List<String>> temp1 = sortBook.get(item.getValue().size());
                temp1.put(item.getKey(), item.getValue());
                sortBook.replace(item.getValue().size(), temp1);
            }
        }
        return sortBook;
    }
}
