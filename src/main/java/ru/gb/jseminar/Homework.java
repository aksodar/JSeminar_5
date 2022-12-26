package ru.gb.jseminar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap,
    // учитывая, что 1 человек может иметь несколько телефонов.
    // Написать программу, которая выведет список людей с их телефонами
    // Отсортировать по колличеству телефонов.
    HashMap<String, ArrayList<String>> phoneMap = new HashMap<>();

    public static void main (String[] args) {

        Homework pb = new Homework();

        pb.add("Зайкин", "8(800)555-35-35");
        pb.add("Ветров", "8(495)415-82-82");
        pb.add("Крылов", "8(800)410-20-20");
        pb.add("Петров", "8(800)474-58-58");
        pb.add("Синьков", "8(496)274-16-79");
        pb.add("Петров", "8(925)316-65-82");
        pb.add("Иванов", "8(903)155-20-90");
        pb.add("Петров", "8(903)675-75-10");
        pb.add("Иванов", "8(495)613-43-04");
        pb.add("Пушкин", "8(800)555-33-55");
        pb.add("Иванов", "8(800)555-33-00");

        System.out.println(pb.phoneMap.keySet());
        Scanner iScanner;
        iScanner = new Scanner (System.in);
        System.out.printf("Введите фамилию для поиска: ");
        String name = iScanner.nextLine();
        int num = 0;
        for (String x : pb.get(name)) {
            num++;
            System.out.println(name +" "+ num + " телефон: " + x);
        }
    }

    public void add(String surname, String phone) {

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
    public ArrayList<String> get(String surname) {
        return phoneMap.get(surname);
    }
}