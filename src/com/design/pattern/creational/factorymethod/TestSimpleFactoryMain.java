package com.design.pattern.creational.factorymethod;

import java.lang.reflect.InvocationTargetException;

/**
 * 工厂模式
 */
public class TestSimpleFactoryMain {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, NoSuchMethodException, IllegalAccessException {
        VideoFactory factory =   new JavaVideoFactory();
        Video video = factory.getVideo();
        video.produce();
    }
}
