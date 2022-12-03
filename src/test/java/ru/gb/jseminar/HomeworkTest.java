package ru.gb.jseminar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.*;

class HomeworkTest {
    @Test
    void getDuplicateNamesTest() {

        Homework hw = new Homework();
        String st = "Олег,Осипов,891601548783;Олег,Осипов,8901826445;Виталий,Иванов,89779586162;Анна,Смирнова,89201109375;Анна,Смирнова,89265578991;";

        Map<String,Integer> expected = new HashMap<>();
        expected.put("Олег Осипов", 2);
        expected.put("Виталий Иванов", 1);
        expected.put("Анна Смирнова",2);

        Map<String,Integer> actual = hw.getDuplicateNames(st);

        Assertions.assertEquals(expected, actual);
    }
}