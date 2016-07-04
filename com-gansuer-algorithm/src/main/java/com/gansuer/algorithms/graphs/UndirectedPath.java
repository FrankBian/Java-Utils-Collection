package com.gansuer.algorithms.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Frank on 6/8/16.
 */
public abstract class UndirectedPath implements Paths{

    // marked[v] = is there an s-v path
    protected boolean[] marked;
    // edgeTo[v] = previous edge between s-v
    protected int[] edgeTo;
    // the specified vertices
    protected int s;
    // the vertices number
    protected int vertices;

    /**
     * is there a path from root to target
     *
     * @param target
     * @return
     */
    public boolean hasPathTo(int target) {
        verifyVertex(target);
        return marked[target];
    }

    /**
     * path form root to target; null if no such path
     *
     * @param target
     * @return
     */
    public Iterable<Integer> pathTo(int target) {
        if (!hasPathTo(target)) return null;
        List<Integer> paths = new ArrayList<>();
        if (target != s) {
            paths.add(target);
        }
        for (int x = edgeTo[target]; x != s; x = edgeTo[x]) {
            paths.add(x);
        }
        paths.add(s);
        Collections.reverse(paths);
        return paths;
    }

    /**
     * DFS or BFS
     */
    protected abstract void init(Graph graph);

    protected void verifyVertex(int v) {
        if (v >= 0 && v < vertices) return;
        throw new IllegalArgumentException("source is out of bound, the number of vertices is" + " :" + vertices);
    }
}
