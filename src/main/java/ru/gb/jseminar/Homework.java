package ru.gb.jseminar;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;



public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
// Пусть дан список сотрудников в формате строки
// "Ева,Дарахвелидзе,89010348765;Ева,Дарахвелидзе,89010344345;Андрей,Иванов,89050377654;Дмитрий,Пономаренко,89344322343;"
// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности.
    public static void main(final String[] args) {
        Homework hw = new Homework();
        String list = "Ева,Дарахвелидзе,89010348765;Ева,Дарахвелидзе,89010344345;Андрей,Иванов,89050377654;" +
                "Дмитрий,Пономаренко,89344322343;Андрей,Иванов,89050377623;Андрей,Иванов,89050377123";
        System.out.println(hw.getPhones(list));
    }

    public String getPhones(String list) {
        List<String> splitText = List.of(list.split(";"));
        Map<String,List<String>> mapEmploee = new TreeMap<>();
        Map<Integer,String> mapSort = new HashMap<>();

        for (String item:splitText ){
                splitText = List.of(item.split(","));
                if (splitText.size()==3){
                    String key = splitText.get(0) + " " + splitText.get(1);
                    String value = splitText.get(2);
                    if (!mapEmploee.containsKey(key)) {
                        List<String> temp = new ArrayList<>();
                        temp.add(value);
                        mapEmploee.put(key, temp);
                    } else {
                        mapEmploee.get(key).addAll(Arrays.asList(value));
                        }
                } else throw new IllegalStateException("Please enter valid data");
        }

        for (String item : mapEmploee.keySet()){
            if (mapEmploee.get(item).size() > 1){
                mapSort.put(mapEmploee.get(item).size(),item);
            }
        }

        Map<Integer,String> reslt;
        reslt = mapSort.entrySet().stream()
                .sorted(Map.Entry.<Integer,String>comparingByKey().reversed())
                .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (oldValue, newValue) -> oldValue, LinkedHashMap::new
        ));

        return reslt.toString();

    }


}
