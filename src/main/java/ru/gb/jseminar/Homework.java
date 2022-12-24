package ru.gb.jseminar;

import java.util.*;

public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    // Написать программу, которая выведет список людей с их телефонами
    // Отсортировать по колличеству телефонов.
    public static void main(final String[] args) {
        Homework hw = new Homework();
        Map<String, List> telBook = new HashMap<>();
        List<String> telIvanov = new ArrayList<>();
        telIvanov.add("8-800-987-74-41");
        telIvanov.add("8-800-789-96-63");
        telIvanov.add("8-800-963-32-12");
        telBook.put("Иванов", telIvanov);
        List<String> telPetrov = new ArrayList<>();
        telPetrov.add("8-800-654-45-56");
        telPetrov.add("8-800-654-74-96");
        telBook.put("Петров", telPetrov);
        List<String> telSidorov = new ArrayList<>();
        telSidorov.add("8-800-321-23-21");
        telSidorov.add("8-800-321-78-98");
        telSidorov.add("8-800-321-45-65");
        telSidorov.add("8-800-321-54-56");
        telBook.put("Сидоров", telSidorov);

        hw.printBook(telBook);
    }

    public void printBook(Map<String, List> map){
        Map<Integer, String> sortedBook = new TreeMap<>();
        for (String item : map.keySet()) {
            sortedBook.put(map.get(item).size(), item);
        }
        for (Integer i : sortedBook.keySet()) {
            System.out.println(sortedBook.get(i) + map.get(sortedBook.get(i)));
        }
    }
}
