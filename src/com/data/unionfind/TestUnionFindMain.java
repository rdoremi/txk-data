package com.data.unionfind;

import java.util.Random;

public class TestUnionFindMain {
    private static double testUF(UF uf, int m) {
        int size = uf.getSize();
        Random random = new Random();
        long startTime = System.nanoTime();
        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a, b);
        }
        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int m = 100000;
        int size = 100000;

        System.out.println("unionFind1: " + testUF(new UnionFind1(size), m) + " s");
        System.out.println("unionFind2: " + testUF(new UnionFind2(size), m) + " s");
        System.out.println("unionFind3: " + testUF(new UnionFind3(size), m) + " s");
        System.out.println("unionFind4: " + testUF(new UnionFind4(size), m) + " s");
        System.out.println("unionFind5: " + testUF(new UnionFind5(size), m) + " s");
        System.out.println("unionFind6: " + testUF(new UnionFind6(size), m) + " s");
    }
}
