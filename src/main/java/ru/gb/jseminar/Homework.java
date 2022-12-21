package ru.gb.jseminar;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    // Пусть дан список сотрудников:Иван Иванов (и остальные, полный текст дз будет на платформе)
    // Написать программу, которая выведет список людей с их телефонами.
    // Отсортировать по количеству телефонов.
    public static void main(final String[] args) {
        HashMap<String, String> telephoneDirectory = new HashMap<>();

        telephoneDirectory.put("88007006841", "Contact1");
        telephoneDirectory.put("84999224710", "Contact2");
        telephoneDirectory.put("84955395555", "Contact3");
        telephoneDirectory.put("84957777777", "Contact4");
        telephoneDirectory.put("84956202717", "Contact1");
        telephoneDirectory.put("88005555550", "Contact3");

        printTD1(telephoneDirectory);
        System.out.println();
        System.out.println();
        Scanner Scanner = new Scanner(System.in);
        System.out.print("Enter name of contact : ");
        String a = Scanner.next();
        Scanner.close();
        System.out.println();
        printTD2(telephoneDirectory, a);
    }
    // функция печати всего телефонного справочника
    public static void printTD1(@NotNull HashMap<String, String> book) {
        for (Map.Entry<String, String> entry : book.entrySet()) {
            System.out.printf("Contact: %s, phone number: %s\n", entry.getValue(), entry.getKey());
        }
    }

    // функция печати по контакту
    public static void printTD2(HashMap<String, String> book, String name) {

        for (Map.Entry<String, String> entry : book.entrySet()) {

            if (entry.getValue().equals(name)) {
                System.out.printf("Contact: %s, phone number: %s\n", entry.getValue(), entry.getKey());
            }
        }
    }

    }
