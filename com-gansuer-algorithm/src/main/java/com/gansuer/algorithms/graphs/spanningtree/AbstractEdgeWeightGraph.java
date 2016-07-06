package com.gansuer.algorithms.graphs.spanningtree;

/**
 * Created by Frank on 7/6/16.
 */
public abstract class AbstractEdgeWeightGraph {

    protected int vertices;
    protected int edges;


    public abstract Iterable<Edge> getEdgeList();

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
     *
     * @return
     */
    public int getEdges() {
        return edges;
    }

    /**
     * add edge to this graph
     */
    public abstract boolean addEdge(Edge edge);

    /**
     * vertices adjacent to v
     *
     * @param v
     * @return
     */
    public abstract Iterable<Edge> adj(int v);


    protected void validateVertices(int v) {
        if (v < 0 || v >= getVertices())
            throw new IllegalArgumentException("vertex " + v + " is OutOfBound ,the getVertices is " + getVertices());
    }
}
