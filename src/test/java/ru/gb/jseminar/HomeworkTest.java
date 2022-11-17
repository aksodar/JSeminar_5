package ru.gb.jseminar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HomeworkTest {
    @Test
    void findContactSuccessfull() {
        String inputText = "Ева,Дарахвелидзе,89010348765;Ева,Дарахвелидзе,89010344345;Андрей,Иванов,89050377654;Андрей,Иванов,89123456789;Андрей,Иванов,89987654321;Дмитрий,Пономаренко,89344322343;";
        String expected = "\nName:\tАндрей Иванов\nRepetitions:\t3\nName:\tЕва Дарахвелидзе\nRepetitions:\t2";

        Homework hw = new Homework();
        String actual = hw.findContact(inputText);

        Assertions.assertEquals(expected, actual);
    }
}
