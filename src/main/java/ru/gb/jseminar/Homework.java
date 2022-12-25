package ru.gb.jseminar;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    // Пусть дан список сотрудников:Иван Иванов (и остальные, полный текст дз будет на платформе)
    // Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
    // Отсортировать по убыванию популярности.
    public static void main(String[] args) {
        Homework homework = new Homework();

        String txt = "Александр,Пушкин,89000000000;Антон,Чехов,89020000000;Александр,Пушкин,89010000000;" +
                "Антон,Чехов,89030000000;Михаил,Лермонтов,89031111111;Лев,Толстой,89022222222;" +
                "Михаил,Лермонтов,89033333333;Сергей,Есенин,89044444444;Сергей,Есенин,89055555555;";

        Map<Long, List<String>> contacts = homework.generateContacts(txt);

        Logger log = Logger.getLogger(Homework.class.getName());
        log.info("Телефонная книга: " + String.valueOf(contacts));
        log.info("У них несколько номеров: " + String.valueOf(homework.duplicateContact(contacts)));
    }

    public Map<Long, List<String>> generateContacts (String employees) {

        List<String> txtList = Arrays.asList(employees.split(";"));

        Map<Long, List<String>> client = new HashMap<>();

        for (String item : txtList) {

            List<String> tmp = Arrays.asList(item.split(","));

            if (tmp.size() == 3) {
                client.putIfAbsent(Long.parseLong(tmp.get(2)), Arrays.asList(tmp.get(0), tmp.get(1)));
            }
        }

        return client;
    }

    public Map<Integer, List<String>> duplicateContact (Map<Long, List<String>> phonebook) {

        Map<String, Integer> identicalClients = new HashMap<>();

        for (List<String> item : phonebook.values()) {
            identicalClients.put(String.join(" ", item), 1 + identicalClients.getOrDefault(String.join(" ", item),0));
        }
        Map<Integer, List<String>> res = new TreeMap<>(Collections.reverseOrder());

        for (String key : identicalClients.keySet()) {

            if (identicalClients.get(key) > 1) {

                if (res.containsKey(identicalClients.get(key))) {
                    List<String> tmp = res.get(identicalClients.get(key));
                    tmp.add(key);
                    res.put(identicalClients.get(key), tmp);
                }
                else {
                    List<String> tmp = new ArrayList<>(List.of(key));
                    res.put(identicalClients.get(key), tmp);
                }
            }
        }
        return res;
    }
}


