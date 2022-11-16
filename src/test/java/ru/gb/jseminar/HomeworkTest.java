package ru.gb.jseminar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Arrays;

class HomeworkTest {

    @Test
    void generateContactSuccessful() {
        //что-то исходное
        String input = "Ева,Дарахвелидзе,89010348765;Ева,Дарахвелидзе,89010344345;Андрей,Иванов,89050377654;";

        //что-то делаем
        Map<Long, List<String>> expectedMap = new HashMap<>();
        expectedMap.put(Long.parseLong("89010348765"), Arrays.asList("Ева", "Дарахвелидзе"));
        expectedMap.put(Long.parseLong("89010344345"), Arrays.asList("Ева", "Дарахвелидзе"));
        expectedMap.put(Long.parseLong("89050377654"), Arrays.asList("Андрей", "Иванов"));

        //проверяем
        Map<Long, List<String>> actualMap = (new Homework()).generateContacts(input);
        Assertions.assertEquals(expectedMap, actualMap);
    }

    @Test
    void duplicateContactSuccessful() {

        //что-то исходное
        Map<Long, List<String>> inputMap_1 = new HashMap<>();
        inputMap_1.put(Long.parseLong("89010348765"), Arrays.asList("Ева", "Дарахвелидзе"));
        inputMap_1.put(Long.parseLong("89010344345"), Arrays.asList("Ева", "Дарахвелидзе"));
        inputMap_1.put(Long.parseLong("89050377654"), Arrays.asList("Андрей", "Иванов"));


        //что-то делаем
        Map<Integer, List<String>> expectedMap_1 = new LinkedHashMap<>();
        expectedMap_1.put(2, List.of("Ева Дарахвелидзе"));


        Homework homework = new Homework();

        //проверяем
        Map<Integer, List<String>> actualMap_1 = homework.duplicateContact(inputMap_1);

        Assertions.assertEquals(expectedMap_1, actualMap_1);

    }
}