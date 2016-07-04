package com.gansuer.algorithms.graphs;

/**
 * Created by Frank on 7/4/2016.
 */
public abstract class UndirectedGraph implements Graph{

    protected int vertices;
    protected int edges;

    @Override
    public int getVertices() {
        return vertices;
    }

    @Override
    public int getEdges() {
        return edges;
    }

}
