package ru.gb.jseminar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;



class HomeworkTest {
    @Test
    void getSortedPopularSuccessfully() {
        String str = "Ева,Дарахвелидзе,89010348765;Андрей,Иванов,89050377654;Андрей,Иванов,89050377654;Ева,Дарахвелидзе,89010344345;Ева,Дарахвелидзе,89010348765;Дмитрий,Пономаренко,89344322343;";
        List<String> actual = new Homework().getSortedPopular(str);
        List<String> expected = new ArrayList(Arrays.asList("3 ева дарахвелидзе", "2 андрей иванов", "1 дмитрий пономаренко"));
        Assertions.assertIterableEquals(expected, actual);
    }
}