package com.gansuer.algorithms.graphs;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Frank on 4/19/16.
 */
public class GraphImpl implements Graph {

    private final int V;
    private int E;
    private Set<Integer>[] adj;  // adjacency-list representation

    public GraphImpl(final int V) {
        if (V < 0) throw new IllegalArgumentException("Number of Vertices must be non-negative");
        this.V = V;
        this.E = 0;
        this.adj = (Set<Integer>[]) new Set[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new HashSet<>();
        }
    }

    /**
     * number of vertices
     *
     * @return
     */
    @Override
    public int V() {
        return V;
    }

    /**
     * number of edges
     *
     * @return
     */
    @Override
    public int E() {
        return E;
    }

    /**
     * add edge v-w to this graph
     *
     * @param v
     * @param w
     */
    @Override
    public void addEdge(int v, int w) {
        validateVertices(v);
        validateVertices(w);
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }

    /**
     * vertices adjacent to v
     *
     * @param v
     * @return
     */
    @Override
    public Iterable<Integer> adj(int v) {
        validateVertices(v);
        return adj[v];
    }

    /**
     * the degree of the vertices v
     *
     * @param v
     * @return
     */
    @Override
    public int degree(int v) {
        validateVertices(v);
        return adj[v].size();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("vertices :" + V +", edges : " + E +"\n");
        int index = 0;
        for (Set<Integer> item : adj){
            stringBuilder.append(index +" : ");
            for (int val : item){
                stringBuilder.append(val +" ");
            }
            stringBuilder.append("\n");
            index++;
        }
        return stringBuilder.toString();
    }

    private void validateVertices(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is OutOfBound ,the V is " + V);
    }
}
