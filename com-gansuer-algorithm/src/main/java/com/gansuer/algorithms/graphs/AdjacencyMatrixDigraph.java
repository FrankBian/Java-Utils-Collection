package com.gansuer.algorithms.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Frank on 7/1/16.
 */
public class AdjacencyMatrixDigraph extends Digraph {
    private boolean[][] matrix;

    public AdjacencyMatrixDigraph(int vertices) {
        if (vertices < 0) throw new IllegalArgumentException("Vertices should be greater than 0");
        this.vertices = vertices;
        matrix = new boolean[vertices][vertices];
    }

    /**
     * add edge v -> w to this digraph
     *
     * @param v
     * @param w
     * @return
     */
    @Override
    public boolean addEdge(int v, int w) {
        verifyVertex(v);
        verifyVertex(w);
        edges++;
        matrix[v][w] = true;
        return true;
    }

    /**
     * vertices connected to v by edges pointing from v
     *
     * @param v
     */
    @Override
    public Iterable<Integer> adj(int v) {
        verifyVertex(v);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < matrix[v].length; i++) {
            if (matrix[v][i]) res.add(i);
        }
        return res;
    }

    /**
     * reverse of this digraph
     */
    @Override
    public Digraph reverse() {
        Digraph res = new AdjacencyMatrixDigraph(this.vertices);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]) res.addEdge(j, i);
            }
        }
        return res;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            sb.append(i).append(" : ");
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]) sb.append(j).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
