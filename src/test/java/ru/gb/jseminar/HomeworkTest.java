package ru.gb.jseminar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class HomeworkTest {
    @Test
    void createPhonebookSuccessful() {

        Homework hw = new Homework();
        String entryString = "Ева,Дарахвелидзе,89010348765;Ева,Дарахвелидзе,89010344345;Андрей,Иванов,89050377654;" +
                "Дмитрий,Пономаренко,89344322343;";
        Map<String, List<String>> expectedMap = new LinkedHashMap<>();
        expectedMap.put("Андрей Иванов", List.of("89050377654"));
        expectedMap.put("Дмитрий Пономаренко", List.of("89344322343"));
        expectedMap.put("Ева Дарахвелидзе", Arrays.asList("89010348765", "89010344345"));

        Map<String, List<String>> actualMap = hw.createPhonebook(entryString);

        Assertions.assertEquals(expectedMap, actualMap);

    }
    @Test
    void getMoreThanOneNumberSuccessful() {

        Homework hw = new Homework();

        Map<String, List<String>> entryMap = new HashMap<>();
        entryMap.put("Ева Дарахвелидзе", Arrays.asList("89010348765", "89010344345"));
        entryMap.put("Андрей Иванов", List.of("89050377654"));
        entryMap.put("Дмитрий Пономаренко", List.of("89344322343"));

        Map<Integer, List<String>> expectedMap = new TreeMap<>(Collections.reverseOrder());
        expectedMap.put(2, List.of("Ева Дарахвелидзе"));

        Map<Integer, List<String>> actualMap = hw.getMoreThanOneNumgber(entryMap);

        Assertions.assertEquals(expectedMap, actualMap);
    }

}