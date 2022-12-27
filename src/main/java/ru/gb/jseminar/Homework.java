package ru.gb.jseminar;

import java.util.*;

public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    // Написать программу, которая выведет список людей с их телефонами
    // Отсортировать по колличеству телефонов.
    Map<String, List<String>> phoneList = new TreeMap<>();

    public static void main(final String[] args) {
        Homework hm = new Homework();
        hm.add("Вячеслав Олегович Баранов", "535574");
        hm.add("Борис Максимович Данилов","145062");
        hm.add("Артур Валентинович Мартынов", "218455");
        hm.add("Артур Валентинович Мартынов", "535573");
        hm.add("Борис Максимович Данилов","592045");
        hm.add("Вячеслав Олегович Баранов","592025");
        hm.add("Артем Денисович Осипов","592055");
        hm.add("Борис Максимович Данилов","692025");
        hm.add("Артур Валентинович Мартынов", "535583");
        hm.add("Артур Валентинович Мартынов", "535599");
        hm.sort();

    }
    public Map<String, List<String>> add(String name, String phone){
            if(!phoneList.containsKey(name)){
                List<String> temp1 = new ArrayList<>();
                temp1.add(phone);
                phoneList.put(name, temp1);
            }
            else{
                List<String> temp2 = phoneList.get(name);
                temp2.add(phone);
                phoneList.put(name, temp2);
            }
        return phoneList;
    }
    public void sort (){
        Map<String, Integer> data = new HashMap<>();
        for(String i : phoneList.keySet()) {
            int size = phoneList.get(i).size();
            data.put(i, size);
        }
        List<Integer> n = new ArrayList<>();
        n.addAll(data.values());
        Collections.sort(n);

        Map<String, List<String>> sorted = new LinkedHashMap<>();
        for(int i = n.size()-1; i >= 0; i--){
            int a = n.get(i);
            String name = getKey(data, a);
            sorted.put(name, phoneList.get(name));
        }
        System.out.println(sorted);

    }
    public static <K, V> K getKey(Map<K, V> map, V value)
    {
        return map.entrySet().stream()
                .filter(entry -> value.equals(entry.getValue()))
                .findFirst().map(Map.Entry::getKey)
                .orElse(null);
    }
}
