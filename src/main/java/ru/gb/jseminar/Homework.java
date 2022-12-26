package ru.gb.jseminar;
import java.util.*;
//public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.

    // Написать программу, которая выведет список людей с их телефонами
    // Отсортировать по колличеству телефонов.
//    public static void main(final String[] args) {


// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
// Написать программу, которая выведет список людей с их телефонами
// Отсортировать по количеству телефонов.

        public class Homework {
            public static void main(final String[] args) {
                Homework hw = new Homework();
                Map <String, List<String>> phoneBook = hw.makePhoneBook();
                hw.printMap("Name: ", "Tel.numbers: ", phoneBook);
                System.out.println("\n--------------------------------------------\n");
                hw.printMap("Count of numbers: ", "", hw.sortByPhoneNumbers(phoneBook));
            }

            public Map <String, List<String>> makePhoneBook() {

                Homework hw = new Homework();
                Map <String, List<String>> phoneBook = new HashMap<>();
                phoneBook = hw.addNumber("John Smith", "8-999-777-55-33", phoneBook);
                phoneBook = hw.addNumber("Anna Miller", "8-999-888-77-66", phoneBook);
                phoneBook = hw.addNumber("Ken Wonders", "8-999-787-45-33", phoneBook);
                phoneBook = hw.addNumber("John Mitchel", "8-999-774-75-13", phoneBook);
                phoneBook = hw.addNumber("John Smith", "8-999-555-55-55", phoneBook);
                phoneBook = hw.addNumber("Billy Marlboro", "8-989-677-51-93", phoneBook);
                phoneBook = hw.addNumber("Anna Miller", "8-999-457-89-33", phoneBook);
                phoneBook = hw.addNumber("John Smith", "8-959-757-44-21", phoneBook);
                phoneBook = hw.addNumber("Carol Johnson", "8-799-257-95-63", phoneBook);

                return phoneBook;
            }
            public Map <String, List <String>> addNumber(String name, String tel, Map <String, List <String>> phonebook){

                if (phonebook.containsKey(name)) {
                    List <String> oldContact = phonebook.get(name);
                    oldContact.add(tel);
                    phonebook.put(name, oldContact);
                }
                else {
                    List <String> newContact = new ArrayList<>();
                    newContact.add(tel);
                    phonebook.put(name, newContact);
                }
                return phonebook;
            }
            public Map <String, List <String>> sortByPhoneNumbers(Map <String, List <String>> phonebook){

                Map <String, List <String>> newPhonebook = new HashMap<>();
                for (Map.Entry<String, List <String>> contact : phonebook.entrySet()) {
                    String num = String.valueOf(contact.getValue().size());
                    List <String> data = Arrays.asList("Name: " + contact.getKey() + " Tel.numbers: " + contact.getValue());
                    if (!newPhonebook.containsKey(num)) {
                        newPhonebook.put(num, data);
                    }
                    else {
                        List <String> oldContact = new ArrayList<>();
                        oldContact.add(newPhonebook.get(num).toString());
                        String data1 = "\nName: " + contact.getKey() + " Tel.numbers: " + contact.getValue().toString();
                        oldContact.add(data1);
                        newPhonebook.put(num, oldContact);
                    }

                }

                return new TreeMap<>(newPhonebook);
            }

            public void printMap(String key, String value, Map <String, List <String>> phoneBook) {
                for (Map.Entry<String, List <String>> contact : phoneBook.entrySet()) {

                    System.out.println(key + contact.getKey());
                    System.out.println(value + contact.getValue() + "\n");

                }
            }
    }


