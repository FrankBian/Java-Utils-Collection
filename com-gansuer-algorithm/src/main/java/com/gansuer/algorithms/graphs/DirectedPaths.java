package com.gansuer.algorithms.graphs;

/**
 * Created by Frank on 7/3/2016.
 */
public abstract class DirectedPaths implements Paths{

    protected Digraph digraph;
    protected boolean[] marked;
    protected int source;
    @Override
    public boolean hasPathTo(int target) {
        return false;
    }

    @Override
    public Iterable<Integer> pathTo(int target) {
        return null;
    }
    protected abstract void init(Digraph digraph);
}
