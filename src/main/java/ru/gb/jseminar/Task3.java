package ru.gb.jseminar;

import java.util.*;
import java.util.logging.Logger;

public class Task3 {

    // Дана строка. Необходимо написать метод, который отсортирует слова в строке по длине с помощью TreeMap.
    // Строки с одинаковой длиной не должны “потеряться”.
    // мороз и солонце день чудесный еще ты дремлешь друг прелестный
    public static void main(final String[] args) {
        String str = "мороз и солнце день чудесный еще ты дремлешь друг прелестный";
        Task3 tsk = new Task3();
        Logger log = Logger.getLogger(Task3.class.getName());
        log.info(String.valueOf(tsk.getSortedIncludesWords(str)));
    }

    public String getSortedIncludesWords(final String str){
        List<String> strList = Arrays.asList(str.toLowerCase().split(" "));
        Map<Integer, List<String>> strMap = new TreeMap<>();
        for (String item: strList) {
           if (strMap.containsKey(item.length())){
               List<String> tempLst = strMap.get(item.length());
               tempLst.add(item);
               strMap.put(item.length(),tempLst);
           } else {
               List<String> tempLst = new ArrayList<>(List.of(item));
               strMap.put(item.length(),tempLst);
           }

        }
        System.out.println(strMap);
        StringBuilder strBd = new StringBuilder();
        for (List <String> elem: strMap.values()){
            strBd.append(elem);
        }

        return String.valueOf(strBd);
    }

}
