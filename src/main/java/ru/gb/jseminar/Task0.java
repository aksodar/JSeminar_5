package ru.gb.jseminar;

import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task0 {

    // Дана последовательность чисел. Необходимо вернуть сумму уникальных чисел
    public static void main(final String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,5,12,2,3,4,1,2,6,7,8,7));
        Task0 task0 = new Task0();
        Logger log = Logger.getLogger(Task0.class.getName());

        log.info(String.valueOf(task0.getSumOfUniqueValues(list)));

    }

    public Integer getSumOfUniqueValues(final List<Integer> list){
        int number = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(i) == list.get(j)) {
                    list.remove(j);
                }  
            }
        }
        for (int i = 0; i < list.size(); i++) {
            number = number+list.get(i);
        }
        return number;
    }
}
