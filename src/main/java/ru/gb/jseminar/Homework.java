package ru.gb.jseminar;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.NavigableMap;


public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    // Пусть дан список сотрудников в формате строки
    // "Ева,Дарахвелидзе,89010348765;Ева,Дарахвелидзе,89010344345;Андрей,Иванов,89050377654;Дмитрий,Пономаренко,89344322343;"
    // Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
    // Отсортировать по убыванию популярности.
    public static void main(final String[] args) {
        //rawString
        String rawString = "Андрей,Иванов,89991234523;Ева,Дарахвелидзе,89010348765;Ева,Дарахвелидзе,89010344345;Андрей,Иванов,89050377654;Дмитрий,Пономаренко,89344322343;Андрей,Иванов,89023233232;Дмитрий,Пономаренко,893434322343";
        //Создаём объект 
        Homework hw = new Homework();
        //Используем метод parseStringToMap для преобразования строки в хэшМап
        HashMap<String, ArrayList<String>> actualPhoneBook = hw.parseStringToMap(rawString);
        //Вывод в консоль Телефонной книги
        System.out.println(actualPhoneBook);
        //Вывод дубликатов
        System.out.print(hw.getNumberDuplicateName(actualPhoneBook));

    }
    //Метод для преобразования строки в хэшмап: Ключ(Имя Фамилия), Значение (Массив Телефонных номеров)
    public HashMap<String, ArrayList<String>> parseStringToMap(String phones){
        //Создаём объект phoneBook
        HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

        //Преобразуем строку в хэшмап
        String[] subString = phones.split(";");
        for (String item: subString){
            String[] splitUserData = item.split(",");
                //Для каждого человека создаётся массив с номером телефона или несколькими номерами телефонов
                if (phoneBook.containsKey(splitUserData[0]+" "+splitUserData[1]) == false){            
                    phoneBook.put(splitUserData[0]+" "+splitUserData[1], new ArrayList<String>());
                    phoneBook.get(splitUserData[0]+" "+splitUserData[1]).add(splitUserData[2]); 
                //Случай для человека с несколькими номерами    
                } else {
                    phoneBook.get(splitUserData[0]+" "+splitUserData[1]).add(splitUserData[2]);
                }
        }
        //Возвращаем хэшМап телефонной книги
        return phoneBook;
    }
    //Метод для получения NavigableMap: ключ(Колличество номеров), Значение(ArrayList<Имя ФамилияЮ) > 1
    public NavigableMap<Integer, ArrayList<String>> getNumberDuplicateName(HashMap<String, ArrayList<String>> phoneBook){
        TreeMap<Integer, ArrayList<String>> numberDuplicate = new TreeMap<>(); 
        for (String key: phoneBook.keySet()){
            if (phoneBook.get(key).size() > 1){
                Integer value = Integer.valueOf(phoneBook.get(key).size());
                if (numberDuplicate.containsKey(value) == false){
                    numberDuplicate.put(phoneBook.get(key).size(), new ArrayList<String>() );
                    numberDuplicate.get(value).add(key);
                } else {
                    numberDuplicate.get(value).add(key);
                }
                
            }
        }
        return numberDuplicate.descendingMap();
    }
}
