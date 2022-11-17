package ru.gb.jseminar;

import java.util.*;
import java.util.logging.Logger;

public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    // Пусть дан список сотрудников:Иван Иванов (и остальные, полный текст дз будет на платформе)
    // Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
    // Отсортировать по убыванию популярности.

    //"Ева,Дарахвелидзе,89010348765;Ева,Дарахвелидзе,89010344345;Андрей,Иванов,89050377654;Дмитрий,Пономаренко,89344322343;"
    public static void main(final String[] args) {
        String str = "Ева,Дарахвелидзе,89010348765;Андрей,Иванов,89050377654;Андрей,Иванов,89050377654;Ева,Дарахвелидзе,89010344345;Ева,Дарахвелидзе,89010348765;Дмитрий,Пономаренко,89344322343;";
        Homework hw = new Homework();
        Logger log = Logger.getLogger(Homework.class.getName());
        log.info(String.valueOf(hw.getSortedPopular(str)));
    }

    public List<String> getSortedPopular(final String str){
        List<String> strList = Arrays.asList(str.toLowerCase().split(";"));
        Map<String, Integer> strMap = new HashMap<>();
        for (int i = 0; i < strList.size(); i++) {
            List<String> rowList = Arrays.asList(strList.get(i).split(","));
            String nameSurname = rowList.get(0) + " " + rowList.get(1);
            if (strMap.containsKey(nameSurname)) {
                strMap.put(nameSurname, 1 + strMap.getOrDefault(nameSurname, 0));
            } else {
                strMap.put(nameSurname, 1);
            }
        }
        List <String> lst = new ArrayList<>();
        for (Map.Entry<String, Integer> entrX : strMap.entrySet()) {
             lst.add(0, (entrX.getValue()) + " " + (entrX.getKey()));
        }
        Collections.sort(lst, Comparator.reverseOrder());
        return lst;
    }
}
