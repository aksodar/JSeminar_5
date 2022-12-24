package ru.gb.jseminar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task2 {

    // ��� ��� ������ �����, ��� ����[i] = [������ ��, ������ ��] ��������, ��� ���������� ������ ����, ������ ��
    // ������ �� ������� ��. ������� ����� ����������, �� ���� ����� ��� ������-���� ����, �������� � ������ �����.
    // ������ 1: Input: s = [["������","������"], ["�����","�����"],["������","�����"]]  Output: �����
    // ������ 2: Input: s = [["������","������"]]  Output: ������
    public static void main(final String[] args) {
        Map<String,String> dano = new HashMap<>();
        dano.put("������","������");
        dano.put("�����","�����");
        dano.put("������","�����");
        Task2 task = new Task2();
        System.out.println(task.getFinalCity(dano));
    }

    public String getFinalCity(final Map<String, String> dano){
        for (String i: dano.keySet()) {
            if(!dano.containsKey(dano.get(i))){
                return dano.get(i);
            }
        }
        return "";
    }

}
