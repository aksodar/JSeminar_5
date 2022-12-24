package ru.gb.jseminar;

import java.util.*;

public class Task3 {

    // ���� ������. ���������� �������� �����, ������� ����������� ����� � ������ �� ����� � ������� TreeMap.
    // ������ � ���������� ������ �� ������ ������������.
    public static void main(final String[] args) {
        Task3 task = new Task3();
        String dano = "����� � ������ , ���� ��������";
        System.out.println(task.getSortedIncludesWords(dano));
    }

    public Map<Integer, List<String>> getSortedIncludesWords(final String dano) {
        Map<Integer, List<String>> result = new TreeMap<>();
        List<String> array = Arrays.asList(dano.split(" "));
        for (String i : array) {
            if (result.containsKey(i.length())) {
                List<String> temp2 = result.get(i.length());
                temp2.add(i);
                result.put(i.length(),temp2);
            }
            else{
                List<String> temp = new ArrayList<>();
                temp.add(i);
                result.put(i.length(), temp);
            }

        }
        return result;
    }

}
