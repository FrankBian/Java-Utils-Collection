package com.gansuer.algorithms.graphs.shortestpath;

import java.util.List;

/**
 * Created by Frank on 7/19/16.
 */
public class SP {

    private double weight;

    public SP(EdgeWeightDigraph digraph, int source) {

    }

    /**
     * distance from s to v, MAX_INTEGER if no path
     *
     * @param v
     * @return
     */
    public double distTo(int v) {
        return 0;
    }

    /**
     * has path from s to v ?
     *
     * @param v
     * @return
     */
    public boolean hasPathTo(int v) {
        return false;
    }

    /**
     * path from s to v, null if none
     *
     * @param v
     * @return
     */
    List<DirectedEdge> pathTo(int v) {
        return null;
    }
}
