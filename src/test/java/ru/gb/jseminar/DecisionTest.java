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
    void sortedNamesSuccessful() {
        String input = "Ева,Дарахвелидзе,89010348765;Ева,Дарахвелидзе,89010344345;" +
                "Андрей,Иванов,89050377654;Дмитрий,Пономаренко,89344322343;";

        String expected = "Ева Дарахвелидзе = 2";

        String actual = decision.sortedNames(input);

        Assertions.assertEquals(expected, actual);
    }
}