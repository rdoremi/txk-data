package com.data.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    private ArrayList<String> vertexList;//存储顶点集合
    private int[][] edges;//存储图对应的邻接矩阵
    private int numOfEdges;//表示边的数目
    public Graph(int n){
        //初始化矩阵vertexlist
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
    }

    //插入节点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }


    /**
     * 添加边
     * @param v1 表示点的下标 即是第几个顶点
     * @param v2
     * @param weight
     */
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    //返回节点的个数
    public int getNumOfVertex(){
        return vertexList.size();
    }
    //返回边的数目
    public int getNumOfEdges(){
        return numOfEdges;
    }
    //返回节点i(下标)对应的数据0->"A" 1->"B"
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }
    //返回v1和v2的权值
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }

    //显示图对应的矩阵
    public void showGraph(){
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }



}
