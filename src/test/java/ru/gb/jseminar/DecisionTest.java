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
}