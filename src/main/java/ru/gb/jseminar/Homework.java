package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    // Написать программу, которая выведет список людей с их телефонами и 
    // Отсортировать по убыванию популярности.
    public static void main(final String[] args) {
        Map <String, List<Integer>> book = new HashMap<>();
        book.put("Sidorov",List.of(999,777,888));
        book.put("Fedorov",List.of(111));
        book.put("Ivanov",List.of(666,555));
        book.put("Frolov",List.of(333,222));
        Homework test = new Homework();
        test.popNumb(book);       
        
    }

    public void popNumb(final Map<String,List<Integer>> map) {
        Map <Integer,List<String>> sizeOfNumbers = new TreeMap<>();
        for (String i : map.keySet()) {
            int a = map.get(i).size();
            if (sizeOfNumbers.containsKey(a)){
                List <String> b = new ArrayList<>();
                b.addAll(sizeOfNumbers.get(a));
                b.add(i);
                sizeOfNumbers.put(a, b);
            } else {
                sizeOfNumbers.put(a, Arrays.asList(i));
            }
        }
        for (Integer i : sizeOfNumbers.keySet()) {
            for (String j : sizeOfNumbers.get(i)) {
                System.out.println(j +": " + map.get(j));
            }
           
        }
        
    }

}
