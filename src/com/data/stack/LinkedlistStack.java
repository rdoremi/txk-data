package com.data.stack;

import com.data.link.LinkedList;

public class LinkedlistStack <E> implements Stack<E>{
    LinkedList<E> linkedList;

    public LinkedlistStack(){
        linkedList = new LinkedList<>();
    }
    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LinkedListStack: ");
        stringBuilder.append(linkedList);
        return stringBuilder.toString();
    }
}
