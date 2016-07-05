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


    /**
     * the degree of the vertices v
     *
     * @param v
     * @return
     */
    public abstract int degree(int v);

    /************************************
     * helper function
     ************************************/
    // maximum degree
    public int maxDegree() {
        int max = Integer.MIN_VALUE, degree = 0;
        for (int v = 0; v < getVertices(); v++) {
            degree = degree(v);
            if (degree > max) {
                max = degree;
            }
        }
        return max;
    }

    //average degree
    public int avgDegree() {
        return 2 * getEdges() / getVertices();
    }
}
