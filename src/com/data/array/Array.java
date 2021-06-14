package com.data.array;



public class Array<E> {
    private E[] data;
    private int size;

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }
    public Array(E[] arr) {
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        size = arr.length;
    }
    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(E e) {

        add(size, e);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void add(int index, E e) {
        if (index > this.size || index < 0) {
            throw new IllegalArgumentException("参数错误");
        }
        if (size == data.length){
            resize(data.length*2);
        }
        for (int i = size; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }
        this.data[index] = e;
        size++;
    }
    public void swap(int i,int j){
        if (i<0||i>=size||j<0||j>=size){
            throw new IllegalArgumentException("Index is illegal");
        }
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }
    public E getFirst(){
        return get(0);
    }
    public E getLast(){
        return get(size - 1);
    }
    public E get(int index) {
        if (index < 0 || index > this.size) {
            throw new IllegalArgumentException("参数错误");
        }
        if (this.size == 0) {
            return null;
        }
        return this.data[index];
    }

    public void set(int index, E e) {
        if (index < 0 || index > this.size) {
            throw new IllegalArgumentException("参数错误");
        }
        this.data[index] = e;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public Array find(E e) {
        Array array = new Array();
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                array.addLast(i);
            }
        }
        return array;
    }

    public E remove(int index) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException("参数错误");
        }
        E delData = data[index];
        for (int i = index; i < size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
        size--;
        if (size==data.length/2){
            resize(data.length/2);
        }
        return delData;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public Array removeElement(E e) {
        Array array = new Array();
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)){
                array.addLast(remove(i));
            }
        }
        return array;
    }

    public void resize(int newCapacity){
        E[] temp = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        data = temp;

    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        for (int i = 0; i < size; i++) {
            stringBuffer.append(this.data[i]);
            if (i < size - 1) {
                stringBuffer.append(",");
            }
        }
        stringBuffer.append("],size = " + size + ",capacity = " + getCapacity());
        return stringBuffer.toString();
    }


}
