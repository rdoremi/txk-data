package com.data.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {

    private class Node {
        private Node left;
        private Node right;
        private E e;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {

        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        } else if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        }

        return node;
    }
    //前序遍历非递归实现
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right!=null){
                stack.push(cur.right);
            }
           if (cur.left!=null){
               stack.push(cur.left);
           }

        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);

    }
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);

    }
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);

    }
    //层序遍历
    public void levelOrder(){

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.e);

            if (cur.left!=null){
                queue.add(cur.left);
            }
            if (cur.right!=null){
                queue.add(cur.right);
            }
        }
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {

        if (node == null) {
            return false;
        }
        if (node.e.compareTo(e) == 0) {
            return true;
        }
        if (e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        } else  {
            return contains(node.left, e);
        }

    }
    public E removeMin(){
        E ret = minmum();
        root = removeMin(root);
        return ret;
    }
    private Node removeMin(Node node){
        if (node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left =  removeMin(node.left);
        return node;
    }
    public E removeMax(){
        E ret = minmum();
        root = removeMax(root);
        return ret;
    }
    private Node removeMax(Node node){
        if (node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right =  removeMax(node.right);
        return node;
    }
    public void remove(E e){
        remove(root,e);
    }
    private Node remove(Node node,E e){
        if (node == null){
            return null;
        }
        if (e.compareTo(node.e)<0){
          node.left = remove(node.left,e);
          return node;
        }else if (e.compareTo(node.e)>0){
            node.right = remove(node.right,e);
            return node;
        }else {  //e.compareTo(node.e) == 0
            if (node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if (node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            Node successor = minmum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }

    }
    public E minmum(){
        Node node = minmum(root);
        E ret = node.e;
        return ret;
    }
    private Node minmum(Node node){

        if (node.left==null){

            return node;
        }
        return minmum(node.left);
    }
    public E maxnmum(){
        Node node = maxnmum(root);
        E ret = node.e;

        return ret;
    }
    private Node maxnmum(Node node){

        if (node.right==null){

            return node;
        }
        return maxnmum(node.right);
    }
/*
    @Override
    public String toString() {

        *//*
            5
           /  \
          3     6
         /  \     \
        2    4      8
        * *//*
        int tabs = 3;
        StringBuilder str = new StringBuilder();

        Queue<Node> queue = new DoubleLinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node cur = queue.remove();
            String lt = "\t";
            for (int i = 0; i < tabs; i++) {
                lt+=lt;
            }
            str.append("\n"+lt+cur.e);

            if (cur.left!=null){

                *//*for (int i = 0; i < tabs; i++) {
                    lt+=lt;
                }*//*
                str.append("\n"+lt+"/");
                queue.add(cur.left);
            }
            if (cur.right!=null){

                str.append("\t\t\t\\");
                queue.add(cur.right);
            }
        }
        return str.toString();
    }*/

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        generateBstString(root, 0, stringBuilder);
        return stringBuilder.toString();
    }

    private void generateBstString(Node node, int depth, StringBuilder stringBuilder) {
        if (node == null) {
            stringBuilder.append(generateDepthString(depth) + "null\n");
            return;
        }
        stringBuilder.append(generateDepthString(depth) + node.e + "\n");
        generateBstString(node.left, depth + 1, stringBuilder);
        generateBstString(node.right, depth + 1, stringBuilder);

    }

    private String generateDepthString(int depth) {
        StringBuilder rs = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            rs.append("--");
        }
        return rs.toString();
    }
}


