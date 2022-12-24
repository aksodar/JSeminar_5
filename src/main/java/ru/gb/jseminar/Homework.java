package ru.gb.jseminar;

import java.util.*;

public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    // Написать программу, которая выведет список людей с их телефонами
    // Отсортировать по колличеству телефонов.
    public static void main(final String[] args) {
        //////////////////////////////////////////////////////////////////////////////////////////////////////
        Map<String, List<String>> dano = new HashMap<>();
        List<String> phones = Arrays.asList("+722222221 +7222222222".split(" "));
        dano.put("Иванов Иван Иванович", phones);
        phones = Arrays.asList("+722222221 +7222222222".split(" "));
        dano.put("Егоров Егор Егорович", phones);
        phones = Arrays.asList("+74444444441 +74444444442 +74444444443 +74444444444".split(" "));
        dano.put("Анастасиева Анастасия Анастасиевна", phones);
        phones = Arrays.asList("+71111111111".split(" "));
        dano.put("Сидоров Сидор Сидорович", phones);
        phones = Arrays.asList("+71111111111".split(" "));
        dano.put("Михаилов Михаил Михаилович", phones);
        //////////////////////////////////////////////////////////////////////////////////////////////////////
        Homework task = new Homework();
        task.WatchPhoneList(dano);
        task.WatchPhoneList(task.SortedOnCountPhones(dano));
    }

    public void WatchPhoneList(Map<String, List<String>> dano) {
        System.out.println(dano);
    }

    public Map<String, List<String>> SortedOnCountPhones(Map<String, List<String>> dano) {
        Map<Integer, List<String>> countsPhones = new TreeMap<>();
        for (List<String> i : dano.values()) {
            for (String j : i) {
                if (countsPhones.containsKey(i.size())) {
                    List<String> temp = countsPhones.get(i.size());
                    temp.add(j);
                    countsPhones.put(i.size(), temp);
                    break;
                } else {
                    List<String> temp = new ArrayList<>();
                    temp.add(j);
                    countsPhones.put(i.size(), temp);
                    break;
                }
            }
        }

        Map<String, List<String>> result = new LinkedHashMap<>();
        for (List<String> i : countsPhones.values()) {
            for (String j : i) {
                for (Map.Entry<String, List<String>> pair : dano.entrySet()) {
                    if (pair.getValue().contains(j)) {
                        result.put(pair.getKey(), dano.get(pair.getKey()));
                    }
                }
            }
        }
        return result;
    }

}
