package ru.gb.jseminar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
// Написать программу, которая выведет список людей с их телефонами
// Отсортировать по количеству телефонов.

public class Homework {
    public static void main(final String[] args) {
        Homework pb = new Homework();
        Map<String, List<String>> phonebook = pb.bookMaker();
        System.out.println(ANSIConstants.ANSI_WHITE_BACKGROUND + ANSIConstants.ANSI_BLACK + "Список контактов: "
                + ANSIConstants.ANSI_RESET);
        for (Object obj : phonebook.entrySet()) {
            Map.Entry<String, List<String>> entry = (Map.Entry) obj;
            System.out.print("Имя: " + entry.getKey());
            System.out.println("   тел.: " + entry.getValue());
        }
        System.out.println();
        System.out.println(ANSIConstants.ANSI_WHITE_BACKGROUND + ANSIConstants.ANSI_BLACK
                + "Список отсортирован по количеству номеров: " + ANSIConstants.ANSI_RESET);
        Map<Integer, Map<String, List<String>>> sorted = pb.sortByTelCount(phonebook);
        for (Object obj : sorted.entrySet()) {
            Map.Entry entry = (Map.Entry) obj;
            System.out.print("Кол-во: " + entry.getKey());
            System.out.println("   Контакты: " + entry.getValue());
        }
    }

    public Map<String, List<String>> bookMaker() {
        Homework pb = new Homework();
        Map<String, List<String>> book = new HashMap<>();
        book = pb.addPhoneNumber("Гресева А.А.", "89173273868", book);
        book = pb.addPhoneNumber("Воробьева В.В.", "8985445687", book);
        book = pb.addPhoneNumber("Воробьев В.В.", "88085426935", book);
        book = pb.addPhoneNumber("Гусева Г.Г.", "83476566880", book);
        book = pb.addPhoneNumber("Гусева Г.Г.", "89175467558", book);
        book = pb.addPhoneNumber("Гусева Г.Г.", "89874563774", book);
        book = pb.addPhoneNumber("Иванов И.И.", "83478566440", book);
        book = pb.addPhoneNumber("Кузнецов К.К.", "89653443772", book);
        book = pb.addPhoneNumber("Кузнецов К.К.", "83475547253", book);
        return book;
    }

    public Map<String, List<String>> addPhoneNumber(String name, String tel, Map<String, List<String>> phonebook) {
        if (phonebook.containsKey(name)) {
            List<String> update = phonebook.get(name);
            update.add(tel);
            phonebook.put(name, update);
        } else {
            List<String> newNote = new ArrayList<>();
            newNote.add(tel);
            phonebook.put(name, newNote);
        }
        return phonebook;
    }

    public Map<Integer, Map<String, List<String>>> sortByTelCount(Map<String, List<String>> phonebook) {
        Map<Integer, Map<String, List<String>>> sortByCount = new HashMap<>();
        for (String name : phonebook.keySet()) {
            if (!sortByCount.containsKey(phonebook.get(name).size())) {
                Map<String, List<String>> data = new HashMap<>();
                data.put(name, phonebook.get(name));
                sortByCount.put(phonebook.get(name).size(), data);
            } else {
                Map<String, List<String>> data = sortByCount.get(phonebook.get(name).size());
                data.put(name, phonebook.get(name));
                sortByCount.put(phonebook.get(name).size(), data);
            }
        }
        return sortByCount;
    }
}
