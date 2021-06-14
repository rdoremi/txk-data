package com.data.map;

public interface Map <K,V>{
    void add(K key,V value);
    V remove(K key);
    boolean isEmpty();
    V get(K key);
    void set(K key,V newValue);
    boolean contains(K key);
    int getSize();
}
