package ru.gb.jseminar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Task0 {

	// Дана последовательность чисел. Необходимо вернуть сумму уникальных чисел
	public static void main(final String[] args) {
		Task0 task0 = new Task0();
		List<Integer> taskList = new ArrayList<>(Arrays.asList(1, 2, 4, 3, 1, 2, 10));
		Logger log = Logger.getLogger(Task0.class.getName());
		log.info(String.valueOf(task0.getSumOfUniqueValues(taskList)));
	}

	public int getSumOfUniqueValues(final List<Integer> list) {
		Map<Integer, Integer> checkMap = new HashMap();
		for (int item : list) {
			checkMap.put(item, 1 + checkMap.getOrDefault(item, 0));
		}
		int result = 0;
		for (int item : checkMap.values()) {
			if (item == 1) {
				result ++;
			}
		}
		return result;
	}
}
