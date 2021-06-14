package com.data.set;



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
        readFile("D:\\Desktop\\文件\\英文原版\\The Magic of Oz - L. Frank Baum.pdf",world1);
        System.out.println("总字符数："+world1.size());
        BSTSet<String> bstSet = new BSTSet<>();
        for (String wd : world1) {

            bstSet.add(wd);
        }
        System.out.println("单词数："+bstSet.getSize());
    }


    public static boolean readFile(String filename, ArrayList<String> words){
        if (filename==null||words==null){
            return false;
        }
        Scanner scanner;

        try {
            File file = new File(filename);
            if (file.exists()){

                    FileInputStream fis = new FileInputStream(file);
                    scanner = new Scanner(new BufferedInputStream(fis),"UTF-8");
                    scanner.useLocale(Locale.ENGLISH);

            }else {
                System.out.println("没有找到");
                return false;
            }
        }catch (FileNotFoundException e) {
            System.out.println("Cannot open "+filename);
            return false;
        }

       /* File file = new File(filename);
        if (file.exists()){
            try {
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis),"UTF-8");
                scanner.useLocale(Locale.ENGLISH);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("没有找到");
            return false;
        }*/
        if (scanner.hasNextLine()){
            String contents = scanner.useDelimiter("\\A").next();
            int start = firstCharacterIndex(contents,0);
            for (int i = start+1; i <= contents.length() ;) {
                if (i == contents.length()||!Character.isLetter(contents.charAt(i))){
                    String word = contents.substring(start,i).toLowerCase();
                    words.add(word);
                    start = firstCharacterIndex(contents,i);
                    i = start+1;
                }else {
                    i++;
                }
            }
        }
        return true;
    }
    private static int firstCharacterIndex(String s,int start){
        for (int i = start; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))){
                return i;
            }
        }
        return s.length();
    }
}