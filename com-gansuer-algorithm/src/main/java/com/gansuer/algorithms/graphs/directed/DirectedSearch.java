package com.gansuer.algorithms.graphs.directed;

import com.gansuer.algorithms.graphs.Search;
import com.gansuer.algorithms.graphs.directed.Digraph;

/**
 * Created by Frank on 7/1/16.
 */
public abstract class DirectedSearch implements Search {

    protected int source;
    protected boolean[] marked;
    protected int count;
    protected Digraph digraph;
    /**
     * the reachability between s and v
     *
     * @param v
     * @return
     */
    @Override
    public boolean isReachable(int v) {
        digraph.verifyVertex(v);
        return marked[v];
    }

    /**
     * how many vertices can be reached from s
     */
    @Override
    public int count() {
        return count;
    }

    protected abstract void init(Digraph digraph);

}
