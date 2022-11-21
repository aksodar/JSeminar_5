package ru.gb.jseminar;

import java.util.*;
import java.util.logging.Logger;

public class Task0 {

    // Дана последовательность чисел. Необходимо вернуть сумму уникальных чисел
    public static void main(final String[] args) {
        Logger out = Logger.getLogger(Task0.class.getName());
        Task0 task0 = new Task0();
        List<Integer> numver = new ArrayList<Integer>(List.of(1,2,4,2,13,2,5));
        out.info(task0.getSumOfUniqueValues(numver).toString());

    }

    public Integer getSumOfUniqueValues(final List<Integer> list){
        Map<Integer,Integer> dict = new HashMap<>();
        for (Integer item: list) {
            if(dict.containsKey(item)){
                dict.put(item,dict.get(item) + 1);
            }else {
                dict.put(item, 1);
            }
        }
        Integer result = 0;
        for (Integer item:dict.values()) {
            if(item == 1) {
                result +=1;
            }
        }

        return result;
    }

}
