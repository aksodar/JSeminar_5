package ru.gb.jseminar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


class HomeworkTest {
    @Test
    void searchForDuplicateNames(){
        String text = "Ева,Дарахвелидзе,89010348765;Ева,Дарахвелидзе,89010344345;Андрей,Иванов,89050377654;Дмитрий,Пономаренко,89344322343;";
        Map<Integer, List<String>> expected = new TreeMap<>();
        expected.put(2, Arrays.asList("ева дарахвелидзе"));

        
        Homework hmw = new Homework();
        Map<Integer, List<String>> actual = hmw.searchForDuplicateNames(text);
        
        Assertions.assertEquals(expected, actual);
    }
}
