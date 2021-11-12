package com.data.avl;

import com.data.map.Map;

public class Bst<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node {
        private K key;
        private V value;
        private Node left;
        private Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public Bst() {
        root = null;
        size = 0;
    }

    @Override
    public void add(K key, V value) {

        root = add(root,key,value);
    }

    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    @Override
    public V remove(K key) {
        V delV = get(key);
        Node node = remove(root, key);
        return node == null?null:delV;
    }
    private Node remove(Node node,K key){
        if (node == null){
            return null;
        }
        if (key.compareTo(node.key)>0){
            node.right = remove(node.right,key);
            return node;
        }else if (key.compareTo(node.key)<0){
            node.left = remove(node.left,key);
            return node;
        }else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;

        }
    }
    private Node minimum(Node node){
        if (node.left == null){
            return node;
        }
        return minimum(node.left);
    }

    private Node removeMin(Node node){
        if (node.left == null){
            Node rightNode = node.right;
            size --;
            return rightNode;
        }
        node.left = removeMin(node);
        return node;
    }



    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public V get(K key) {

        Node node = getNode(root,key);

        return node==null?null:node.value;
    }

    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }

        if (node.key.compareTo(key) == 0) {
            return node;
        } else if (node.key.compareTo(key) > 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }

    }


    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root,key);
        if (node!=null){
            node.value = newValue;
        }else {
            throw new IllegalArgumentException(key+" doesn't exit");
        }
    }

    @Override
    public boolean contains(K key) {
        return getNode(root,key) == null ? false : true;
    }

    @Override
    public int getSize() {
        return size;
    }
}
