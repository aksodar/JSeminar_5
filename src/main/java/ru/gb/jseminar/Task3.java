package ru.gb.jseminar;

import java.util.*;
import java.util.logging.Logger;

public class Task3 {

	// Дана строка. Необходимо написать метод, который отсортирует слова в строке по длине с помощью TreeMap.
	// Строки с одинаковой длиной не должны “потеряться”.
	public static void main(final String[] args) {
		String text = "Мороз и солнце день чудесный Еще ты дремлешь друг прелестный";
		Logger log = Logger.getLogger(Task3.class.getName());
		log.info((new Task3()).getSortedIncludesWords(text));

	}

	public String getSortedIncludesWords(final String inputText) {
		List<String> inputTextList = Arrays.asList(inputText.toLowerCase().split(" "));
		Map<Integer, List<String>> subResultMap = new TreeMap<>();
		for (String item : inputTextList) {
			if (subResultMap.containsKey(item.length())) {
				List<String> tmp = subResultMap.get(item.length());
				tmp.add(item);
				subResultMap.put(item.length(), tmp);
			} else {
				List<String> tmp = new ArrayList<>(List.of(item));
				subResultMap.put(item.length(), tmp);
			}
		}
		StringBuilder resultText = new StringBuilder();
		for (List<String> item : subResultMap.values()) {
			resultText.append(item);
		}
		return String.valueOf(resultText);
	}
}
