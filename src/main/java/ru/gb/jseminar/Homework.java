package ru.gb.jseminar;

import java.util.*;
import java.util.stream.Collectors;

public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    // Написать программу, которая выведет список людей с их телефонами
    // Отсортировать по колличеству телефонов.
    public static void main(final String[] args) {
        Map<String, List<String>> phoneBook = new HashMap<>();
        phoneBook.put("Четырехтелефонный Иван Иванович", Arrays.asList("57-22-55", "66-77-88", "66-88-99", "55-66-33-33"));
        phoneBook.put("Однотелефонный Петр Иванович", Arrays.asList("59-22-55"));
        phoneBook.put("Двухтелефонный Руслан Иванович", Arrays.asList("56-22-55", "68-78-88"));
        phoneBook.put("Трехтелефонный Олег Иванович", Arrays.asList("52-22-55", "69-00-88", "00-77-88"));

        Homework hw = new Homework();
        System.out.println(hw.SortByQuantityPhoneNumbers(phoneBook));

    }

    public LinkedHashMap <String, List<String>> SortByQuantityPhoneNumbers(Map<String, List<String>> phoneBook){

        Map<String, List<String>> sortMap = phoneBook.entrySet().stream()
                .sorted(Comparator.comparingInt(el-> el.getValue().size()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> { throw new AssertionError(); },
                        LinkedHashMap::new
                ));

        return (LinkedHashMap<String, List<String>>) sortMap;
    }

}
