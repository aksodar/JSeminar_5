package ru.gb.jseminar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HomeworkTest {
    Homework hw;
    @BeforeEach
    void start() {
        hw = new Homework();
    }

    @Test
    void popNamesSuccessful() {
        String input = "Ева,Дарахвелидзе,89010348765;" +
                       "Ева,Дарахвелидзе,89010344345;" +
                       "Дмитрий,Пономаренко,89050377654;" +
                       "Ева,Дарахвелидзе,89010344355;" +
                       "Андрей,Иванов,89050377657;" +
                       "Дмитрий,Пономаренко,89344322343;";

        String expected = "Ева Дарахвелидзе=3, Дмитрий Пономаренко=2";

        String actual = hw.popNames(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void popNamesNotValid() {
        String input = "Ева,Дарахвелидзе,89010344345" +
                "Ева,Дарахвелидзе,89010344345;" +
                "Андрей,Сергеевич,Иванов,89050377654;" +
                "Ева,Дарахвелидзе,89010344345;" +
                "Андрей,89050377657;" +
                "Дмитрий Пономаренко,89344322343;";

        IllegalStateException actual = Assertions.assertThrows(IllegalStateException.class, () ->
                hw.popNames(input));

        Assertions.assertEquals("Некорректный формат данных", actual.getMessage());
    }

    @Test
    void popNamesEqualPop() {
        String input = "Ева,Дарахвелидзе,89010138765;" +
                "Ева,Дарахвелидзе,89240348766;" +
                "Андрей,Иванов,89050377654;" +
                "Андрей,Иванов,89050372645;" +
                "Дмитрий,Пономаренко,89344342342;" +
                "Дмитрий,Пономаренко,89344322393;";

        String expected = "Все равны";

        String actual = hw.popNames(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void popNamesAllUnique() {
        String input = "Ева,Дарахвелидзе,89010348765;" +
                        "Андрей,Иванов,89050377654;" +
                        "Дмитрий,Пономаренко,89344322343;";

        String expected = "По одному номеру";

        String actual = hw.popNames(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void popNamesNull() {

        IllegalStateException actual = Assertions.assertThrows(IllegalStateException.class, () ->
                hw.popNames(null));

        Assertions.assertEquals("null", actual.getMessage());
    }

    @Test
    void popNamesEmpty() {
        IllegalStateException actual = Assertions.assertThrows(IllegalStateException.class, () ->
                hw.popNames(""));

        Assertions.assertEquals("Пустая стока", actual.getMessage());
    }
}