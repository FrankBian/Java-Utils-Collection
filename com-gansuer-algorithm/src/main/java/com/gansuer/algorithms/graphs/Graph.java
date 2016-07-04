package com.gansuer.algorithms.graphs;

/**
 * API for an undirected graph
 * <p>
 * Created by Frank on 4/19/16.
 */
public interface Graph {

    /**
     * number of vertices
     *
     * @return
     */
    int getVertices();

    /**
     * number of edges
     *
     * @return
     */
    int getEdges();

    /**
     * add edge v-w to this graph
     *
     * @param v
     * @param w
     */
    boolean addEdge(int v, int w);

    /**
     * vertices adjacent to v
     *
     * @param v
     * @return
     */
    Iterable<Integer> adj(int v);


    /**
     * the degree of the vertices v
     *
     * @param v
     * @return
     */
    int degree(int v);


    /************************************
     * helper function
     ************************************/
    // maximum degree
    default int maxDegree() {
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
    default int avgDegree() {
        return 2 * getEdges() / getVertices();
    }


    //number of self-loops
    default int numberOfSelfLoops() {
        int count = 0;
        for (int v = 0; v < getVertices(); v++) {
            for (int w : adj(v)) {
                if (v == w) count++;
            }
        }
        return count / 2;
    }

    default void validateVertices(int v) {
        if (v < 0 || v >= getVertices())
            throw new IllegalArgumentException("vertex " + v + " is OutOfBound ,the getVertices is " + getVertices());
    }
}
