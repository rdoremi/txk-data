package com.data.array;

public class TestArrayMain {
    public static void main(String[] args) {
        Array<Integer> arr = new Array(10);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);
        arr.add(3, 22);
        arr.addFirst(62);
        arr.addLast(99);
        arr.set(4,88);
        arr.set(6,88);
        arr.set(11,88);

        System.out.println(arr);
        arr.remove(0);

        Array array = arr.removeElement(88);
        System.out.println(array);
//        arr.remove(0);
        System.out.println(arr);
    }
}
