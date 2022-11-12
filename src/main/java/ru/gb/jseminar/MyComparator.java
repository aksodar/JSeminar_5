package ru.gb.jseminar;

import java.util.Comparator;
import java.util.HashMap;

public class MyComparator <K, V extends Comparable> implements Comparator<K> {

    private final HashMap<K, V> map;

    public MyComparator(HashMap<K, V> map) {
        this.map = map;
    }
    @Override
    public int compare(K o1, K o2) {
        return map.get(o2).compareTo(map.get(o1));
    }
}
