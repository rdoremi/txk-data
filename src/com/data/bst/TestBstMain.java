package com.data.bst;

public class TestBstMain {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        bst.add(5);
        bst.add(3);
        bst.add(6);
        bst.add(8);
        bst.add(88);
        bst.add(4);
        bst.add(2);
//        bst.levelOrder();
       /* System.out.println("最小值："+bst.minmum());
        System.out.println("最大值："+bst.maxnmum());
        bst.removeMin();
        bst.remove(4);
        System.out.println(bst);*/
        bst.preOrderNR();
    }
}
