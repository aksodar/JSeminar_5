package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task1 {

    // Дана последовательность чисел. Необходимо вернуть число совпадающих пар в этой последовательности
    // Пример 1:     In: arr = [1, 2]  Out: 0
    // Пример 2:     In: arr = [1, 1, 2]  Out: 1
    // Пример 3:     In: arr = [1, 1, 1, 2, 2]  Out: 4
    //(n/2)*(n-1) формула расчета кол-ва повторяющихся чисел
    public static void main(final String[] args) {
        Task1 t1 = new Task1();
        List<Integer> numberlist = new ArrayList<>(List.of(1, 1, 1, 2, 2));
        System.out.println(t1.getNumberOfCouples(numberlist));
    }

    public Integer getNumberOfCouples(final List<Integer> list){
        Map<Integer, Integer> numberlist = new HashMap<>();
        for (Integer item : list) {
            numberlist.put(item, 1 + numberlist.getOrDefault(item, 0));
        }
            int result = 0;
        for (Integer item: numberlist.values()){
            if(item>1){
                result+= (double)item/2*(item-1);
            }

        }
        return result ;
    }

}
