package ru.gb.jseminar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class HomeworkTest {


    @Test
    void getPhonesSucess() {
        String list = "A,B,123;A,B,231;C,D,234;C,D,263;C,D,221;F,G,456;";

        String expect = "{3=C D, 2=A B}";

        Homework hw = new Homework();
        String actual = hw.getPhones(list);

        Assertions.assertEquals(expect,actual);


    }
}
