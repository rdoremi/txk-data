package com.leetcode;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class SearchDate {
    public static boolean isRunnian(int year) {//判断闰年/平年
        if ((year % 400 == 0&& year % 100 == 0) || (year % 4 == 0 && year % 100 != 0)) {
            return true;
        } else {
            return false;
        }
    }

    //计算天数
    public static int getDays(int year, int month, int date) {
        int days = 0;
        int Rtime[] = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int Ptime[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isRunnian(year)) {
            for (int i = 0; i < month; i++) {
                days += Rtime[i];
            }
            days += date;
        } else {
            for (int j = 0; j < month; j++) {
                days += Ptime[j];
            }
            days += date;
        }
        return days;
    }

    //判断年龄
    public static int getAge(int year, int month, int date) {
        Calendar calendar = Calendar.getInstance();
        return getAge(year, month, date, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DATE));

    }

    public static int getAge(int year, int month, int date, int sYear, int sMonth, int sDate) {

        int age = 0;
        if (year <= sYear) {
            if ((month > sMonth) || (month == sMonth && date > sDate))
                age = sYear - year - 1;
            else {
                age = sYear - year;
            }
        } else {
            System.out.println("日期不合法！！！");
        }
        return age;
    }

    public static int searchDays(int year, int month, int date) {
        Calendar calendar = Calendar.getInstance();
        return searchDays(year, month, date, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DATE));
    }

    public static int searchDays(int year, int month, int date, int sYear, int sMonth, int sDate) {
        int arriveDays = 0;
        for (int i = year + 1; i < sYear; i++) {
            if (isRunnian(i)) {
                arriveDays += 366;
            } else {
                arriveDays += 365;
            }
        }
        if (isRunnian(year)) {
            arriveDays += 366 - getDays(year, month, date);
        } else {
            arriveDays += 365 - getDays(year, month, date);
        }
        arriveDays += getDays(sYear, sMonth, sDate);
        return arriveDays;
    }

    public static String getZodiac(int year) {
        if (year <= 0) {
            throw new IllegalArgumentException("不合法参数");
        }
        String[] zodiac = {"鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊", "侯", "鸡", "狗", "猪"};
        int scoreYear = 1900;
        if (scoreYear<=year){
            return zodiac[(year-scoreYear)%zodiac.length];
        }
//        int y = (Math.abs(scoreYear-year))%zodiac.length;
        return zodiac[(zodiac.length-(Math.abs(scoreYear-year))%zodiac.length)%zodiac.length];
    }
    public static String myInfo(int year,int month,int date){
        int days = searchDays(year,month,date);
        int age = getAge(year,month,date);
        String zodiac = getZodiac(year);
        return "出生日期: "+year+"-"+month+"-"+date+" 当前"+age+"岁"+",属"+zodiac+", 共经历"+days+"天";
    }

    public static void main(String[] args) {

        String info = myInfo(1967, 11, 10); //1996 11 30
        System.out.println(info);
        System.out.println(isRunnian(2000));


    }
}
