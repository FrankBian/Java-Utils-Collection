package com.gansuer.algorithms.graphs.directed;

import com.gansuer.algorithms.graphs.Graph;

/**
 * Created by Frank on 7/1/16.
 */
public abstract class Digraph implements Graph {

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
     * reverse of this digraph
     */

    public abstract Digraph reverse();

    public abstract int inDegree(int v);
    public abstract int outDegree(int v);
    protected void verifyVertex(int v) {
        if (v < 0 || v >= vertices)
            throw new IllegalArgumentException("v should be [0," + vertices + "), but actual is :"
                    + v);
    }
}
