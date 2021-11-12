package com.test;

public class Test {

    private static int num = 10;

    public static void getR(){

    }
    public void run(){
       getR();//非静态成员可以访问静态成员，静态成员只能访问静态成员
    }
    public static void main(String[] args) {
        System.out.println(Math.round(-8.5));
        Test test = new Test();
        test.run();
        int i = test.num;//静态成员可以用类的实例调用，也可以使用类名点变量名的形式，推荐后者
        //test.getR() 无法调用
    }
}
