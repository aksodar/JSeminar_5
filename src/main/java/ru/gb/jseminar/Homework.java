package ru.gb.jseminar;

import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;

public class Homework{

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.

    // Написать программу, которая выведет список людей с их телефонами.
    // Отсортировать по количеству телефонов.
    public static void main(final String[] args) {
        Map<String, List <String>> telBook = new HashMap<>();
        telBook.put("Капустин Алексей Петрович", Arrays.asList("8 777 777 7777"));
        telBook.put("Рыжий Петр Васильевич", Arrays.asList("8 999 999 9999", "8 888 888 8888", "8 666 666 6666"));
        telBook.put("Кошкин Александр Сергеевич", Arrays.asList("8 555 555 5555","8 444 444 4444"));
        telBook.put("Валиев Вагид Юнусович", Arrays.asList("8 222 222 2222", "8 111 111 1111"));

        var task = new Homework();

        System.out.println(task.getSortedTelBookByNumberOfTelephones(telBook));
    }

    public class TelephoneNumberComparator implements Comparator<String> {
        Map<String, List<String>> base;

        public TelephoneNumberComparator(Map<String, List<String>> base) {
            this.base = base;
        }

        public int compare(String key_a, String key_b) {
            var val_a = base.get(key_a).size();
            var val_b = base.get(key_b).size();
            if (val_a >= val_b) {
                return -1;
            } else if  (val_a == val_b){
                return 0;
            } else {
                return 1;
            }
        }
    }

    public Map<String, List <String>> getSortedTelBookByNumberOfTelephones(final Map<String, List <String>> telBook){
        var cmp = new TelephoneNumberComparator(telBook);
        var sorted_map = new TreeMap<String, List <String>>(cmp);
        sorted_map.putAll(telBook);

        return sorted_map;
    }
}

