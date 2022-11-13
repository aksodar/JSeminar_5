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
    // Пример 4:     In: arr = [1, 1, 1]  Out: 3
    // Пример 5:     In: arr = [1, 1, 1, 1]  Out: 6
//    2:1
//    3:3
//    4:6
//    5:10
//    6:15 (1+(n-1))/2 *(n-1)
    public static void main(final String[] args) {

        Task1 tk = new Task1();
        List<Integer> taskList = new ArrayList<>(List.of(1, 1, 1)); //правильный ответ 4
        System.out.println(tk.getNumberOfCouples(taskList));
    }

    public Integer getNumberOfCouples(final List<Integer> list) {

        Map<Integer,Integer> checkMap = new HashMap<>();
        for (Integer item: list) {

            checkMap.put(item,1+checkMap.getOrDefault(item,0));
        }
        Integer result = 0;
        System.out.println(checkMap);
        for (Integer item: checkMap.values()) {
            
            if (item > 1) {
                System.out.println(item);
                result += item/2 *(item-1); //должно быть 3, но получается 2 из-за Integer item
                System.out.println(result);
            }
        }
        return result;
    }

}