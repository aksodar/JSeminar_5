package ru.gb.jseminar;

import com.sun.jdi.Value;

import java.util.*;

public class Homework {
    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    // Пусть дан список сотрудников в формате строки
    // "Ева,Дарахвелидзе,89010348765;Ева,Дарахвелидзе,89010344345;Андрей,Иванов,89050377654;Дмитрий,Пономаренко,89344322343;"
    // Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
    // Отсортировать по убыванию популярности.
    public static void main(final String[] args) {
        Homework HW = new Homework();
        String phoneBook = "Ева,Дарахвелидзе,89010348765;Ева,Дарахвелидзе,89010344345;Андрей,Иванов,89050377654;Дмитрий,Пономаренко,89344322343;Андрей,Иванов,89050377654;Андрей,Иванов,89050377654;";
        System.out.println(HW.findRepeats(phoneBook));
        System.out.println(HW.sortRepeats(HW.findRepeats(phoneBook)));
    }

    public Map<String, Integer> findRepeats(String inputString){
        Map<String,Integer> personMap = new HashMap<>();
        List<String> personList = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        String name;
        personList = List.of(inputString.split(";"));
        for (String person: personList) {
            temp = List.of(person.split(","));
            name = temp.get(0) + " " + temp.get(1);
            if (personMap.containsKey(name)){
                personMap.replace(name, personMap.get(name) + 1);
            }
            else {
                personMap.put(name, 1);
            }
        }
        return personMap;
    }

    public Map<String, Integer> sortRepeats(Map<String, Integer> unsortedMap){
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        int max = 0;
        for (Integer value: unsortedMap.values()) {
            if (value > max){
                max = value;
            }
        }
        for (int i = max; i > 1; i--) {
            for (String person: unsortedMap.keySet()) {
                if (unsortedMap.get(person).equals(i)){
                    sortedMap.put(person, i);
                }
            }
        }
        return sortedMap;
    }
}
