package ru.gb.jseminar;

import java.util.*;

public class Task1 {

    // Дана последовательность чисел. Необходимо вернуть число совпадающих пар в этой последовательности
    // Пример 1:     In: arr = [1, 2]  Out: 0
    // Пример 2:     In: arr = [1, 1, 2]  Out: 1
    // Пример 3:     In: arr = [1, 1, 1, 2, 2]  Out: 4
    public static void main(final String[] args) {
        List <Integer> array = new ArrayList<>(Arrays.asList(1, 2));
        Task1 c = new Task1();
        System.out.println(c.getNumberOfCouples(array));
    }

    public Integer getNumberOfCouples(final List<Integer> list){
        Map<Integer, Integer> book = new HashMap<>();

        for (Integer i : list){
            if(!book.containsKey(i)){
                book.put(i, 1);
            } else {
                book.put(i, book.get(i) + 1);
            }
        }
        int sum = 0;
        for(Integer i : book.keySet()){
            if(book.get(i) != 1) {
                sum += (book.get(i) * (book.get(i) - 1))/2;
            }
        }
        return sum;
    }
}