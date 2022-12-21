package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    // Пусть дан список сотрудников:Иван Иванов (и остальные, полный текст дз будет на платформе)
    // Вывести список пользователей отсортированный по количествоу телефонов.
    public static void main(final String[] args) {
        Homework hw = new Homework();
        Map<String, List<String>> phonebook = new HashMap<>(); 
        phonebook = hw.addPhone("Иванов", "88005553535", phonebook);
        phonebook = hw.addPhone("Иванов", "88005653535", phonebook);
        phonebook = hw.addPhone("Иванов", "88005753535", phonebook);
        phonebook = hw.addPhone("Петров", "777-555", phonebook);
        phonebook = hw.addPhone("Петров", "555-777", phonebook);
        phonebook = hw.addPhone("Андреев", "112233", phonebook);
        phonebook = hw.addPhone("Андреев", "332211", phonebook);
        phonebook = hw.addPhone("Саня", "11211", phonebook);
        phonebook = hw.addPhone("Толик", "22112", phonebook);        
        System.out.println(phonebook);
        System.out.println(hw.sortPhonebook(phonebook));
    }
    
    
    public Map<String, List<String>> addPhone(String name, String phone, Map<String, List<String>> phonebook){
        if (phonebook.containsKey(name)){
            List<String> temp = phonebook.get(name);
            temp.add(phone);
            phonebook.put(name, temp);  
        }
        else{
            List<String> temp = new ArrayList<>();
            temp.add(phone);
            phonebook.put(name, temp);
        }
        return phonebook;
    }; 

    public Map<Integer, Map<String, List<String>>> sortPhonebook(Map<String, List<String>> phonebook){
        Map<Integer, Map<String, List<String>>> sortedPhones = new HashMap<>();
        for (String name : phonebook.keySet()) {
            if (!sortedPhones.containsKey(phonebook.get(name).size())){
                Map<String, List<String>> temp = new HashMap<>();
                temp.put(name, phonebook.get(name));
                sortedPhones.put(phonebook.get(name).size(), temp);
            }
            else{
                Map<String, List<String>> temp = sortedPhones.get(phonebook.get(name).size());
                temp.put(name, phonebook.get(name));
                sortedPhones.put(phonebook.get(name).size(), temp);  
            }
        }    
        return sortedPhones;
    }

}
