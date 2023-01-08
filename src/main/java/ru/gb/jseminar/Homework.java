package ru.gb.jseminar;

import java.util.*;

public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
// Написать программу, которая выведет список людей с их телефонами
// Отсортировать по колличеству телефонов.
    public static void main(final String[] args) {
        Homework hw = new Homework();
        String name = " Mask Ilon  +7-888-555-33-22, Ivanov Ivan Ivanovich 8-915-555-66-44, mask Ilon  8-917-564-89-96, Sidorov Sidor 69-69-69, " +
                "Gates Bill 55-96-55, Gates Bill 78-89-55, Gates Bill +7918+555-66-77, petrov petr 56-88-96 ";
        System.out.println(hw.telBook(name));
        System.out.println();
        hw.printtelbook(hw.telBook(name));
        System.out.println();
        System.out.println(hw.sorttelbook(hw.telBook(name )));

    }

    public Map<String, List<String>> telBook(String text) {
        Map<String, List<String>> book = new HashMap<>();
        List<String> list = Arrays.asList(text.split(","));
        for (String i : list) {
            List<String> temp = Arrays.asList(i.trim().toUpperCase().split(" "));
            String nam = null;
            if (temp.size() == 4) {
                nam = temp.get(0) + " " + temp.get(1) + " " + temp.get(2);
            } else {
                nam = temp.get(0) + " " + temp.get(1);
            }
            if (!book.containsKey(nam)) {
                List<String> telbook = new ArrayList<>();
                telbook.add(temp.get(temp.size() - 1));
                book.put(nam, telbook);
            } else {
                String phone = temp.get(temp.size() - 1);
                book.get(nam).addAll(Arrays.asList(phone));
            }
        }
        return book;
    }

    public  Map<String,List<String>> printtelbook(Map<String,List<String>> book){
        for (String item: book.keySet()) {
            System.out.println(item + book.get(item));
        }
        return book;
    }

    public Map<Integer, List<String>> sorttelbook(Map<String, List<String>> book) {
        Map<Integer, List<String>> result = new HashMap<>();
        {

            for (String item : book.keySet()) {
                if (book.get(item).size() > 0) {
                    int count = book.get(item).size();
                    if (!result.containsKey(count)) {
                        List<String> name = new ArrayList<>();
                        name.add(item+book.get(item));
                        result.put(count, name);
                    } else {
                        String name = item + book.get(item);
                        result.get(count).addAll(Arrays.asList(name));
                    }
                }
            }
            return result;
        }
    }
}


