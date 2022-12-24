package ru.gb.jseminar;

import java.util.*;

public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    // Написать программу, которая выведет список людей с их телефонами
    // Отсортировать по колличеству телефонов.
    public static void main(final String[] args) {
        String text = "Андреев Андрей 43-43-43;Сергеев Сергей 22-34-56;Иванов Иван 55-56-57;Андреев Андрей 88005553535;" +
                "Сергеев Сергей 890005555555;Андреев Андрей 89605675656;Петров Петр 89779877878";

        Homework hw = new Homework();

        System.out.println(hw.printPhonebook(text));
        System.out.println(hw.sortphonebok(hw.printPhonebook(text)));
    }
    public Map<String, List<String>> printPhonebook(String text) {
        Map<String, List<String>> phonebook = new HashMap<>();
        List<String> lst = Arrays.asList(text.split(";"));

        for (String item: lst) {
            List<String> temp = Arrays.asList(item.split(" "));
            String name = temp.get(0) + " " + temp.get(1);

            if(!phonebook.containsKey(name)) {
                List<String> phone = new ArrayList<>();
                phone.add(temp.get(2));
                phonebook.put(name, phone);
            } else {
                String phone = temp.get(2);
                phonebook.get(name).addAll(Arrays.asList(phone));
            }
        }
        return phonebook;
    }

    public Map<Integer, List<String>> sortphonebok(Map<String, List<String>> phonebook) {

        Map<Integer, List<String>> result = new TreeMap<>();

        for (String item: phonebook.keySet()) {
            if (phonebook.get(item).size() > 0) {
                int count = phonebook.get(item).size();
                if (!result.containsKey(count)) {
                    List<String> name = new ArrayList<>();
                    name.add(item);
                    result.put(count, name);
                } else {
                    String name = item;
                    result.get(count).addAll(Arrays.asList(name));
                }
            }
        }
        return result;
    }

}
