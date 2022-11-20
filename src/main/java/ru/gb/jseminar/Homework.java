package ru.gb.jseminar;

import java.sql.SQLOutput;
import java.util.*;

public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    // Пусть дан список сотрудников:Иван Иванов (и остальные, полный текст дз будет на платформе)
    // Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
    // Отсортировать по убыванию популярности.
    public static void main(final String[] args) {
        Homework h = new Homework();
        String inputString = "Ева,Дарахвелидзе,89010348765;Ева,Дарахвелидзе,89010344345;Андрей,Иванов,89050377654;Дмитрий,Пономаренко,89344322343";
        System.out.println(h.getSortedIncludesWords(inputString));
    }
    public String getSortedIncludesWords(final String inputString){
        List<String> inputStringListFirst = Arrays.asList(inputString.toLowerCase().split(";"));
        List<String> inputStringListSecond = Arrays.asList(inputStringListFirst.toString().split(","));
        List<String> listNames = new ArrayList<>();
        List<String> listNames2 = new ArrayList<>();
        List<String> listNumbers = new ArrayList<>();
        String temp = "";
        for (int i = 0; i < inputStringListSecond.size();i = i + 3){
            temp = inputStringListSecond.get(i) + " " + inputStringListSecond.get(i+1);
            listNames.add(temp);
            listNumbers.add(inputStringListSecond.get(i+2));
        }
        for (String item:listNames){
            String temp3 = item.replaceAll("[^а-яА-Я]","");
            listNames2.add(temp3);
        }
        Map<String, List<String>> ResultMap = new TreeMap<>();
        for (int i = 0; i < listNames2.size(); i++){
            if (ResultMap.containsKey(listNames2.get(i))){
                List<String> temp2 = new ArrayList<>();
                temp2.add((ResultMap.get(listNames2.get(i))).toString());
                temp2.add(listNumbers.get(i));
                ResultMap.put(listNames2.get(i),temp2);
            } else {
                List<String> temp2 = Arrays.asList(listNumbers.get(i));
                ResultMap.put(listNames2.get(i),temp2);
            }
        }
        for (var item : ResultMap.entrySet()){
            System.out.print(item.getValue().size());
            System.out.println(item.getKey());
    }
        return ResultMap.toString();
    }
}