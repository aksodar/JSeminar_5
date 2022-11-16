package ru.gb.jseminar;

import java.util.*;

public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    // Пусть дан список сотрудников:Иван Иванов (и остальные, полный текст дз будет на платформе)
    // Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
    // Отсортировать по убыванию популярности.
    public static void main(final String[] args) {
        Homework hw = new Homework();
        String inputData = "Ева,Дарахвелидзе,89010348765;Ева,Дарахвелидзе,89010344345;Андрей,Иванов,89050377654;Дмитрий,Пономаренко,89344322343;";
        System.out.println(inputData);
        Map<String, ArrayList<String>> telephoneBookFilled = hw.telephoneBookFill(inputData);
        System.out.println(telephoneBookFilled);
        System.out.println(hw.namesRepeatedCount(telephoneBookFilled, 2));
        Map<String, Integer> namesRepeated = hw.namesRepeatedCount(telephoneBookFilled, 1);
        Map<Integer, ArrayList<String>> namesRepeatedAscending = hw.countNamesRepeatedAscending(namesRepeated);
        Map<Integer, ArrayList<String>> namesRepeatedDescending = hw.countNamesRepeatedDescending(namesRepeatedAscending);
        System.out.println(namesRepeatedDescending);
    }

    public Map<String, ArrayList<String>> telephoneBookFill(String inputData) {
        ArrayList<String> inputDataArray = new ArrayList<>(Arrays.asList(inputData.split(";")));
        Map<String, ArrayList<String>> telephoneBookFilled = new HashMap<>();
        for (String item : inputDataArray) {
            ArrayList<String> onePhoneArray = new ArrayList<>(Arrays.asList(item.split(",")));
            for (int i = 0; i < 2; i++) {
                if (!telephoneBookFilled.containsKey(onePhoneArray.get(i))) {
                    ArrayList<String> temp = new ArrayList<>(List.of(onePhoneArray.get(2)));
                    telephoneBookFilled.put(onePhoneArray.get(i), temp);
                } else {
                    ArrayList<String> temp = telephoneBookFilled.get(onePhoneArray.get(i));
                    temp.add(onePhoneArray.get(2));
                    telephoneBookFilled.put(onePhoneArray.get(i), temp);
                }
            }
        }
        return telephoneBookFilled;
    }

    public Map<String, Integer> namesRepeatedCount(Map<String, ArrayList<String>> phoneBook, Integer repetitions) {
        Map<String, Integer> namesRepeated = new HashMap<>();
        for (String item : phoneBook.keySet()) {
            Integer count = phoneBook.get(item).size();
            if (count > repetitions - 1) {
                namesRepeated.put(item, count);
            }
        }
        return namesRepeated;
    }

    public Map<Integer, ArrayList<String>> countNamesRepeatedAscending(Map<String, Integer> namesRepeated) {
        Map<Integer, ArrayList<String>> countAndNamesRepeated = new TreeMap<>();
        for (String item : namesRepeated.keySet()) {
            Integer tempKey = namesRepeated.get(item);
            if (!countAndNamesRepeated.containsKey(tempKey)) {
                ArrayList<String> temp = new ArrayList<>(List.of(item));
                countAndNamesRepeated.put(tempKey, temp);
            } else {
                ArrayList<String> temp = countAndNamesRepeated.get(tempKey);
                temp.add(item);
                countAndNamesRepeated.put(tempKey, temp);
            }
        }
        return countAndNamesRepeated;
    }

    public Map<Integer, ArrayList<String>> countNamesRepeatedDescending(Map<Integer, ArrayList<String>> namesRepeatedAscending) {
        Map<Integer, ArrayList<String>> namesRepeatedDescending = new LinkedHashMap<>();
        for (int i = namesRepeatedAscending.size(); i > 0; i--) {
            namesRepeatedDescending.put(i, namesRepeatedAscending.get(i));
        }
        return namesRepeatedDescending;
    }
}
