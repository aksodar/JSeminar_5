package ru.gb.jseminar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.ArrayList;

class HomeworkTest extends Homework{
    @Test
    void parseStringToMapTest(){
        //Исходные значения
        String rawString = "Андрей,Иванов,89991234523";
        HashMap<String, ArrayList<String>> expectedHashMap = new HashMap<>();
        expectedHashMap.put("Андрей Иванов", new ArrayList<String>());
        expectedHashMap.get("Андрей Иванов").add("89991234523");
        expectedHashMap.get("Андрей Иванов").add("89991234524");
        expectedHashMap.get("Андрей Иванов").add("89991234525");
        expectedHashMap.get("Андрей Иванов").add("89991234526");

        //Assertion
        Assertions.assertEquals(expectedHashMap, parseStringToMap(rawString));
    }

    @Test
    void getNumberDuplicateName(){
        //Исходные данные
        HashMap<String, ArrayList<String>> actualHashMap = new HashMap<>();
        actualHashMap.put("Андрей Иванов", new ArrayList<String>());
        actualHashMap.get("Андрей Иванов").add("89991234523");
        actualHashMap.get("Андрей Иванов").add("89991234524");
        actualHashMap.get("Андрей Иванов").add("89991234525");
        actualHashMap.get("Андрей Иванов").add("89991234526");
        NavigableMap<Integer, ArrayList<String>> expectedNavigableMap = new TreeMap<Integer, ArrayList<String>>();
        expectedNavigableMap.put(4, new ArrayList<String>());
        expectedNavigableMap.get(4).add("Андрей Иванов");

        //Assertion
        Assertions.assertEquals(expectedNavigableMap, getNumberDuplicateName(actualHashMap));

    }

}