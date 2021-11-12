package com.testdata;

public class LoopQueueTest<E extends Comparable<E>> {

    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueueTest(int capacity) {
        data = (E[]) new Object[capacity + 1];
        size = 0;
        tail = 0;//队尾
        front = 0;//队首
    }
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public int getCapacity(){
        return data.length - 1;
    }
    public void enqueue(E e){
        if ((tail + 1) % data.length == front){
            resize(getCapacity()*2);
        }
        data[tail] = e;
        size++;
    }
    private void resize(int capacity){
        E[] temp = (E[]) new Object[capacity];

        for (int i = 0; i < temp.length; i++) {
           temp[i] = data[(i+front)%data.length];
        }
        data = temp;
        front = 0;
        tail = size;
    }
    public E dequeue(){
        if (isEmpty()){
            throw new NullPointerException();
        }
        E ret = data[front];
        data[front] = null;
        size--;
        front=(front+1)%data.length;
        return ret;
    }
    public E getFront(){
        if (isEmpty()){
            throw new NullPointerException();
        }
        return data[front];
    }
}
