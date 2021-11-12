package com.data.set;



import com.data.util.LoadFile;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


public class BstSetMain {
    public static void main(String[] args) {

//        ArrayList<String> world1 = new ArrayList<>();
        ArrayList<String> world1 = new ArrayList<>();
        LoadFile.readFile("D:\\Desktop\\files\\学习\\英文原版\\The Magic of Oz - L. Frank Baum.pdf",world1);
        System.out.println("总字符数："+world1.size());
        BSTSet<String> bstSet = new BSTSet<>();
        for (String wd : world1) {

            bstSet.add(wd);
        }
        System.out.println("单词数："+bstSet.getSize());
    }



}
