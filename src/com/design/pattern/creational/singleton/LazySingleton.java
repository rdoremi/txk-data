package com.design.pattern.creational.singleton;

//懒汉式单列模式
public class LazySingleton {
    private static LazySingleton lazySingleton = null;
    private LazySingleton(){}

    //线程不安全的
    public synchronized static LazySingleton getInstance(){//同步方法
        if (lazySingleton == null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
