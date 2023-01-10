package ru.gb.jseminar;

import java.util.*;

public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек
    // может иметь несколько телефонов.
    // Написать программу, которая выведет список людей с их телефонами
// Отсортировать по колличеству телефонов.
    public static <sortphb> void main(final String[] args) {
        Homework phonebook = new Homework();
        HashMap<String, List<String>> phb = new HashMap<>();
        phb.put("Иванов Иван Феофанович", List.of("+79000102365"));
        phb.put("Фруктовая Анюта Конфетовна", List.of("+789080980900", "+76785868767"));
        phb.put("Теодоров Макс Ортодонтович", List.of("+79094567438"));
        phb.put("Сиропова Антонина Вассаловна", List.of("+79012002343"));
        phb.put("Феофанов Сидр Петрович", List.of("+79084678367"));
        phb.put("Прокрутин Антон Дронович", List.of("+74564654645", "+79031004567", "+79067584536"));
        //        System.out.println("phb" + phb);
        // сортировка по количеству телефонов:
        System.out.println("Сортировка по количеству номеров телефонов: " + phonebook.phonenumbcountsorted(phb));
//        // дополнительно - сортировка по ФИО:
        System.out.println("Сортировка по ФИО: " + phonebook.fiosorted(phb));
    }
    public Map<Integer, Map<String, List<String>>> phonenumbcountsorted(Map<String, List<String>> sortphb) {
        Map<Integer, Map<String, List<String>>> sortOfCountPhone = new HashMap<>();
        for (String item : sortphb.keySet()) {
            if (!sortOfCountPhone.containsKey(sortphb.get(item).size())) {
                Map<String, List<String>> data = new HashMap<>();
                data.put(item, sortphb.get(item));
                sortOfCountPhone.put(sortphb.get(item).size(), data);
            } else {
                Map<String, List<String>> data = sortOfCountPhone.get(sortphb.get(item).size());
                data.put(item, sortphb.get(item));
                sortOfCountPhone.put(sortphb.get(item).size(), data);
            }
        }
        return sortOfCountPhone;
    }

    public Map<String, List<String>> fiosorted(Map<String, List<String>> phb) {
// сортировка по ФИО:
        Map<String, List<String>> sortphb = new TreeMap<String, List<String>>(String.CASE_INSENSITIVE_ORDER);
        sortphb.putAll(phb);
        System.out.println(" ");

        //сортировка по ФИО (2):
        Map<String, List<String>> sortphb1 = new TreeMap<String, List<String>>(String.CASE_INSENSITIVE_ORDER);
        System.out.println("Сотрировка по ФИО: ");
        for (Map.Entry<String, List<String>> entry : sortphb.entrySet()) {
            sortphb1.put(entry.getKey(), entry.getValue());
            System.out.println("ФИО: " + entry.getKey() + "  Номер телефона: " + entry.getValue());
        }
        return sortphb1;
    }
}



