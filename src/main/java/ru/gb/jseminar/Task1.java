package ru.gb.jseminar;

import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task1 {

    // Дана последовательность чисел. Необходимо вернуть число совпадающих пар в этой последовательности
    // Пример 1:     In: arr = [1, 2]  Out: 0
    // Пример 2:     In: arr = [1, 1, 2]  Out: 1
    // Пример 3:     In: arr = [1, 1, 1, 2, 2]  Out: 4
    public static void main(final String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,1,1,1,2,2));
        Task1 task1 = new Task1();
        Logger log = Logger.getLogger(Task1.class.getName());
        log.info(String.valueOf(task1.getNumberOfCouples(list)));

    }

    public Integer getNumberOfCouples(final List<Integer> list){
        int number = 0;
        int sameNumbers = 1;
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(i) != null) {
                    if (list.get(i) == list.get(j)) {
                        sameNumbers = sameNumbers+1;
                        list.set(j, null);
                    }
                }
            }
            number = number + sameNumbers/2;
            sameNumbers = 1;
        }
        return number;
    }

}
