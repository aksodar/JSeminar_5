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

        Homework task = new Homework();
        String text = "Иван, Иванов, 89111234556; Сидор, Сидоров, 89117894545; Петр, Петров, 89112364545; Сидор, Сидоров, 89117894548; Сидор, Сидоров, 89117894525; Петр, Петров, 89112364546;";
       
        text = text.replace(" ",""); 
        System.out.println(task.PopularUser(text));

    }

    public String PopularUser(final String text){
        List <String> inputDict = Arrays.asList(text.split(";"));

        Map <String, List<String>> resBook = new HashMap<>();
        for (String item: inputDict){

            List<String> temp = Arrays.asList(item.split(","));
            if (resBook.containsKey(temp.get(0)+" "+temp.get(1))){

                List<String> tempName = resBook.get(temp.get(0)+" "+temp.get(1));
                tempName.add(temp.get(2));                
                resBook.put(temp.get(0)+" "+temp.get(1), tempName);

            }
            else {    

                List<String> tempName = new ArrayList<>(List.of(temp.get(2)));
                resBook.put(temp.get(0)+" "+temp.get(1), tempName); 
            
            }
            
        }

        System.out.println("Телефонная кника: \n" + resBook);  
                
        Map <String, Integer> listName = new HashMap<>();
        for (String item : resBook.keySet()) { 
            
            listName.put(item, resBook.get(item).size());  

        }
    //    System.out.println(resBook.keySet());
    
        System.out.println("\nСортировка по возрастанию:");
        listName.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue()).forEach(System.out::println);
    
        return "";
    }
}

