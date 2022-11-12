package ru.gb.jseminar;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Homework {

	// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
	// Пусть дан список сотрудников в формате строки
	// "Ева,Дарахвелидзе,89010348765;Ева,Дарахвелидзе,89010344345;Андрей,Иванов,89050377654;Дмитрий,Пономаренко,89344322343;"
	// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
	// Отсортировать по убыванию популярности.
	public static void main(String[] args) {
		String text = "Ева,Дарахвелидзе,89010348765;Ева,Дарахвелидзе,89010344345;Андрей,Иванов,89050377654;" +
				"Ева,Дарахвелидзе,89050477654;Дмитрий,Пономаренко,89344322343;Андрей,Иванов,89060377654;" +
				"Иван,Иванов,89111111111;Иван,Иванов,89111111112;";

		Homework homework = new Homework();
		Map<Long, List<String>> phonebook = homework.textToPhonebookMap(text);

		Logger log = Logger.getLogger(Homework.class.getName());
		log.info("Телефонная книга: " + String.valueOf(phonebook));
		log.info("Результат: " + String.valueOf(homework.repeatName(phonebook)));
	}

	public Map<Long, List<String>> textToPhonebookMap (String text) {
		List<String> textList = Arrays.asList(text.split(";"));
		Map<Long, List<String>> phonebook = new HashMap<>();

		for (String item : textList) {
			List<String> tmp = Arrays.asList(item.split(","));
			phonebook.putIfAbsent(Long.parseLong(tmp.get(2)), Arrays.asList(tmp.get(0), tmp.get(1)));
		}
		return phonebook;
	}

	public Map<Integer, List<String>> repeatName (Map<Long, List<String>> phonebook) {
		Map<String, Integer> identicalContacts = new HashMap<>();
		for (List<String> item : phonebook.values()) {
			identicalContacts.put(String.join(" ", item), 1 + identicalContacts.getOrDefault(String.join(" ", item),0));
		}

		Map<Integer, List<String>> result = new TreeMap<>(Collections.reverseOrder());
		for (String key : identicalContacts.keySet()) {
			if (identicalContacts.get(key) > 1) {
				if (result.containsKey(identicalContacts.get(key))) {
					List<String> tmp = result.get(identicalContacts.get(key));
					tmp.add(key);
					result.put(identicalContacts.get(key), tmp);
				} else {
					List<String> tmp = new ArrayList<>(List.of(key));
					result.put(identicalContacts.get(key), tmp);
				}
			}
		}
		return result;
	}
}
