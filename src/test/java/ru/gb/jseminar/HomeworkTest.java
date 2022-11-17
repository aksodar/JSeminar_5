package ru.gb.jseminar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class HomeworkTest {

    @Test
    void searchForDuplicateNames() {
        String input = "Андрей,Иванов,89050377654;" +
                "Дмитрий,Пономаренко,89344322343;Дмитрий,Пономаренко,89344322234;Дмитрий,Пономаренко,89343462343;" +
                "Ева,Дарахвелидзе,89010398365;Ева,Дарахвелидзе,89010334785;Андрей,Иванов,89050355554;" +
                "Галина,Васильева,89053457654;";
        Map<Integer, List<String>> expectedMap = new TreeMap<>();
        expectedMap.put(3, Arrays.asList("дмитрий пономаренко"));
        expectedMap.put(2, Arrays.asList("андрей иванов", "ева дарахвелидзе"));
        Map<Integer, List<String>> actualMap = (new Homework()).searchForDuplicateNames(input);
        Assertions.assertEquals(expectedMap, actualMap);

//        {3=[дмитрий пономаренко], 2=[андрей иванов, ева дарахвелидзе]}
    }
}