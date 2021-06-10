package com.data.stack;

public class TestStackMain {
    public static void main(String[] args) {
        LinkedlistStack<Integer> stack = new LinkedlistStack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        stack.pop();
        System.out.println(stack);
    }
}
