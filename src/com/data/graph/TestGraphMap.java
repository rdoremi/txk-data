package com.data.graph;

public class TestGraphMap {
    public static void main(String[] args) {
        int n = 5;
        String vertexs[] = {"A","B","C","D","E"};
        Graph graph = new Graph(n);
        for (String vertex : vertexs) {
            graph.insertVertex(vertex);
        }
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);
        graph.showGraph();
    }
}
