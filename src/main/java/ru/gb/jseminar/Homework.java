package ru.gb.jseminar;


import java.util.*;

// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
// Написать программу, которая выведет список людей с их телефонами
// Отсортировать по количеству телефонов.

public class Homework {
    public static void main(final String[] args) {
        Homework task = new Homework();
        Map <String, List<String>> phonebook = task.bookGenerator();
        task.menuFirst(phonebook);
    }

    public Map <String, List <String>> addPhoneNumber(String contactFio, String contactPhone, Map <String, List <String>> phonebook){
        if (phonebook.containsKey(contactFio)){
            List<String> update = phonebook.get(contactFio);
            update.add(contactPhone);
            phonebook.put(contactFio, update);
        }
        else{
            List<String> newNote = new ArrayList<>();
            newNote.add(contactPhone);
            phonebook.put(contactFio, newNote);
        }
        return phonebook;
    }
    public Map <String, List<String>> bookGenerator() {
        Homework pb = new Homework();
        Map <String, List<String>> entry = new HashMap<>();
        entry = pb.addPhoneNumber("Иванов Иван Иванович", "123", entry);
        entry = pb.addPhoneNumber("Иванов Иван Иванович", "321", entry);
        entry = pb.addPhoneNumber("Сидоров Сидор Сидорович", "111", entry);
        return entry;
    }

    public Map <Integer, Map <String, List <String>>> sortByPhoneCount(Map <String, List <String>> phonebook){
        Map <Integer, Map <String, List <String>>> sortByCount = new HashMap <>();
        for (String contactFio : phonebook.keySet()) {
            if (!sortByCount.containsKey(phonebook.get(contactFio).size())){
                Map <String, List <String>> data = new HashMap <>();
                data.put(contactFio, phonebook.get(contactFio));
                sortByCount.put(phonebook.get(contactFio).size(), data);
            }
            else{
                Map <String, List <String>> data = sortByCount.get(phonebook.get(contactFio).size());
                data.put(contactFio, phonebook.get(contactFio));
                sortByCount.put(phonebook.get(contactFio).size(), data);
            }
        }
        return sortByCount;
    }
    public Map<String, List<String>> menuFirst(final Map<String, List<String>> phonebook) {

        Scanner scan = new Scanner(System.in);
        int x = -1;
        String s = "";

        while (!"4".equals(s)) {
            System.out.println("=".repeat(100));
            System.out.println("ВЫБЕРИТЕ ПУНКТ ИЗ МЕНЮ\n");
            System.out.println("1" + " - " + "Отобразить полный список контактов");
            System.out.println("2" + " - " + "Отобразить отсортированный список контактов");
            System.out.println("0" + " - " + "ВЫХОД");
            System.out.print("\nВведите значение: ");
            s = scan.next();

            try {
                x = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Не правильный ввод!");
            }

            switch (x) {
                case 1:
                    showPhonebook(phonebook);
                    break;
                case 2:
                    showSortedPhonebook(phonebook);
                    break;
                case 0:
                    System.out.println("Вы успешно вышли из программы!");
                    System.exit(0);
            }
        }
        return null;
    }
    public Map<String, List<String>> menuFooter(final Map<String, List<String>> phonebook){
        Scanner scan = new Scanner(System.in);
        int x = -1;
        String s = "";

        while (!"4".equals(s)) {
            System.out.println(".".repeat(100));
            System.out.println("ВЫБЕРИТЕ ПУНКТ ИЗ МЕНЮ\n");
            System.out.println("9" + " - " + "Вернуться в меню");
            System.out.println("0" + " - " + "ВЫХОД");
            System.out.print("\nВведите значение: ");
            s = scan.next();

            try {
                x = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Не правильный ввод!");
            }

            switch (x) {
                case 9:
                    menuFirst(phonebook);
                    break;
                case 0:
                    System.out.println("Вы успешно вышли из программы!");
                    System.exit(0);
            }
        }
        return null;
    }

    public Map <Integer, Map <String, List <String>>> showPhonebook(Map <String, List <String>> phonebook) {
        Homework pb = new Homework();
        Map <String, List<String>> phonebookFull = pb.bookGenerator();
        System.out.println("Фамилия Имя Отчество" + " | " + "Номер(а) телефонов");
        for (Object obj : phonebookFull.entrySet()) {
            Map.Entry<String, List <String>> entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
        pb.menuFooter(phonebook);
        return null;
    }
    public Map <Integer, Map <String, List <String>>> showSortedPhonebook(Map <String, List <String>> phonebook) {

        Homework pb = new Homework();
        Map <String, List<String>> phonebookFull = pb.bookGenerator();
        Map <Integer, Map <String, List <String>>> sorted = pb.sortByPhoneCount(phonebookFull);
        System.out.println("Количество" + " | " + "ФИО и номер(а) телефонов");
        System.out.println("-----------+-----------------------------------------");
        for (Object obj : sorted.entrySet()) {
            Map.Entry entry = (Map.Entry) obj;
            System.out.println("     " + entry.getKey() + "    " + " | " + entry.getValue());
        }
        pb.menuFooter(phonebook);
        return null;
    }


}