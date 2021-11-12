package com.design.pattern.creational.singleton;

public class TestSingletonMain {
    public static void main(String[] args) {
        LazySingleton lazySingleton = LazySingleton.getInstance();
        LazySingleton lazySingleton1 = LazySingleton.getInstance();
        System.out.println(lazySingleton == lazySingleton1);
    }
}
