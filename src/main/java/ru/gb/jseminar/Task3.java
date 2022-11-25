package ru.gb.jseminar;

import java.util.*;
import java.util.logging.Logger;

public class Task3 {

    // Дана строка. Необходимо написать метод, который отсортирует слова в строке по длине с помощью TreeMap.
    // Строки с одинаковой длиной не должны “потеряться”.
    // Мороз и солнце день чудесный Ещё ты дремлешь друг прелестный
    public static void main(final String[] args) {
        Task3 tk3 = new Task3();
        Logger lg = Logger.getLogger(Task3.class.getName());

        String text = "Мороз и солнце день чудесный Ещё ты дремлешь друг прелестный";

        lg.info(String.valueOf(tk3.getSortedIncludesWords(text)));
    }

    public String getSortedIncludesWords(final String text){
        List<String> textList = Arrays.asList(text.toLowerCase().split(" "));
        Map<Integer,List<String>> map = new TreeMap<>();
        for (String item:textList){
            if(map.containsKey(item.length())){
                List<String> temp = map.get(item.length());
                temp.add(item);
                map.put(item.length(),temp);
            }else {
                List<String> temp = new ArrayList<>(List.of(item));
                map.put(item.length(),temp);
            }
        }
        StringBuilder result = new StringBuilder();
        for (List<String> item: map.values()) {
            result.append(item);

        }
        return String.valueOf(result);
    }

}
