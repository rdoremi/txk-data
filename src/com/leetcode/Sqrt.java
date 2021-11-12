package com.leetcode;

//求平方根，不使用math.sqrt()
public class Sqrt {

    public static int sqrt(int x) {

        return binarySearch(x);
    }

    //二分查找 logN
    private static int binarySearch(int x) {
        int index = -1, l = 0, r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid * mid <= x) {
                index = mid;
                l=mid+1;
            }else {
                r = mid-1;
            }
        }
        return index;
    }
    public static double sqrt(double x){
        return newton(x,x);
    }
    //方式二：牛顿迭代
    public static double newton(double i,double x){
        double res = (i+x/i)/2;
        if (res == i){
            return i;
        }else {
           return newton(res,x);
        }
    }

    public static void main(String[] args) {
        double sqrt = sqrt(25);//4.898979485566356
        System.out.println(sqrt);
    }

}
