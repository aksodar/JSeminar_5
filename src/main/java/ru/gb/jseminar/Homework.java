package ru.gb.jseminar;


import java.util.*;

public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.

    // Написать программу, которая выведет список людей с их телефонами.
    // Отсортировать по количеству телефонов.

    HashMap<String, ArrayList<String>> phoneMap = new HashMap<>();


    public static void main(final String[] args) {

        Homework homework = new Homework();


        homework.kont("Пушкин", "+7(340)234-28-31");
        homework.kont("Сидоров", "+7(367)245-46-19");
        homework.kont("Петров", "+7(567)649-45-29");
        homework.kont("Петров", "+7(384)389-57-34");
        homework.kont("Иванов", "+7(957)354-35-73");
        homework.kont("Иванов", "+7(983)243-46-94");
        homework.kont("Иванов", "+7(687)284-56-91");

        System.out.println(homework.phoneMap.keySet());



        System.out.print("Введите имя контакта: ");
        String name = new Scanner(System.in).nextLine();;
        int num = 0;
        for (String x : homework.phoneMap.get(name)) {
            num++;
            System.out.println(name +" "+ num + " телефон: " + x);
        }
    }

    public void kont(String surname, String phone) {

        ArrayList<String> strings = phoneMap.get(surname);

        if (strings == null) {
            ArrayList<String> listOfPhones = new ArrayList<>();
            listOfPhones.add(phone);
            phoneMap.put(surname, listOfPhones);
        } else {
            strings.add(phone);
            phoneMap.put(surname, strings);
        }
    }
}

