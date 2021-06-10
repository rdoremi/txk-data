package com.alg.sort;

import java.util.Arrays;

//归并排序 时间复杂度O(nlogn)
public class MergeSort {

    private MergeSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);

    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        if (arr[mid].compareTo(arr[mid+1])>0)
            merge(arr, l, mid, r);
    }

    //合并两个有序区间 arr[l,mid] arr[mid+1,r]
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {

        E[] temp = Arrays.copyOfRange(arr, l, r + 1);

        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {

            if (i > mid) {
                arr[k] = temp[j - l];
                j++;
            } else if (j > r) {
                arr[k] = temp[i - l];
                i++;
            } else if (temp[i - l].compareTo(temp[j - l]) <= 0) {
                arr[k] = temp[i - l];
                i++;
            } else {
                arr[k] = temp[j - l];
                j++;
            }
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] arr) {
        E[] temp = Arrays.copyOf(arr,arr.length);
        sort2(arr, 0, arr.length - 1,temp);


    }

    private static <E extends Comparable<E>> void sort2(E[] arr, int l, int r,E[] temp) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        sort2(arr, l, mid,temp);
        sort2(arr, mid + 1, r,temp);
        if (arr[mid].compareTo(arr[mid+1])>0)
            merge2(arr, l, mid, r,temp);
    }

    //合并两个有序区间 arr[l,mid] arr[mid+1,r]
    private static <E extends Comparable<E>> void merge2(E[] arr, int l, int mid, int r,E[] temp) {

        System.arraycopy(arr,l,temp,l,r-l+1);
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {

            if (i > mid) {
                arr[k] = temp[j];
                j++;
            } else if (j > r) {
                arr[k] = temp[i];
                i++;
            } else if (temp[i].compareTo(temp[j]) <= 0) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
        }
    }
}
