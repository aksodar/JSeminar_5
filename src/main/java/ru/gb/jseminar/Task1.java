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
    // Пример 4: In: arr = [1, 1, 1] Out: 3
    // Пример 5: In: arr = [1, 1, 1, 1] Out: 6
    // 6: 15 (1+(n-1))/2 *(n-1)
    public static void main(final String[] args) {
        Task1 task = new Task1();
        Logger log = Logger.getLogger(Task1.class.getName());
        log.info(task.getNumberOfCouples(listClone).toString());

    }

    public Integer getNumberOfCouples(final List<Integer> list) {

        return 0;
    }

}
