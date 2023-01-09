package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1
    // человек может иметь несколько телефонов.

    // Написать программу, которая выведет список людей с их телефонами
    // Отсортировать по колличеству телефонов.
    public static void main(final String[] args) {
        Map<String, List<String>> phbook = new TreeMap<>();
        Homework hw = new Homework();

        hw.addPh(phbook, "Иванов И.И.", "88005553535");
        hw.addPh(phbook, "Иванов И.И.", "89188888888");
        hw.addPh(phbook, "Петров П.П.", "84959566361");
        hw.addPh(phbook, "Сидоров С.С.", "01");
        hw.addPh(phbook, "Козлов К.К.", "02");
        hw.addPh(phbook, "Иванов И.И.", "03");
        hw.addPh(phbook, "Петров П.П.", "100");
        hw.addPh(phbook, "Сидоров С.С.", "900");

        System.out.println(phbook);
        hw.printSortPhonebook(phbook);
    }

    public Map<String, List<String>> addPh(Map<String, List<String>> pb, String key, String value) {

        if (!pb.containsKey(key)) {
            List<String> tmp1 = new ArrayList<>();
            tmp1.add(value);
            pb.put(key, tmp1);
        } else {
            List<String> tmp = pb.get(key);
            tmp.add(value);
            pb.put(key, tmp);
        }
        return pb;
    }

    public void printSortPhonebook(Map<String, List<String>> pb) {
        Map<Integer, List<String>> sortedPhonebook = new TreeMap<>();
        for (String name : pb.keySet()) {
            if (!sortedPhonebook.containsKey(pb.get(name).size())) {
                List<String> tmp = new ArrayList<>();
                tmp.add(name);
                sortedPhonebook.put(pb.get(name).size(), tmp);
            } else {
                List<String> tmp1 = sortedPhonebook.get(pb.get(name).size());
                tmp1.add(name);
                sortedPhonebook.put(pb.get(name).size(), tmp1);
            }
        }
        for (Entry<Integer, List<String>> entry : sortedPhonebook.entrySet()) {
            System.out.println(entry.getKey() + " номер(а, ов) -" + entry.getValue());
        }
    }

}