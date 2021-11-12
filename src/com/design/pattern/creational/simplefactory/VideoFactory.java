package com.design.pattern.creational.simplefactory;


import java.lang.reflect.InvocationTargetException;

//简单工厂 不属于23种设计模式
public class VideoFactory {
    public static Video getVideo(Class c) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Video video = null;
        Class<?> aClass = Class.forName(c.getName());
//        Constructor<?> constructor = aClass.getConstructor();
        video = (Video) aClass.newInstance();;

        return video;
    }

    /*public static Video getVideo(String type){
        if ("java".equalsIgnoreCase(type)){
            return new JavaVideo();
        }else if ("python".equalsIgnoreCase(type)){
            return new PythonVideo();
        }
        return null;
    }*/
}
