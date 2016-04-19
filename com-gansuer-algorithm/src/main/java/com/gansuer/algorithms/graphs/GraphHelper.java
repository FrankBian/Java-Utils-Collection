package com.gansuer.algorithms.graphs;

/**
 * Created by Frank on 4/19/16.
 */
public class GraphHelper {

    // maximum degree
    public static int maxDegree(Graph graph) {
        int max = Integer.MIN_VALUE, degree = 0;
        for (int v = 0; v < graph.V(); v++) {
            degree = graph.degree(v);
            if (degree > max) {
                max = degree;
            }
        }
        return max;
    }

    //average degree
    public static int avgDegree(Graph graph) {
        return 2 * graph.E() / graph.V();
    }

    //number of self-loops
    public static int numberOfSelfLoops(Graph graph) {
        int count = 0;
        for (int v = 0; v < graph.V(); v++) {
            for (int w : graph.adj(v)) {
                if (v == w) count++;
            }
        }
        return count / 2;
    }
}
