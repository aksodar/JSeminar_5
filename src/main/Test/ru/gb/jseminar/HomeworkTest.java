package ru.gb.jseminar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Map;

class HomeworkTest {
    Homework homework = new Homework();

    @Test
    void add_to_dictionary() {
        String name_tel = "Анна,Дарахвелидзе,89010348765;" +
                "Ева,Дарахвелидзе,89010344345;" +
                "Андрей,Иванов,89050377654;" +
                "Дмитрий,Пономаренко,89344322343";
        String ansver = "Андрей Иванов=[89050377654]," +
                " Анна Дарахвелидзе=[89010348765]," +
                " Дмитрий Пономаренко=[89344322343]," +
                " Ева Дарахвелидзе=[89010344345]";

        Map<String, List> actual = homework.add_to_dictionary(name_tel);

        Assertions.assertEquals(ansver, actual);
    }
}