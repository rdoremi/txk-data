package com.data.unionfind;

//并查集
public interface UF {

    boolean isConnected(int p,int q);
    void unionElements(int p,int q);
    int getSize();


}
