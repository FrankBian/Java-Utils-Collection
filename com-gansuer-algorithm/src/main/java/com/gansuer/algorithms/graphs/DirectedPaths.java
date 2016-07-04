package com.gansuer.algorithms.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Frank on 7/3/2016.
 */
public abstract class DirectedPaths implements Paths {

    protected Digraph digraph;
    protected boolean[] marked;
    protected int[] edgeTo;
    protected int source;

    @Override
    public boolean hasPathTo(int target) {
        digraph.verifyVertex(target);
        return marked[target];
    }

    @Override
    public Iterable<Integer> pathTo(int target) {
        if (!hasPathTo(target)) return new ArrayList<>(); // return null or empty list
        List<Integer> res = new ArrayList<>();
        if (target != source) {
            res.add(target);
        }
        for (int x = edgeTo[target]; x != source; x = edgeTo[x]) {
            res.add(x);
        }
        res.add(source);
        Collections.reverse(res);
        return res;
    }

    protected abstract void init(Digraph digraph);
}
