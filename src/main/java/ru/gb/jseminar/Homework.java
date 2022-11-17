package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    // Пусть дан список сотрудников:Иван Иванов (и остальные, полный текст дз будет на платформе)
    // Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
    // Отсортировать по убыванию популярности.

    //"Ева,Дарахвелидзе,89010348765;Ева,Дарахвелидзе,89010344345;Андрей,Иванов,89050377654;Дмитрий,Пономаренко,89344322343;
    public static void main(final String[] args) {
        Homework hw = new Homework();
        Logger log = Logger.getLogger(Task0.class.getName());
        String date = "Ева,Дарахвелидзе,89010348765;Ева,Дарахвелидзе,89010344345;Андрей,Иванов,89050377654;Андрей,Иванов,89050300645;Дмитрий,Пономаренко,89344322343;";
        log.info(String.valueOf(hw.getSortedPhoneNumbers(date)));
    }

    public String getSortedPhoneNumbers(String text) {
        List<String> list = Arrays.asList(text.split(";"));
        Map<String,List <String>> hm = new HashMap<>();
        String key = "";
        
        for(String item: list) {
            List<String> listOfDate = Arrays.asList(item.split(","));
            if(hm.containsKey(listOfDate.get(0) + " " + listOfDate.get(1))) {
                key = listOfDate.get(0) + " " + listOfDate.get(1);
                List <String> temp = hm.get(key);
                temp.add(listOfDate.get(2));
                hm.put(key, temp);
            } else {
                key = listOfDate.get(0) + " " + listOfDate.get(1);
                List<String> temp = new ArrayList<>(List.of(listOfDate.get(2))); 
                hm.put(key, temp);
            }
        }       
        Map<Integer, List <String>> hmCountNum = new HashMap<>();
        for(String name: hm.keySet()) {
            if(hmCountNum.containsKey(hm.get(name).size())) {
                List <String> countList = hmCountNum.get(hm.get(name).size());
                countList.add(name);
                hmCountNum.put(hm.get(name).size(), countList);
            } else {
                List<String> counList = new ArrayList<>(List.of(name));
                hmCountNum.put(hm.get(name).size(), counList);
            }
        }
        Map<Integer, List<String>> sortedMap = new TreeMap<>(Collections.reverseOrder());
        sortedMap.putAll(hmCountNum);
        String result = "";
        for(Integer infoKey: sortedMap.keySet()) {
            for(String nameSurname: hmCountNum.get(infoKey)) {
                if(hm.containsKey(nameSurname)) {
                    result += "\n" + nameSurname + " - " + infoKey + "\n" + hm.get(nameSurname);
                } 
            }
        }
        return result;
    }
}
