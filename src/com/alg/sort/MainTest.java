package com.alg.sort;


import com.alg.utils.SortingHelper;

import java.lang.reflect.InvocationTargetException;

public class MainTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        int n = 1000000;
        SortingHelper.sortTest("com.alg.sort.SelectionSort", "sort", n,false,false);
        SortingHelper.sortTest("com.alg.sort.InsertionSort", "sort2", n,false,false);
        SortingHelper.sortTest("com.alg.sort.MergeSort", "sort2", n,false,false);
        SortingHelper.sortTest("com.alg.sort.QuickSort", "sort", n,false,false);
        SortingHelper.sortTest("com.alg.sort.HeapSort", "sort", n,false,true);

    }
}
