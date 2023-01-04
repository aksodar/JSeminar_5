package ru.gb.jseminar;

import java.util.*;

public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.

    // Написать программу, которая выведет список людей с их телефонами
    // Отсортировать по колличеству телефонов.

    public static void main(final String[] args) {
        System.out.println("Hello it's phone book");
        Homework hw = new Homework();
        hw.showAllContact();




    }


    public Integer menu(){
        System.out.println("This is menu:  \nselect a menu item \n1. Create contact \n2. Show all contact");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("You input " + n);
        return n;
    }

    public void checkMenu (int a){
        if (a == 2)
            showAllContact();
        else return;
    }

    public void showAllContact (){
        HashMap <String , ArrayList <String>> phoneBook = new HashMap<>();
        phoneBook.put("Ivanov Ivan Ivanovi4", new ArrayList<>(Arrays.asList("+79219876589", "+79213219575")));
        phoneBook.put("Petrov Petr Petrovi4", new ArrayList<>(List.of("+79876541232")));
        phoneBook.put("Sidoroff Ilya Sidorovi4", new ArrayList<>(Arrays.asList("+79632145698", "+79513576549", "+79879513256")));
        TreeMap<Integer, String> sortedPhoneBook = new TreeMap<>();
        for (String i : phoneBook.keySet()){
            sortedPhoneBook.put(phoneBook.get(i).size(), i);

        }
        for (String i : sortedPhoneBook.values()){
            System.out.println(i + " " + String.join(" ", phoneBook.get(i)));
        }
    }
}
