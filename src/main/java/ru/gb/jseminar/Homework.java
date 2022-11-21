package ru.gb.jseminar;

import java.util.*;

public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    // Пусть дан список сотрудников:Иван Иванов (и остальные, полный текст дз будет на платформе)
    // Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
    // Отсортировать по убыванию популярности.
    public static void main(final String[] args) {
        Homework homework = new Homework();
        String name_tel = "Анна,Дарахвелидзе,89010348765;" +
                          "Ева,Дарахвелидзе,89010344345;" +
                          "Андрей,Иванов,89050377654;" +
                          "Дмитрий,Пономаренко,89344322343";
        System.out.println(homework.add_to_dictionary(name_tel));

    }
    public Map<String, List> add_to_dictionary(String text){
        Map<String, List> telefone_dictionary = new HashMap<>();
        for (String item: text.split(";")) {
            List<String> all_telefone_number = new ArrayList<>();
            String[] tamp = item.split(",");
            String key_name = "";
            if(tamp.length >= 4){
                key_name = tamp[0] + " " + tamp[1];
                for(int i = 2; i < tamp.length; i ++){
                    all_telefone_number.add(tamp[i]);
                }
            } else if (tamp.length == 3){
                key_name = tamp[0] + " " + tamp[1];
                all_telefone_number.add(tamp[2]);
            }
            if(telefone_dictionary.containsKey(key_name)){
                List<String> add_telefon = telefone_dictionary.get(key_name);
                add_telefon.add(all_telefone_number.toString());
                telefone_dictionary.put(key_name,add_telefon);
            } else {
                telefone_dictionary.put(key_name, all_telefone_number);
            }
        }
        return telefone_dictionary;
    }
}