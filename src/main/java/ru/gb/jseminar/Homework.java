package ru.gb.jseminar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    // Пусть дан список сотрудников:Иван Иванов (и остальные, полный текст дз будет на платформе)
    // Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
    // Отсортировать по убыванию популярности.
    public static void main(final String[] args) {
        String people = "Ева,Дарахвелидзе,89010348765;Ева,Дарахвелидзе,89010344345;Андрей,Иванов,89050377654;Ева,Дарахвелидзе,89010389765;Дмитрий,Пономаренко,89344322343;Андрей,Иванов,89051377654;Иван,Иванов,89039039933;";
        String [] spisok = people.split(";");
        String[] person = {};
        List<Integer> list = new ArrayList<>();
        Map<String,String> map = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();

        for (int i = 0; i < spisok.length; i++) {
          person = spisok[i].split(",");
          map.put(person[2], person[0] + person[1]);
        } 
        List<String> values = new ArrayList<String>();
        for (var item : map.entrySet()) {
            values.add(item.getValue());
        } 
        for (int i = 0; i < values.size()-1; i++) {
            int number = 1;
            for (int j = i+1; j < values.size(); j++) {
                if (values.get(i) != null) {
                    if (values.get(i).equals(values.get(j))) {
                        number = number + 1;
                        values.set(j, null);
                    }
                }
            }
            map2.put(values.get(i), number);
        }
        map2.remove(null);
        for (var item : map2.entrySet()) {
           list.add(item.getValue());
        }
        Collections.sort(list, Comparator.reverseOrder());
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 1) {
                list.remove(i);
            }  
        }
        for (int i = 0; i < list.size(); i++) {
            for (var item : map2.entrySet()) {
                if (list.get(i).equals(item.getValue())) {
                    System.out.printf("[%d - %s]\n", list.get(i), item.getKey());
                }
            }
        }
        }
    }


