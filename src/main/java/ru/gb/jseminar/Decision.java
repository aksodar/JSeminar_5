package ru.gb.jseminar;

import java.util.*;
import java.util.stream.Collectors;

public class Decision implements Homework {
    @Override
    public String popularNames(String data) {

        Map<String, Integer> check = getMapOfCounts(getMap(data));
        Set<Integer> popular = new HashSet<>();
        String answer = String.valueOf(check).replaceAll("[{.+}]", "");

        int count = check.values().stream()
                .filter(e -> !popular.add(e))
                .collect(Collectors.toSet()).size();

        if (count == 1 && check.size() > 1) {
            return "All people are equally popular";
        }
        else if (answer.isEmpty()) {
            return "All people have one number";
        } else return answer;
    }

    private Map<String, List<String>> getMap(String input) {
        Map<String, List<String>> map = new HashMap<>();
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
                    List<String> temp = map.get(key);
                    if (!temp.contains(words[2])) {
                        temp.add(words[2]);
                        map.put(key, temp);
                    }
                } else {
                    map.put(key, new ArrayList<>(List.of(words[2])));
                }
            } else {
                throw new IllegalStateException("String is not valid");
            }
        }
        return map;
    }

    private Map<String, Integer> getMapOfCounts(Map<String, List<String>> namePhone) {
        Map<String, Integer> result;
        Map<String, Integer> nameCount = new HashMap<>();
        namePhone.forEach((key, value) -> nameCount.put(key, value.size()));
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