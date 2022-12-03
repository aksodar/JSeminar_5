package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Task3 {

    // Дана строка. Необходимо написать метод, который отсортирует слова в строке по длине с помощью TreeMap.
    // Строки с одинаковой длиной не должны “потеряться”.
    public static void main(final String[] args) {
        Task3 tk = new Task3();
        String text = "Мороз и солнце день чудесный еще ты дремлешь друг прелестный";
        System.out.println(tk.getSortedIncludesWords(text));

    }

    public String getSortedIncludesWords(final String inputText){
        List<String> inputTextList = Arrays.asList(inputText.toLowerCase().split(" "));
        Map<Integer, List<String>> subResuMap = new TreeMap<>();
        for(String item: inputTextList){
            if(subResuMap.containsKey(item.length())){
                List<String> temp = subResuMap.get(item.length());
                temp.add(item);
                subResuMap.put(item.length(), temp);
            }else{
                List<String> temp = new ArrayList<>(List.of(item));
                 subResuMap.put(item.length(), temp);
            }
        }
        System.out.println(subResuMap);
        StringBuilder resultText = new StringBuilder();
        for (List<String> item: subResuMap.values()){
            resultText.append(item);
        }
        return String.valueOf(resultText);
    }

}
