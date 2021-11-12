package com.data.map;


public class LinkedListMap<K, V> implements Map<K, V> {
    private class Node {
        private K key;
        private V value;
        private Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key) {
            this(key, null, null);
        }

        public Node() {
            this(null, null, null);
        }

    }

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    @Override
    public void add(K key, V value) {

        Node node = getNode(key);
        if (node != null) {
            node.value = value;
            return;
        }
//        Node node = new Node(key,value,dummyHead.next);

//        node.next = dummyHead.next;
        dummyHead.next = new Node(key, value, dummyHead.next);//链表头添加数据
        size++;
    }

    private Node getNode(K key) {
        Node cur = dummyHead;
        while (cur.next != null) {
            cur = cur.next;
            if (cur.key.equals(key)) {
                return cur;
            }
        }
        return null;
    }

    @Override
    public V remove(K key) {

        Node cur = dummyHead;
        while (cur.next != null) {
            cur = cur.next;
            if (cur.next.key.equals(key)) {
                break;
            }

        }
        if (cur.next != null) {
            V delValue = cur.value;
            Node delNode = cur.next;
            cur.next = delNode.next;
            delNode.next = null;
            size--;
            return delValue;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        if (node == null) {
            return null;
        }
        return node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if (node != null) {
            node.value = newValue;
            return;
        } else {
            throw new IllegalArgumentException("doesn't exit!");
        }
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public int getSize() {
        return size;
    }
}
