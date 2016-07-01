package com.gansuer.algorithms.graphs;

/**
 * Created by Frank on 7/1/16.
 */
public abstract class DirectedSearch implements Search {

    private int source;
    private boolean[] marked;
    private int count;
    private Digraph digraph;
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

    abstract void init(Graph graph);

}
