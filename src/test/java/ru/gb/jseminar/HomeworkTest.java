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
    void textToPhonebookMapSuccessful() {
        String input = "Ева,Дарахвелидзе,89010348765;Ева,Дарахвелидзе,89010344345;Андрей,Иванов,89050377654;";

        Map<Long, List<String>> expectedMap = new HashMap<>();
        expectedMap.put(Long.parseLong("89010348765"), Arrays.asList("Ева", "Дарахвелидзе"));
        expectedMap.put(Long.parseLong("89010344345"), Arrays.asList("Ева", "Дарахвелидзе"));
        expectedMap.put(Long.parseLong("89050377654"), Arrays.asList("Андрей", "Иванов"));

        Map<Long, List<String>> actualMap = (new Homework()).textToPhonebookMap(input);
        Assertions.assertEquals(expectedMap, actualMap);
    }

    @Test
    void repeatNameSuccessful() {
        Map<Long, List<String>> inputMap_1 = new HashMap<>();
        inputMap_1.put(Long.parseLong("89010348765"), Arrays.asList("Ева", "Дарахвелидзе"));
        inputMap_1.put(Long.parseLong("89010344345"), Arrays.asList("Ева", "Дарахвелидзе"));
        inputMap_1.put(Long.parseLong("89050377654"), Arrays.asList("Андрей", "Иванов"));

        Map<Long, List<String>> inputMap_2 = new HashMap<>();
        inputMap_2.put(Long.parseLong("89010348765"), Arrays.asList("Ева", "Дарахвелидзе"));
        inputMap_2.put(Long.parseLong("89010344345"), Arrays.asList("Ева", "Дарахвелидзе"));
        inputMap_2.put(Long.parseLong("89050377654"), Arrays.asList("Андрей", "Иванов"));
        inputMap_2.put(Long.parseLong("89050377655"), Arrays.asList("Андрей", "Иванов"));
        inputMap_2.put(Long.parseLong("89050377656"), Arrays.asList("Андрей", "Иванов"));
        inputMap_2.put(Long.parseLong("89111111111"), Arrays.asList("Иван", "Иванов"));
        inputMap_2.put(Long.parseLong("89121111111"), Arrays.asList("Пётр", "Петров"));
        inputMap_2.put(Long.parseLong("89121111112"), Arrays.asList("Пётр", "Петров"));

        Map<Integer, List<String>> expectedMap_1 = new LinkedHashMap<>();
        expectedMap_1.put(2, Arrays.asList("Ева Дарахвелидзе"));

        Map<Integer, List<String>> expectedMap_2 = new LinkedHashMap<>();
        expectedMap_2.put(3, Arrays.asList("Андрей Иванов"));
        expectedMap_2.put(2, Arrays.asList("Пётр Петров", "Ева Дарахвелидзе"));

        Homework homework = new Homework();

        Map<Integer, List<String>> actualMap_1 = homework.repeatName(inputMap_1);
        Map<Integer, List<String>> actualMap_2 = homework.repeatName(inputMap_2);

        Assertions.assertEquals(expectedMap_1, actualMap_1);
        Assertions.assertEquals(expectedMap_2, actualMap_2);
    }
}