package com.design.pattern.creational.singleton;

//懒汉模式 双重检查
public class LazyDoubleCheckSingleton {
//    private  static LazyDoubleCheckSingleton lazyDoubleCheckSingleton = null;
    private volatile static LazyDoubleCheckSingleton lazyDoubleCheckSingleton = null;
    private LazyDoubleCheckSingleton(){}

    public static LazyDoubleCheckSingleton getInstance(){
        if (lazyDoubleCheckSingleton == null){
            synchronized (LazyDoubleCheckSingleton.class){
                if (lazyDoubleCheckSingleton == null){
                    lazyDoubleCheckSingleton = new LazyDoubleCheckSingleton();
                }
            }

        }
        return lazyDoubleCheckSingleton;
    }

}
