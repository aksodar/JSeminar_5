package ru.gb.jseminar;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedHashMap;

public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    // Написать программу, которая выведет список людей с их телефонами
    // Отсортировать по колличеству телефонов.
    public static void main(final String[] args) {
        Homework hw = new Homework();

        String text = "Васильев Василий Васильевич,89244569878; Иванов Иван Иванович, 89644567896; Петров Петр Петрович, 89644563221;" +
                "Андреев Андрей Андреевич, 89144532778; Иванов Иван Иванович, 89243652147; Петров Петр Петрович, 89344322343;" +
                "Васильев Василий Васильевич, 89248745698; Андреев Андрей Андреевич, 89632365874; Васильев Василий Васильевич, 89144788996; Васильев Василий Васильевич, 89642388965Э";

        System.out.println(hw.findRepeats(text));
        System.out.println(hw.sortRepeats(hw.findRepeats(text)));
    }

    public Map<String, Integer> findRepeats(String inputString){
        Map<String,Integer> personMap = new HashMap<>();
        List<String> personList = Arrays.asList();
        List<String> temp =Arrays.asList();
        String name;
        personList = List.of(inputString.split(";"));
        for (String person: personList) {
            temp = List.of(person.split(","));
            name = temp.get(0) + " " + temp.get(1);
            if (personMap.containsKey(name)){
                personMap.replace(name, personMap.get(name) + 1);
            }
            else {
                personMap.put(name, 1);
            }
        }
        return personMap;
    }

    public Map<String, Integer> sortRepeats(Map<String, Integer> unsortedMap){
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        int max = 0;
        for (Integer value: unsortedMap.values()) {
            if (value > max){
                max = value;
            }
        }
        for (int i = max; i > 1; i--) {
            for (String person: unsortedMap.keySet()) {
                if (unsortedMap.get(person).equals(i)){
                    sortedMap.put(person, i);
                }
            }
        }
        return sortedMap;
    }
}




