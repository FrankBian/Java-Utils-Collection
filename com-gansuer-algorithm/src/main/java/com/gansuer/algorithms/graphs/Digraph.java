package com.gansuer.algorithms.graphs;

/**
 * Created by Frank on 7/1/16.
 */
public abstract class Digraph {

    protected int vertices;
    protected int edges;

    /**
     * number of vertices
     *
     * @return
     */
    public int getVertices() {
        return vertices;
    }

    /**
     * number of edges
     */
    public int getEdges() {
        return edges;
    }

    /**
     * add edge v -> w to this digraph
     *
     * @param v
     * @param w
     * @return
     */
    public abstract boolean addEdge(int v, int w);

    /**
     * vertices connected to v by edges pointing from v
     */
    public abstract Iterable<Integer> adj(int v);

    /**
     * reverse of this digraph
     */

    public abstract Digraph reverse();

    public abstract String toString();

    protected void verifyVertex(int v) {
        if (v < 0 || v >= vertices)
            throw new IllegalArgumentException("v should be [0," + vertices + "), but actual is :"
                    + v);
    }
}
