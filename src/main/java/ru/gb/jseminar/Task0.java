package ru.gb.jseminar;

import java.util.*;

public class Task0 {

    // Дана последовательность чисел. Необходимо вернуть сумму уникальных чисел
    public static void main(final String[] args) {
       List<Integer> list = new ArrayList<>(Arrays.asList(1,2,2,3,3,4,5,5,8));
       Task0 t = new Task0();
       System.out.println(t.getSumOfUniqueValues(list));
    }

    public Integer getSumOfUniqueValues(final List<Integer> list){
        Map<Integer,Integer> map= new HashMap<>();
        for (Integer item: list){
            if (!map.containsKey(item)){
                map.put(item, 0);
            }
            else{
                map.put(item,map.get(item)+1);
            }
        }
        int sum =0;
        for(Integer item : map.keySet()){
            if(map.get(item)==0){
                sum = sum +item;
            }
        }
        return sum;
    }

}
