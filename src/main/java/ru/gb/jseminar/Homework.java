package ru.gb.jseminar;
import java.util.*;

public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    // Пусть дан список сотрудников:Иван Иванов (и остальные, полный текст дз будет на платформе)
    // Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
    // Отсортировать по убыванию популярности.
    public static void main(final String[] args) {
        Homework hw = new Homework();
        String text = "Иван Иванов - 88569521456, Иван Иванов - 89523642255, Дмитрий Дмитриевич - 89632581595, " +
                "Владимир Владимирович - 89563211545, Владимир Владимирович - 89451251496, Владимир Владимирович - 89547563696, Юрий Юрьевич - 89632145698, " +
                "Елена Борисовна - 89564561232, Елена Борисовна - 89451233696";
        //String text = "Дмитрий Дмитриевич 89632581595";
        //String text = "Владимир Владимирович 89563211545 89451251496 89547563696";
        //String text = "Юрий Юрьевич 89632145698";
        //String text = "Елена Борисовна 89564561232 89451233696";

        System.out.println("" + hw.getSearchForMatches(Arrays.toString(new String[]{text})));


    }

    public Map<String, Integer> getSearchForMatches(String text) {
        Map<String, Integer> book = new HashMap<>();
        String[] splitted = text.split(", ");
        for (String i : splitted) {
            if (!book.containsKey(i)) {
                book.put(i, 1);
            }
            else {
                book.put(i, book.get(i) + 1);
            }
        }
        return book;
    }

}



    //public Map<String, List> getSortedDescending(String text) {
        //Map<String, List> sortedText = new TreeMap<>();
        //String[] splitted = text.split(" ");
        //for (String text : splitted) {


        //return sortedText;

