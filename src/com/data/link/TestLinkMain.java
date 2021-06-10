package com.data.link;

public class TestLinkMain {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.addFirst(i);
        }
        System.out.println(linkedList);
        linkedList.add(3,200);
        linkedList.removeLast();
        linkedList.removeFirst();
        System.out.println(linkedList);
        System.out.println(linkedList.getSize());
        System.out.println(linkedList.contains(3));
        System.out.println(linkedList.get(4));
    }
}
