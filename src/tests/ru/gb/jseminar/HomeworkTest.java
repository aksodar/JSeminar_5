package ru.gb.jseminar;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.testng.Assert.*;

public class HomeworkTest {
    Homework hw = new Homework();

    @Test
    public void testTelephoneBookFill() {
        Map<String, ArrayList<String>> actual;
        Map<String, ArrayList<String>> expected = new HashMap<>();
        actual = hw.telephoneBookFill("������������,���,89010348765;�����������,���,89344322343;");
        expected.put("������������", new ArrayList<>(Arrays.asList("89010348765".split(","))));
        expected.put("�����������", new ArrayList<>(Arrays.asList("89344322343".split(","))));
        expected.put("���", new ArrayList<>(Arrays.asList("89010348765,89344322343".split(","))));
        Assertions.assertEquals(expected.size(), actual.size());
        for (String item : actual.keySet()) {
            Assertions.assertTrue(expected.containsKey(item));
            Assertions.assertEquals(expected.get(item), actual.get(item));
        }
    }


    @Test
    public void testNamesRepeatedCount() {
        Map<String, ArrayList<String>> actualMap = new HashMap<>();
        actualMap.put("������������", new ArrayList<>(Arrays.asList("89010348765".split(","))));
        actualMap.put("�����������", new ArrayList<>(Arrays.asList("89344322343".split(","))));
        actualMap.put("���", new ArrayList<>(Arrays.asList("89010348765,89344322343".split(","))));
        Map<String, Integer> actual;
        Map<String, Integer> expected = new HashMap<>();
        actual = hw.namesRepeatedCount(actualMap, 2);
        expected.put("���", 2);
        Assertions.assertEquals(expected.size(), actual.size());
        for (String item : actual.keySet()) {
            Assertions.assertTrue(expected.containsKey(item));
            Assertions.assertEquals(expected.get(item), actual.get(item));
        }
    }


    @Test
    public void testCountNamesRepeatedDescending() {
        Map<String, ArrayList<String>> actualMap = new HashMap<>();
        actualMap.put("������������", new ArrayList<>(Arrays.asList("89010348765".split(","))));
        actualMap.put("�����������", new ArrayList<>(Arrays.asList("89344322343".split(","))));
        actualMap.put("���", new ArrayList<>(Arrays.asList("89010348765,89344322343".split(","))));
        Map<Integer, ArrayList<String>> actual;
        Map<Integer, ArrayList<String>> expected = new LinkedHashMap<>();
        actual = hw.countNamesRepeatedDescending(hw.countNamesRepeatedAscending(hw.namesRepeatedCount(actualMap,1)));
//        2=[������������, ���], 1=[�����������, ������, �������, ������]
        expected.put(2, new ArrayList<>(Arrays.asList("���".split(","))));
        expected.put(1, new ArrayList<>(Arrays.asList("������������,�����������".split(","))));
        Assertions.assertEquals(expected.size(), actual.size());
        for (Integer item : actual.keySet()) {
            Assertions.assertTrue(expected.containsKey(item));
            Assertions.assertEquals(expected.get(item), actual.get(item));
        }
    }
}