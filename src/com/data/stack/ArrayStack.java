package com.data.stack;

import com.data.array.Array;

public class ArrayStack<E extends Comparable>  implements Stack<E>{
    private Array<E> array;

    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }
    public ArrayStack(){
        array = new Array<>();
    }
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.getSize() == 0;
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            stringBuilder.append(array.get(i));
            if (i<array.getSize()-1){
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        stringBuilder.append(" top");
        return stringBuilder.toString();
    }
}
