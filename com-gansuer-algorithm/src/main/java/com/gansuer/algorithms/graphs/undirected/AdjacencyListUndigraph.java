package com.gansuer.algorithms.graphs.undirected;

import com.gansuer.algorithms.graphs.undirected.UndirectedGraph;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Frank on 4/19/16.
 */
public class AdjacencyListUndigraph extends UndirectedGraph {

    private int edges;
    private Set<Integer>[] adj;  // adjacency-list representation

    public AdjacencyListUndigraph(final int vertices) {
        if (vertices < 0) throw new IllegalArgumentException("Number of Vertices must be non-negative");
        this.vertices = vertices;
        this.edges = 0;
        this.adj = (Set<Integer>[]) new Set[vertices];
        for (int i = 0; i < vertices; i++) {
            adj[i] = new HashSet<>();
        }
    }
    /**
     * add edge v-w to this graph
     *
     * @param v
     * @param w
     */
    @Override
    public boolean addEdge(int v, int w) {
        validateVertices(v);
        validateVertices(w);
        edges++;
        adj[v].add(w);
        adj[w].add(v);
        return true;
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
        stringBuilder.append("vertices :" + vertices +", edges : " + edges +"\n");
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

}
