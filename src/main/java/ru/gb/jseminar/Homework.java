package ru.gb.jseminar;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    // Пусть дан список сотрудников:Иван Иванов (и остальные, полный текст дз будет на платформе)
    // Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
    // Отсортировать по убыванию популярности.
    public static void main(final String[] args) {
       List<String> foneList = Arrays.asList("Иван,Иванов,89010344567","Ева,Дарахвелидзе,89010348765", "Ева,Дарахвелидзе,89010344345", "Андрей,Иванов,89050377654", "Дмитрий,Пономаренко,89344322343");
       Homework hw = new Homework();
       System.err.println(hw.getCountFones(foneList));
      

    }
    
    public Map <String, Integer>  getCountFones (final List<String> list){
        Map<String, Integer> result = new HashMap<>();
        for (String item : list) {
            List<String> temp = Arrays.asList(item.split(","));
            String name = "";
            for (String s : temp) {
                if (isNumeric(s) == false){
                    name = new StringBuilder(name).append(s).append(" ").toString();
                    } 
            }
            if (result.containsKey(name)){
                result.put(name, result.get(name) +1);
            } else{
                result.put(name, 1);
            }
        }
        result.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()); 
        return result;
    }   

    public boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
