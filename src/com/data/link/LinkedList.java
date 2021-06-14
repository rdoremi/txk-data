package com.data.link;

public class LinkedList<E> {
    private class Node {
        private E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null);
        }
    }

    private Node dummyhead;
    private int size;

    public LinkedList() {
        dummyhead = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
       /* Node node = new Node(e);
        node.next = head;
        head = node;*/

       /* head = new Node(e,head);
        size++;*/
        add(0, e);
    }

    public void add(int index, E e) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException("参数错误");
        }

        Node cur = dummyhead;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        /*Node node = new Node(e);
        node.next = cur.next;
        cur.next = node; */
        cur.next = new Node(e, cur.next);
        size++;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException("参数错误");
        }
        Node cur = dummyhead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException("参数错误");
        }
        Node cur = dummyhead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public boolean contains(E e) {
        Node cur = dummyhead.next;
        while (cur != null) {

            if (e.equals(cur.e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    public void removeElement(E e){

        Node cur = dummyhead;
        while (cur.next!=null){


            if (cur.next.e.equals(e)){

                break;
            }
            cur = cur.next;
        }
        if (cur.next!=null){
            Node node = cur.next;
            cur.next = node.next;
            node.next = null;
            size--;
        }




    }

    public E remove(int index){
        if (index > size || index < 0) {
            throw new IllegalArgumentException("参数错误");
        }
        E ret = get(index);
        Node cur = dummyhead;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        Node node = cur.next;
        cur.next = node.next;
        node.next = null;
        size--;

        return ret;
    }
    public E removeFirst(){
        return remove(0);
    }
    public E removeLast(){
        return remove(size-1);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        /*Node cur = dummyhead.next;
        while (cur != null) {
            stringBuilder.append(cur.e);
            if (cur.next!=null){
                stringBuilder.append(",");
            }
            cur = cur.next;
        }*/
        for (Node cur = dummyhead.next; cur != null; cur = cur.next) {
            stringBuilder.append(cur.e);
            if (cur.next != null) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
