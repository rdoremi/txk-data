package com.alg.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class SortingHelper {


    public static <E extends Comparable<E>> void sortTest(String className,String methodName,int n,boolean isOrderArray,boolean isSort) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        if (!isSort){
            return;
        }
        Integer[] arr = null;
        if (isOrderArray){
            arr = ArrayGenerator.generateOrderedArry(n);
        }else {
            arr = ArrayGenerator.generateRandomArray(n,1000);
        }

        Class<?> cs = Class.forName(className);

        Method[] methods = cs.getMethods();
        Class<?>[] parameterTypes = null;
        for (Method method : methods) {
            if (method.getName().equals(methodName)){
                parameterTypes = method.getParameterTypes();
            }
        }
        Method method = cs.getMethod(methodName,parameterTypes);
        long start = System.nanoTime();
        method.invoke(null,new Object[]{ arr});
        long end = System.nanoTime();
        double time = (end - start) / 1000000000.0;
        boolean sortNot = false;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1]>arr[i]){
                sortNot = true;
            }
        }
        String successSort = sortNot?"失败":"成功";
        System.out.println(className+"."+methodName+"-> "+n+"条数据用时: "+time+"秒, 排序"+successSort);

    }
}
