package com.alg.linear;

public class LinearSearch {
    private LinearSearch(){}

    public static <E extends Comparable<E>> int search(E[] data,E target){
        for (int i = 0; i < data.length; i++) {
            if (data[i].compareTo(target) == 0){
                return i;
            }
        }
        return -1;
    }
}
