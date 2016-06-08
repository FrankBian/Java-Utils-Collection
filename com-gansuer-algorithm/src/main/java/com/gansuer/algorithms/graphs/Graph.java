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
    int V();

    /**
     * number of edges
     *
     * @return
     */
    int E();

    /**
     * add edge v-w to this graph
     *
     * @param v
     * @param w
     */
    void addEdge(int v, int w);

    /**
     * vertices adjacent to v
     *
     * @param v
     * @return
     */
    Iterable<Integer> adj(int v);

    /**
     * string representation
     *
     * @return
     */
    String toString();

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
        for (int v = 0; v < V(); v++) {
            degree = degree(v);
            if (degree > max) {
                max = degree;
            }
        }
        return max;
    }

    //average degree
    default int avgDegree() {
        return 2 * E() / V();
    }


    //number of self-loops
    default int numberOfSelfLoops() {
        int count = 0;
        for (int v = 0; v < V(); v++) {
            for (int w : adj(v)) {
                if (v == w) count++;
            }
        }
        return count / 2;
    }
}
