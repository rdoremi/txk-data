package com.alg.sort;

public class QuickSort {
    private QuickSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);

    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        if (l > r) return;
        int p = partition(arr, l, r);
        sort(arr,l,p-1);
        sort(arr,p+1,r);
    }

    public static <E extends Comparable<E>> int partition(E[] arr, int l, int r) {
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(arr[l]) < 0) {
                j++;
                swap(arr, i, j);
            }
        }
        swap(arr, l, j);
        return j;
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
