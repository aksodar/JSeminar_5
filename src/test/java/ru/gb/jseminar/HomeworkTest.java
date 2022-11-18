package ru.gb.jseminar;

 import org.junit.jupiter.api.Assertions;
 import java.util.HashMap;
 import java.util.Map;

 class HomeworkTest {

     @org.junit.jupiter.api.Test
     void countText() {
         String expectedstr = "Ева,Дарахвелидзе,89010348765;Ева,Дарахвелидзе,89010344345;Андрей,Иванов,89050377654;Дмитрий,Пономаренко,89344322343;";
         Map<String,Integer> expected = new HashMap<>();
         expected.put("Дмитрий, Пономаренко",1);
         expected.put("Ева, Дарахвелидзе",2);
         expected.put("Андрей, Иванов",1);


         Homework homework = new Homework();
         HashMap<String,Integer> actual = homework.count(expectedstr);

         Assertions.assertEquals(expected, actual);
     }
 }