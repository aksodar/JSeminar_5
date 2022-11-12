package ru.gb.jseminar;

import java.util.*;
import java.util.stream.Collectors;

public class Decision implements Homework {
    @Override
    public String sortedNames(String data) {
        return String.valueOf(getMapOfCounts(getMap(data)));
    }

    private Map<String, List<String>> getMap(String input) {
        Map<String, List<String>> map = new HashMap<>();
        List<String> namePhone = List.of(input.split(";"));

        for (String item : namePhone) {
            String[] words = item.split(",");
            String key = words[0] + " " + words[1];
            if (map.containsKey(key)) {
                List<String> temp = map.get(key);
                temp.add(words[2]);
                map.put(key, temp);
            } else {
                map.put(key, new ArrayList<>(List.of(words[2])));
            }
        }
        return map;
    }

    private Map<String, Integer> getMapOfCounts(Map<String, List<String>> namePhone) {
        Map<String, Integer> result;
        Map<String, Integer> intermediateResult = new HashMap<>();
        namePhone.forEach((key, value) -> intermediateResult.put(key, value.size()));
        result = intermediateResult.entrySet()
                .stream()
                .filter((entry) -> entry.getValue() > 1)
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new
                ));
        return result;
    }

//    private Map<String, Integer> getSortedByCount(Map<String,Integer> nameCount){
//        Map<String, >
//    }
}