package ru.gb.jseminar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class HomeworkTest {
    @Test
    void recurringNamesSuccessful() {
        Homework hw = new Homework();
        String input = "Ева,Дарахвелидзе,89010348765;Ева,Дарахвелидзе,89010344345;Андрей,Иванов,89050377654;Дмитрий,Пономаренко,89344322343;" +
                "Дмитрий,Пономаренко,89344322343;Дмитрий,Пономаренко,89344322343;Simple,Name,SimpleNumber";
        String expected = "{3=[Дмитрий Пономаренко], 2=[Ева Дарахвелидзе], 1=[Simple Name, Андрей Иванов]}";
        String actual = hw.recurringNames(hw.phoneBook(input));
        Assertions.assertEquals(expected,actual);
    }
}