package com.gansuer.algorithms.graphs;

/**
 * API for an undirected graph
 *
 * Created by Frank on 4/19/16.
 */
public interface Graph {

    /**
     * number of vertices
     * @return
     */
    int V();

    /**
     * number of edges
     * @return
     */
    int E();

    /**
     * add edge v-w to this graph
     * @param v
     * @param w
     */
    void addEdge(int v,int w);

    /**
     * vertices adjacent to v
     * @param v
     * @return
     */
    Iterable<Integer> adj(int v);

    /**
     * string representation
     * @return
     */
    String toString();

    /**
     * the degree of the vertices v
     * @param v
     * @return
     */
    int degree(int v);
}
