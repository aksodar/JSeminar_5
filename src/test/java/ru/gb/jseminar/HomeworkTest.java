package ru.gb.jseminar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class HomeworkTest {

    Homework hw = new Homework();

    @Test
    void getSortedPhoneNumbersTest() {
        String expSSS = "aaa,bbb,8888;aaa,bbb,3333;ddd,ccc,9999;aaa,bbb,1111;ddd,ccc,2222;ggg,hhh,5555;";
        String expFinal = "\naaa bbb - 3\n[8888, 3333, 1111]\nddd ccc - 2\n[9999, 2222]\nggg hhh - 1\n[5555]";

        String actSSS = hw.getSortedPhoneNumbers(expSSS);
        Assertions.assertEquals(expFinal, actSSS);

    }
}