package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Task1 {

    // Дана последовательность чисел. Необходимо вернуть число совпадающих пар в
    // этой последовательности
    // Пример 1: In: arr = [1, 2] Out: 0
    // Пример 2: In: arr = [1, 1, 2] Out: 1
    // Пример 3: In: arr = [1, 1, 1, 2, 2] Out: 4
    public static void main(final String[] args) {
        Task1 task = new Task1();
        Logger log = Logger.getLogger(Task1.class.getName());
        List<Integer> list = new ArrayList<>(List.of(1, 1, 1, 1, 1, 1));
        log.info("\nList:\t" + list.toString() + "\nNumber of matching pairs:\t"
                + task.getNumberOfCouples(list).toString());
    }

    public Integer getNumberOfCouples(final List<Integer> list) {
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) == list.get(j)) {
                    result++;
                }
            }
        }
        return result;
    }

}
