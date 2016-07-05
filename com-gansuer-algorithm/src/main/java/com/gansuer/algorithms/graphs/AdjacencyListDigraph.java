package com.gansuer.algorithms.graphs;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Frank on 7/1/16.
 */
public class AdjacencyListDigraph extends Digraph {

    private Set<Integer>[] adjList;

    public AdjacencyListDigraph(int vertices) {
        if (vertices < 0) throw new IllegalArgumentException("Vertices should be greater than 0");
        this.vertices = vertices;
        this.adjList = (Set<Integer>[]) new Set[vertices];
        for (int i = 0; i < vertices; i++) {
            this.adjList[i] = new HashSet<>();
        }
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
        if (adjList[v].add(w)) {
            edges++;
            return true;
        }
        return false;
    }

    /**
     * vertices connected to v by edges pointing from v
     *
     * @param v
     */
    @Override
    public Iterable<Integer> adj(int v) {
        verifyVertex(v);
        return adjList[v];
    }

    @Override
    public int outDegree(int v) {
        verifyVertex(v);
        return adjList[v].size();
    }

    @Override
    public int inDegree(int v) {
        verifyVertex(v);
        int count = 0;
        for (Set<Integer> item : adjList){
            if (item.contains(v)) count++;
        }
        return count;
    }

    /**
     * reverse of this digraph
     */
    @Override
    public Digraph reverse() {
        Digraph res = new AdjacencyListDigraph(this.vertices);
        int index = 0;
        for (Set<Integer> set : adjList) {
            for (int item : set) {
                res.addEdge(item, index);
            }
            index++;
        }
        return res;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        for (Set<Integer> set : adjList) {
            stringBuilder.append(index++).append(":");
            set.forEach(item -> stringBuilder.append(item).append(" "));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
