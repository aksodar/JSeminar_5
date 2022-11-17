package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Task3 {

    // Дана строка. Необходимо написать метод, который отсортирует слова в строке по длине с помощью TreeMap.
    // Строки с одинаковой длиной не должны “потеряться”.

    // Мороз и солнце день чудесный Еще ты дремлешь друг прелестный
    public static void main(final String[] args) {
        Task3 task = new Task3();
        Logger log = Logger.getLogger(Task3.class.getName());
        String s = "Мороз и солнце день чудесный Еще ты дремлешь друг прелестный";
        log.info(String.valueOf(task.getSortedIncludesWords(s)));
    }

    public String getSortedIncludesWords(final String text){
        List<String> list = Arrays.asList(text.toLowerCase().split(" "));
        Map<Integer, List <String>> hm = new HashMap<>();
        for(String item: list) {
            if(hm.containsKey(item.length())) {
                List <String> temp = hm.get(item.length());
                temp.add(item);
                hm.put(item.length(), temp);
            } else {
                List<String> temp = new ArrayList<>(List.of(item));
                hm.put(item.length(), temp);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (List <String> item: hm.values()) {
            for(String sss: item) {
                sb.append(sss);
                sb.append(" ");
            }
        }
        return String.valueOf(sb);
    }
}
