package ru.gb.jseminar;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class HomeworkTest {

    @org.junit.jupiter.api.Test
    void findRepeatsSuccessful() {
        Map<String, Integer> expected = new HashMap<>();
        String phoneBook = "Вася,Пупкин,88002000600;Вася,Пупкин,88002000601;Дядя,Степа,89996666969";
        Homework HW5 = new Homework();
        expected.put("Вася Пупкин",2);
        expected.put("Дядя Степа",1);
        Map<String, Integer> actual = new HashMap<>(HW5.findRepeats(phoneBook));
        Assertions.assertEquals(expected,actual);

    }

    @org.junit.jupiter.api.Test
    void sortRepeatsSuccessful() {
        Map<String, Integer> phoneBook = new HashMap<>();
        Map<String, Integer> expected = new LinkedHashMap<>();
        Homework HW5 = new Homework();
        phoneBook.put("Вася Пупкин",2);
        phoneBook.put("Светка Иванова",3);
        phoneBook.put("Зверь Пушной",5);
        phoneBook.put("Дядя Степа",1);
        Map<String, Integer> actual = new LinkedHashMap<>(HW5.sortRepeats(phoneBook));
        expected.put("Зверь Пушной",5);
        expected.put("Светка Иванова",3);
        expected.put("Вася Пупкин",2);
        Assertions.assertEquals(expected,actual);

    }
}