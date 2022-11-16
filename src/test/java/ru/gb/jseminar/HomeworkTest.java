package ru.gb.jseminar;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;




class HomeworkTest {
    
    @Test
    void getCountFonesSuccessful (){
        
        List<String> foneList = Arrays.asList("Иван,Иванов,89010344567","Ева,Дарахвелидзе,89010348765", "Ева,Дарахвелидзе,89010344345", "Андрей,Иванов,89050377654", "Дмитрий,Пономаренко,89344322343");
        Map<String,Integer>  expected = new HashMap<>();
        expected.put("Ева Дарахвелидзе ",2);
        expected.put("Андрей Иванов ",1);
        expected.put("Иван Иванов ",1);
        expected.put("Дмитрий Пономаренко ",1);
        expected.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed());
        
       
        Homework homework = new Homework();
        Map<String,Integer> actual = homework.getCountFones(foneList);

        Assertions.assertEquals(expected,actual);
       
        
    }

    
}