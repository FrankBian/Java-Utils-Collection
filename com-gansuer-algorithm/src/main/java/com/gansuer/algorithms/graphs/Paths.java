package com.gansuer.algorithms.graphs;

/**
 * Created by Frank on 7/3/2016.
 */
public interface Paths {

    /**
     * is there a path from root to target
     *
     * @param target
     * @return
     */
    boolean hasPathTo(int target);

    /**
     * path form root to target; null if no such path
     *
     * @param target
     * @return
     */
    Iterable<Integer> pathTo(int target);
}
