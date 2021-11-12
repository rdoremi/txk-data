package com.design.pattern.creational.simplefactory;

import java.lang.reflect.InvocationTargetException;

/**
 * 简单工程，不属于 23种设计模式
 */
public class TestSimpleFactoryMain {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, NoSuchMethodException, IllegalAccessException {
        Video video =   VideoFactory.getVideo(JavaVideo.class);
        video.produce();
    }
}
