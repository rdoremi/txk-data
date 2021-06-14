package com.data.map;

public class TestMapMain {
    public static void main(String[] args) {
        BSTMap<String,Integer> map = new BSTMap<>();
        map.add("k1",123);
        map.add("k2",17323);
        map.add("k3",111323);
        map.add("k4",145123);
        map.add("k5",113323);
        Integer k3 = map.remove("k3");
        System.out.println(k3);
        System.out.println(map.getSize());
        System.out.println(map.contains("k4"));
    }
}
