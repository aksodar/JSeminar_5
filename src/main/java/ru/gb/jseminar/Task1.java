package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task1 {

    // Дана последовательность чисел. Необходимо вернуть число совпадающих пар в этой последовательности
    // Пример 1:     In: arr = [1, 2]  Out: 0
    // Пример 2:     In: arr = [1, 1, 2]  Out: 1
    // Пример 3:     In: arr = [1, 1, 1, 2, 2]  Out: 4
    public static void main(final String[] args) {
        Task1 t = new Task1();
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,2,3,3,4,5,5,8));
        System.out.println(t.getNumberOfCouples(list));
    }

    public Integer getNumberOfCouples(final List<Integer> list){

        return 0;
    }

}
