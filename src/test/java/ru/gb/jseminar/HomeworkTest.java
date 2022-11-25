package ru.gb.jseminar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class HomeworkTest {

    @Test
    void getDuplicateNamesTest() {

        Homework hw = new Homework();
        String st = "Яна,Степанова,89010348765;Яна,Степанова,89010344345;Владислав,Иванов,89050377654;Дмитрий,Соколов,89344322343;Дмитрий,Соколов,89010340045;";

        Map<String,Integer> expected = new HashMap<>();
        expected.put("Яна Степанова", 2);
        expected.put("Владислав Иванов", 1);
        expected.put("Дмитрий Соколов",2);

        Map<String,Integer> actual = hw.getDuplicateNames(st);

        Assertions.assertEquals(expected, actual);
    }
}