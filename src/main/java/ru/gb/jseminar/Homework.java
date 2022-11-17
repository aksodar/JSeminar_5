package ru.gb.jseminar;

import java.util.*;

public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    // Пусть дан список сотрудников в формате строки
    // "Ева,Дарахвелидзе,89010348765;Ева,Дарахвелидзе,89010344345;Андрей,Иванов,89050377654;Дмитрий,Пономаренко,89344322343;"
    // Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
    // Отсортировать по убыванию популярности.

    public static void main(final String[] args) {
        Homework hw = new Homework();
        String text = "Андрей,Иванов,89050377654;" +
                "Дмитрий,Пономаренко,89344322343;Дмитрий,Пономаренко,89344322234;Дмитрий,Пономаренко,89343462343;" +
                "Ева,Дарахвелидзе,89010398365;Ева,Дарахвелидзе,89010334785;Андрей,Иванов,89050355554;" +
                "Галина,Васильева,89053457654;";
        System.out.println(hw.searchForDuplicateNames(text));
    }

    public Map<Integer, List<String>> searchForDuplicateNames(final String inputText) {

        Map<String, List<String>> subResultMap = new HashMap<>();

        for (String item : inputText.split(";")) {

            List<String> inputTextList = Arrays.asList(item.split(","));
            String key = inputTextList.get(0).toLowerCase() + " " + inputTextList.get(1).toLowerCase();

            if (!subResultMap.containsKey(key)) {

                List<String> values = new ArrayList<>();

                values.add(inputTextList.get(2));
                subResultMap.put(key, values);

            }
            else {

                String values = inputTextList.get(2);
                subResultMap.get(key).addAll(Arrays.asList(values));

            }
        }

        Map<Integer, List<String>> listTelephonNumber = new TreeMap<>(Collections.reverseOrder());

        for (String item : subResultMap.keySet()) {
            if (subResultMap.get(item).size() > 1) {

                Integer key = subResultMap.get(item).size();

                if (!listTelephonNumber.containsKey(key)){

                    List<String> valuesList = new ArrayList<>();

                    valuesList.add(item);
                    listTelephonNumber.put(key, valuesList);
                }
                else {

                    String values = item;
                    listTelephonNumber.get(key).addAll(Arrays.asList(values));

                }
            }

        }

        return  listTelephonNumber;
    }
}