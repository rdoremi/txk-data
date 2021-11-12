package com.leetcode;

import java.util.Arrays;

//求数组种最大三个树的乘积
public class ThreeArrayMax {

    //方式一
    public static int multMax(int[] arr){
        Arrays.sort(arr);
        return arr[arr.length-1]*arr[arr.length-2]*arr[arr.length-3];
    }
    public static int multMax2(int[] arr){
        int min1 = Integer.MAX_VALUE,min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE,max2 = Integer.MIN_VALUE,max3 = Integer.MIN_VALUE;
        for (int x : arr) {
            if (x<min1){
                min2 = min1;
                min1 = x;
            }else if (x<min2){
                min2 = x;
            }
            if (x>max1){
                max3 = max2;
                max2 = max1;
                max1 = x;
            }else if (x >max2){
                max3 = max2;
                max2 = x;
            }else if (x >max3){
                max3 = x;
            }
        }
        return Math.max(min1*min2*max1,max1*max2*max3);
    }

    public static void main(String[] args) {
        int[] arr= {2,3,4,5,6};
        System.out.println(multMax2(arr));
    }
}
