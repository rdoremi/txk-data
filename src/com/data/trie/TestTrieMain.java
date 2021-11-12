package com.data.trie;

import com.data.set.BSTSet;
import com.data.util.LoadFile;

import java.util.ArrayList;

public class TestTrieMain {
    public static void main(String[] args) {
        ArrayList<String> world1 = new ArrayList<>();
        LoadFile.readFile("D:\\Desktop\\files\\学习\\英文原版\\The Magic of Oz - L. Frank Baum.pdf",world1);
        System.out.println("总字符数："+world1.size());
        Trie trie = new Trie();
        for (String wd : world1) {

            trie.add(wd);
        }
        System.out.println("单词数："+trie.getSize());
    }
}
