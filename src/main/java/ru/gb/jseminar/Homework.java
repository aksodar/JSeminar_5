package ru.gb.jseminar;

import java.util.*;

public class Homework {
// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
// Пусть дан список сотрудников в формате строки
// "Ева,Дарахвелидзе,89010348765;Ева,Дарахвелидзе,89010344345;
// Андрей,Иванов,89050377654;Дмитрий,Пономаренко,89344322343;"
// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности.
    public static void main(final String[] args) {
        String str = "Ева,Дарахвелидзе,89010348765;Ева,Дарахвелидзе,89010344345;Андрей,Иванов,89050377654;Дмитрий,Пономаренко,89344322343;";
        Homework homework = new Homework();
        System.out.println(homework.count(str));
    }
    public  HashMap<String, Integer> count(String str){
        HashMap<String,Integer>map = new HashMap<>();
        List<String>list = Arrays.asList(str.split(";"));
        for (String item:list) {
            Deque<String> spl = new ArrayDeque<>(Arrays.asList(item.split(",")));
            spl.pollLast();
            String n =spl.toString().replace("[", "").replace("]", "");
            Integer count=1;
            if(map.containsKey(n)){
                count=map.get(n)+1;
                map.put(n,count);
            }else {
                map.put(n,count);
            }
        }
        return map;
    }
}
