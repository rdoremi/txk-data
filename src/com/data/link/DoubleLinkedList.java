package com.data.link;

//双向链表
public class DoubleLinkedList<E extends Comparable<E>>{
    private class Node{
        private E e;
        private Node next;
        private Node prev;
        public Node(E e,Node prev,Node next){
            this.e = e;
            this.next = next;
            this.prev = prev;
        }
        public Node(E e){
            this(e,null,null);
        }
        public Node(){
            this(null,null,null);
        }
    }
    private Node dummyHead;
    private int size;
    public DoubleLinkedList(){
        dummyHead = new Node();
        size = 0;
    }

    public void add(E e){
        Node cur = dummyHead;
        for (int i = 0; i < size; i++) {
            cur = cur.next;
        }
        cur.next = new Node(e,cur,cur.next);
        size++;
    }




    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node cur = dummyHead;
        for (int i = 0; i < size; i++) {
            cur = cur.next;
           if (cur!=null){
               stringBuilder.append("cur = "+cur.e+" cur.prev = "+cur.prev.e+" \n");

           }

        }
        System.out.println("---"+cur.e);
        for (int i = 0; i < size; i++) {
            if (cur!=null){
                stringBuilder.append(cur.prev.e+" ");
                System.out.println(cur.prev.e);
            }
            cur = cur.prev;
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        DoubleLinkedList linkedList = new DoubleLinkedList();
        for (int i = 0; i < 10; i++) {
            linkedList.add(i+20);
        }
        linkedList.add(209);
        linkedList.add(2019);
        System.out.println(linkedList);
    }
}
