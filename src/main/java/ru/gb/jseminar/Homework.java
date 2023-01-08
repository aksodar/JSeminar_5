package ru.gb.jseminar;

// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
// Написать программу, которая выведет список людей с их телефонами
// Отсортировать по количеству телефонов.
import java.util.Map;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.List;

public class Homework  {
    public static void main(String[] args) {
        Homework tf = new Homework();
        String text = "Котов Сергей: 79023334455, 79994446688;Фандорин Денис: 78012221122;" +
                "Петров Иван: 78885556699, 79057773447, 79826668899; Жуков Андрей: 74890395678;";

        System.out.println(tf.SortGuide(text));
    }
    public Map<Long, List<String>> SortGuide(String txt){
        String[] lst = txt.split(";");
        Map<Long, List<String>> guide = new TreeMap<>();
        for (String i: lst){
            long Count = i.chars().filter(ch -> ch == ',').count();
            Count = Count+1;
            if(!guide.containsKey(Count)) {
                List <String> temp = new ArrayList<>();
                temp.add(i);
                guide.put((long) Count , temp);
            }
            else {
                List<String> temp = guide.get(Count);
                System.out.println(temp);
                temp.add(i);
                guide.put(Count, temp);
            }
        }
        return guide;
    }
}