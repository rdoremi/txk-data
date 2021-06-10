package com.alg.sort;


//插入排序 时间复杂度O(n^2) 当数组是有序数组时，时间复杂度O(n)  以最坏为准，所以是O(n^2)
public class InsertionSort {
    private InsertionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {

        for (int i = 0; i < arr.length; i++) {

            for (int j = i; j > 0; j--) {

                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr,j,j-1);

                }

            }

        }

    }

    public static <E extends Comparable<E>> void sort1(E[] arr) {

        for (int i = 0; i < arr.length; i++) {

            for (int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                   swap(arr,j,j-1);
            }

        }
    }
    public static <E extends Comparable<E>> void sort2(E[] arr) {

        for (int i = 0; i < arr.length; i++) {
            E t = arr[i];
            int j;
            for (j = i; j-1 >= 0 && t.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = t;

        }


    }
    private static <E> void swap(E[] arr,int i,int j){
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}

