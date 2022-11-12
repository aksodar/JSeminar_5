package ru.gb.jseminar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DecisionTest {

    Decision decision;

    @BeforeEach
    void setUp() {
        decision = new Decision();
    }

    @Test
    void popularNamesSuccessful() {
        String input =
                "Ева,Дарахвелидзе,89010348765;" +
                "Ева,Дарахвелидзе,89010344345;" +
                "Андрей,Иванов,89050377654;" +
                "Ева,Дарахвелидзе,89010344345;" +
                "Андрей,Иванов,89050377657;" +
                "Дмитрий,Пономаренко,89344322343;";

        String expected = "Ева Дарахвелидзе=3, Андрей Иванов=2";

        String actual = decision.popularNames(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void popularNamesFailureOnNull() {

        IllegalStateException actual = Assertions.assertThrows(IllegalStateException.class, () ->
                decision.popularNames(null));

        Assertions.assertEquals("String is null", actual.getMessage());
    }

    @Test
    void popularNamesFailureOnEmpty() {
        IllegalStateException actual = Assertions.assertThrows(IllegalStateException.class, () ->
                decision.popularNames(""));

        Assertions.assertEquals("String is empty", actual.getMessage());
    }

    @Test
    void popularNamesFailureOnExtremeValue() {
        String input =
                "Ева,Дарахвелидзе,89010344345" +
                "Ева,Дарахвелидзе,89010344345;" +
                "Андрей,Сергеевич,Иванов,89050377654;" +
                "Ева,Дарахвелидзе,89010344345;" +
                "Андрей,89050377657;" +
                "Дмитрий Пономаренко,89344322343;";

        IllegalStateException actual = Assertions.assertThrows(IllegalStateException.class, () ->
                decision.popularNames(input));

        Assertions.assertEquals("String is not valid", actual.getMessage());
    }

    @Test
    void popularNamesFailureOnlyUnique() {
        String input =
                "Ева,Дарахвелидзе,89010348765;" +
                "Андрей,Иванов,89050377654;" +
                "Дмитрий,Пономаренко,89344322343;";

        String expected = "Ева Дарахвелидзе=3, Андрей Иванов=2";

        String actual = decision.popularNames(input);

        Assertions.assertEquals(expected, actual);
    }
}