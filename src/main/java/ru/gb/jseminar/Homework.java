import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

package ru.gb.jseminar;

public class Homework {
    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1
    // человек может иметь несколько телефонов.
    // Написать программу, которая выведет список людей с их телефонами
    public static Map<String, List<String>> pb = new HashMap<>();

    public static void main(final String[] args) {
        mock();
        //delContact("Петров Петр Петрович");
        //delContactTel("Иванов Иван Иванович", "+79001002345");
        System.out.println("Список контактов:");
        getAllContact();
    }

    public static Boolean checkValue(String value) {
        return (value == null || value.length() == 0);
    }

    public static void addContact(String fullName, String contact) {
        if (checkValue(fullName) || checkValue(contact))
            return;

        List<String> tels = new ArrayList<>();

        if (pb.containsKey(fullName)) {
            tels.addAll(pb.get(fullName));

            if (!tels.contains(contact)) {
                tels.add(contact);
            }

            pb.put(fullName, tels);
        } else {
            pb.put(fullName, Arrays.asList(contact));
        }

    }

    public static Boolean delContact(String fullName) {
        if (checkValue(fullName))
            return false;

        return !(pb.remove(fullName) == null);
    }

    public static Boolean delContactTel(String fullName, String contact) {
        if (checkValue(fullName))
            return false;

        List<String> tels = new ArrayList<>();

        if (pb.containsKey(fullName)) {
            tels.addAll(pb.get(fullName));

            if (tels.contains(contact)) {
                if (tels.remove(contact)) {
                    return !(pb.put(fullName, tels) == null);
                }
            }
        }
        return false;
    }

    public static void getAllContact() {
        Map<String, List<String>> res = pb.entrySet().stream()
                .sorted(Collections.reverseOrder(Comparator.comparingInt(entry -> entry.getValue().size())))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (a, b) -> b, LinkedHashMap::new));

        for (Map.Entry<String, List<String>> contact : res.entrySet()) {
            System.out.printf("ФИО: %s  Контакты: %s \n", contact.getKey(), contact.getValue().toString());
        }
    }

    public static void mock() {
        String mock= 
        "Петров Петр Петрович,+79001022345;Петров Петр Петрович,+79001032345;" +
        "Иванов Иван Иванович,+79001012345;Иванов Иван Иванович,+79001112345;Иванов Иван Иванович,+79001002345;" +
        "Сидоров Сидр Сидорович,+79001032345;";

        List<String> contacts = Arrays.asList(mock.split(";"));
        
        for (String item : contacts) {
            if(checkValue(item))
                continue;

            String[] cnt= item.split(",");

            if(cnt.length>1)
                addContact(cnt[0],cnt[1]);
        }
    }
}