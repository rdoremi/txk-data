package com.leetcode;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "super.toString()";
    }



    public static void pattern(String str) {
        String s = "(?:^(?:\\\\+86)?1(?:33|53|7[37]|8[019]|9[19])\\\\d{8}$)|(?:^(?:\\\\+86)?1700\\\\d{7}$)";
        Pattern p = Pattern.compile(s, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(str);
        System.out.println(m.matches());
        if (m.find()) {
            System.out.println(m.group());
        }
    }

    private static String getType(Object a) {
        return a.getClass().toString();

    }



    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }
            }
        },"AA").start();
        new Thread(()->{
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        },"BB").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }
            }
        },"CC").start();
    }
}
class Ticket{
    private int tickets = 30;

    synchronized public void sale(){
        if (tickets>0){
            System.out.println(Thread.currentThread().getName()+": 卖出 "+(tickets--)+"  剩下："+tickets);
        }
    }
}
