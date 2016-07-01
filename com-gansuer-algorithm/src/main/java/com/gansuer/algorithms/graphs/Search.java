package com.gansuer.algorithms.graphs;

/**
 * Created by Frank on 7/1/16.
 */
public interface Search {

    /**
     * the reachability between s and v
     *
     * @param v
     * @return
     */
    boolean isReachable(int v);

    /**
     * how many vertices can be reached from s
     */
    int count();
}
