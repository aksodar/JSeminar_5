package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class Decision implements Homework{
    @Override
    public String sortedNames(String data) {
        return String.valueOf(getMap(data));
    }

    private HashMap<String, List<String>> getMap (String input) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<String> namePhone = List.of(input.split(";"));

        for (String item: namePhone) {
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

    private TreeMap<String, Integer> getMapOfCounts(HashMap<String, List<String>> namePhone) {
        TreeMap<String, Integer> result = new TreeMap<>();

        return null;
    }
}