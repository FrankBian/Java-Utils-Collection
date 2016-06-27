package com.gansuer.algorithms.graphs;

/**
 * Created by Frank on 6/24/16.
 */
public interface Search {

    /**
     * is v connected to s
     *
     * @param v
     * @return
     */
    boolean isConnected(int v);

    /**
     * how many vertices are connected to s
     *
     * @return
     */
    int count();
}
