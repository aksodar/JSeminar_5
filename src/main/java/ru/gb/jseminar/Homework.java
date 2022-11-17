package ru.gb.jseminar;

import java.util.*;
import java.util.stream.Collectors;

import java.util.logging.Logger;

public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    // Пусть дан список сотрудников:Иван Иванов (и остальные, полный текст дз будет на платформе)
    // Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
    // Отсортировать по убыванию популярности.

    private static final Homework hw = new Homework();
    private static final Logger logger = Logger.getLogger(Homework.class.getName());

    public static void main(final String[] args) {

        logger.info(String.valueOf(hw.popNames("Ева,Дарахвелидзе,89010348765;Ева,Дарахвелидзе,89010344345;Андрей,Иванов,89050377654;Дмитрий,Пономаренко,89344322343;")));
    }

    public String popNames(final String data) {

        Map<String, Integer> tmp = getMapOfCounts(getMap(data));
        Set<Integer> pop = new HashSet<>();
        String answer = String.valueOf(tmp).replaceAll("[{.+}]", "");

        int count = tmp.values().stream().filter(e -> !pop.add(e)).collect(Collectors.toSet()).size();

        if (answer.isEmpty()) {
            return "По одному номеру";
        } else  if (count == 1 && tmp.size() > 1) {
            return "Все равны";
        } else return answer;
    }

    private Map<String, List<String>> getMap(final String input) {
        Map<String, List<String>> map = new HashMap<>();

        if (input == null) {
            throw new IllegalStateException("null");
        } else if (input.isEmpty()) {
            throw new IllegalStateException("Пустая стока");
        }

        List<String> phone = List.of(input.split(";"));

        for (String item : phone) {
            String[] str = item.split(",");
            if (str.length == 3 && (str[0].chars().allMatch(Character::isLetter))
                    && (str[1].chars().allMatch(Character::isLetter)) && (str[2].chars().allMatch(Character::isDigit))) {
                String key = str[0] + " " + str[1];
                if (map.containsKey(key)) {
                    List<String> temp = map.get(key);
                    if (!temp.contains(str[2])) {
                        temp.add(str[2]);
                        map.put(key, temp);
                    }
                } else {
                    map.put(key, new ArrayList<>(List.of(str[2])));
                }
            } else {
                throw new IllegalStateException("Некорректный формат данных");
            }
        }
        return map;
    }

    private Map<String, Integer> getMapOfCounts(final Map<String, List<String>> phone) {
        Map<String, Integer> result;
        Map<String, Integer> count = new HashMap<>();
        phone.forEach((key, value) -> count.put(key, value.size()));

        result = count.entrySet().stream().filter((entry) -> entry.getValue() > 1)
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return result;
    }

}
