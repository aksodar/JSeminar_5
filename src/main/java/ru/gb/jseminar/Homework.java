package ru.gb.jseminar;

import java.util.*;
import java.util.logging.Logger;

public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    // Пусть дан список сотрудников:Иван Иванов (и остальные, полный текст дз будет на платформе)
    // "Ева,Дарахвелидзе,89010348765;Ева,Дарахвелидзе,89010344345;Андрей,Иванов,89050377654;Дмитрий,Пономаренко,89344322343;"
    // Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
    // Отсортировать по убыванию популярности.
    public static void main(final String[] args) {
        String str = "Ева,Дарахвелидзе,89010348765;Ева,Дарахвелидзе,89010344345;Андрей,Иванов,89050377654;Дмитрий,Пономаренко,89344322343;Ева,Дарахвелидзе,89010340045;";
        Homework hw = new Homework();
        Logger lg = Logger.getLogger(Homework.class.getName());
        lg.info(String.valueOf(hw.getDuplicateNames(str)));
    }


    public Map<String,Integer> getDuplicateNames(final String phonebook) {
        Map<String,Integer> map = new HashMap<>();
        for (String item: phonebook.split(";")) {
            List<String> list = Arrays.asList(item.split(","));
            String person = list.get(0) + " " + list.get(1);
            //System.out.println(list);
            if (!map.containsKey(person)){
                map.put(person,1);
            }else{
                map.put(person, map.get(person)+1);
            }
        }
        return map;
    }


}
