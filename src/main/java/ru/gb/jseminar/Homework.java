package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    // Написать программу, которая выведет список людей с их телефонами
    // Отсортировать по колличеству телефонов.

    public static void main(final String[] args) {

        List <String> users = new ArrayList<String>( Arrays.asList("Александров Н.В. +795000333 +7951666333 +7951777333", 
                                                                        "Нижников А.С. +7951111222 +7951222333", 
                                                                        "Кант И. +7951444555 +7951333444 +7951222888", 
                                                                        "Путин В.В. 911 112", 
                                                                        "Толстой Л.Н. +7951555666", 
                                                                        "Пушкин А.С. +795188858"));

        Homework hm = new Homework();
        System.out.println(hm.faindDoubleUser(users));
    }

    public Map<Integer, List<String>> faindDoubleUser(List<String> list){
        Map <Integer, List<String>> user_book = new HashMap<>();

        for(String user: list){
            String [] info_user = user.split(" ");
            Integer quantity_numb = info_user.length - 2;
            List<String> users = new ArrayList<>();

            if(!user_book.containsKey(quantity_numb)){
                users.add(user);
            }
            else{
                users = user_book.get(quantity_numb);
                users.add(user);
            }
            user_book.put(quantity_numb, users);
        }

        return user_book;
    }
}
