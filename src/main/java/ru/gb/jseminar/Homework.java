package ru.gb.jseminar;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Homework {
// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
// Пусть дан список сотрудников в формате строки
// "Ева,Дарахвелидзе,89010348765;Ева,Дарахвелидзе,89010344345;Андрей,Иванов,89050377654;Дмитрий,Пономаренко,89344322343;"
// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности.
    public static void main(final String[] args) {
        Homework task = new Homework();
        String text = "Ева,Дарахвелидзе,89010348765;Ева,Дарахвелидзе,89010344345;Андрей,Иванов,89050377654;Дмитрий,Пономаренко,89344322343;";
        System.out.println(task.getMaxPopularUser(text));

    }

    public String getMaxPopularUser(final String text){
        List <String> inputDict = Arrays.asList(text.split(";"));
        Map <String, List<String>> resultDict = new HashMap<>();
        for (String item: inputDict){
            List<String> temp = Arrays.asList(item.split(","));
            if (resultDict.containsKey(temp.get(0)+" "+temp.get(1))){
                List<String> tempName = resultDict.get(temp.get(0)+" "+temp.get(1));
                tempName.add(temp.get(2));                
                resultDict.put(temp.get(0)+" "+temp.get(1), tempName);
            }
            else {                
                List<String> tempName = new ArrayList<>(List.of(temp.get(2)));
                resultDict.put(temp.get(0)+" "+temp.get(1), tempName); 
            }
            
        }
        System.out.println(resultDict);  
                
        Map <String, Integer> listName = new HashMap<>();
        StringBuilder newList = new StringBuilder();
        for (String item : resultDict.keySet()) { 
            listName.put(item, resultDict.get(item).size());            
        }
        System.out.println(listName);
        while (listName.size()>0){
            Integer temp=0;
            // String count = "";
            String name="";
            for (String key: listName.keySet()){
                if (listName.get(key) > temp){
                    // count = String.valueOf(listName.get(key));                                                           
                    name = key;
                                       
                }              
            }
            newList.append(name);
            newList.append(" ");
            listName.remove(name);

        }
        System.out.println(newList);

        return "";
    }

}
