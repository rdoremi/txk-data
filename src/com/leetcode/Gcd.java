package com.leetcode;

//欧几里得算法/辗转相除法，求最大公约数
public class Gcd {


    public static int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    public static void main(String[] args) {
        int gcd = gcd(162, 8);
        System.out.println(gcd);
    }
}
