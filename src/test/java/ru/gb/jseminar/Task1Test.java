package ru.gb.jseminar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {

    @Test
    void getNumberOfCouplesSuccessful() {
        List<Integer> inputList = new ArrayList<>(Arrays.asList(2, 1, 1, 1, 1, 1, 2, 2));

        int expected = 13;

        int actual = (new Task1()).getNumberOfCouples(inputList);
        Assertions.assertEquals(expected, actual);
    }
}