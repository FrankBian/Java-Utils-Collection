package com.gansuer.algorithms.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Frank on 6/8/16.
 */
public class AdjacencyMatrixGraph implements Graph {

    private final int vertices;
    private int edges;
    private boolean[][] adjMatrix;

    public AdjacencyMatrixGraph(final int vertices) {
        if (vertices < 0)
            throw new IllegalArgumentException("vertices number is MUST NOT negative");
        this.vertices = vertices;
        this.edges = 0;
        this.adjMatrix = new boolean[vertices][vertices];
    }


    /**
     * number of vertices
     *
     * @return
     */
    @Override
    public int V() {
        return vertices;
    }

    /**
     * number of edges
     *
     * @return
     */
    @Override
    public int E() {
        return edges;
    }

    /**
     * add edge v-w to this graph
     *
     * @param v
     * @param w
     */
    @Override
    public void addEdge(int v, int w) {
        validateVertice(v);
        validateVertice(w);
        if (!adjMatrix[v][w]) edges++;
        adjMatrix[v][w] = true;
        adjMatrix[w][v] = true;
    }

    /**
     * vertices adjacent to v
     *
     * @param v
     * @return
     */
    @Override
    public Iterable<Integer> adj(int v) {
        validateVertice(v);
        List<Integer> res = new ArrayList<>();
        int index = 0;
        for (boolean item : adjMatrix[v]) {
            if (item) {
                res.add(index);
            }
            index++;
        }
        return res;
    }

    /**
     * the degree of the vertices v
     *
     * @param v
     * @return
     */
    @Override
    public int degree(int v) {
        validateVertice(v);
        int res = 0;
        for (boolean item : adjMatrix[v]) {
            if (item) res++;
        }
        return res;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("vertices : " + vertices + " edges : " + edges).append("\n");
        for (int i = 0; i < vertices; i++) {
            stringBuilder.append(i + " :");
            for (int j = 0; j < vertices; j++) {
                if (adjMatrix[i][j]) {
                    stringBuilder.append(j + " ");
                }
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    private void validateVertice(int v) {
        if (v < 0 || v >= vertices)
            throw new IllegalArgumentException("vertice number is out of bounds, the vertices " +
                    "number is :" + vertices);
    }
}