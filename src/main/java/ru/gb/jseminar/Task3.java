package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

public class Task3 {

    // Дана строка. Необходимо написать метод, который отсортирует слова в строке по длине с помощью TreeMap.
    // Строки с одинаковой длиной не должны “потеряться”.
    // String text = "Мороз и солнце день чудесный Еще ты дремлешь друг прелестный"

    public static void main(final String[] args) {
        String text = "Moroz i solntse den chudesniy esche ti dremlesh drug prelestniy";
        Task3 t3 = new Task3();
        Logger log = Logger.getLogger(Task3.class.getName());
        log.info(String.valueOf(t3.getSortedIncludesWords(text)));
    }

    public String getSortedIncludesWords(final String text){
        List<String> inputTextList = Arrays.asList(text.toLowerCase().split(" "));
        Map<Integer, List<String>> words = new TreeMap<>();
        for (String item : inputTextList) {
            if (words.containsKey(item.length())) {
                List<String> temp = words.get(item.length());
                temp.add(item);
                words.put(item.length(), temp);
            } else {
                List<String> temp = new ArrayList<>(List.of(item));
                words.put(item.length(), temp);
            }
        }
        StringBuilder resultText = new StringBuilder();
        for (List<String> item : words.values()) {
            resultText.append(item);
        }
        return String.valueOf(resultText);
    }

}
