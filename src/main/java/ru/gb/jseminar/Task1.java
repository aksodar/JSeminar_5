package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Task1 {

    // Дана последовательность чисел. Необходимо вернуть число совпадающих пар в этой последовательности
    // Пример 1:     In: arr = [1, 2]  Out: 0
    // Пример 2:     In: arr = [1, 1, 2]  Out: 1
    // Пример 3:     In: arr = [1, 1, 1, 2, 2]  Out: 4
    public static void main(final String[] args) {
        Task1 task1 = new Task1();
        Logger out = Logger.getLogger(Task1.class.getName());
        List<Integer> arr_one = new ArrayList<>(List.of(1,2));
        List<Integer> arr_two = new ArrayList<>(List.of(1,1,2));
        List<Integer> arr_tree = new ArrayList<>(List.of(1,1 ,1,2,2));
        out.info(Integer.toString(task1.getNumberOfCouples(arr_one)));
        out.info(Integer.toString(task1.getNumberOfCouples(arr_two)));
        out.info(Integer.toString(task1.getNumberOfCouples(arr_tree)));

    }

    public int getNumberOfCouples(final List<Integer> list){
        Map<Integer,Integer> dict = new HashMap<>();
        float result = 0;
        for (Integer item:list){
            if(dict.containsKey(item)){
                dict.put(item, dict.get(item) + 1);
            }else {
                dict.put(item,1);
             }
            }
        for (Integer item:dict.keySet()) {
            if (dict.get(item) == 2){
                result += 1;
            }else {
                result += (1 + ((float)(dict.get(item)) - 1) / 2 * dict.get(item) - 1);
            }
        }
        return (int) result;
    }

}
