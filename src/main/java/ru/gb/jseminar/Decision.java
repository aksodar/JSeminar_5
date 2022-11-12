package ru.gb.jseminar;

import java.util.*;
import java.util.stream.Collectors;

public class Decision implements Homework {
    @Override
    public String popularNames(String data) {
        return String.valueOf(getMapOfCounts(getMap(data))).replaceAll("[{.+}]", "");
    }

    private Map<String, Integer> getMap(String input) {
        Map<String, Integer> map = new HashMap<>();
        if (input == null) {
            throw new IllegalStateException("String is null");
        } else if (input.isEmpty()) {
            throw new IllegalStateException("String is empty");
        }
        List<String> namePhone = List.of(input.split(";"));

        for (String item : namePhone) {
            String[] words = item.split(",");
            if (words.length == 3
                    && (words[0].chars().allMatch(Character::isLetter))
                    && (words[1].chars().allMatch(Character::isLetter))
                    && (words[2].chars().allMatch(Character::isDigit))) {
                String key = words[0] + " " + words[1];
                if (map.containsKey(key)) {
                    int temp = map.get(key);
                    map.put(key, ++temp);
                } else {
                    map.put(key, 1);
                }
            } else {
                throw new IllegalStateException("String is not valid");
            }
        }
        return map;
    }

    private Map<String, Integer> getMapOfCounts(Map<String, Integer> nameCount) {
        Map<String, Integer> result;
        result = nameCount.entrySet()
                .stream()
                .filter((entry) -> entry.getValue() > 1)
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new
                ));
        return result;
    }
}