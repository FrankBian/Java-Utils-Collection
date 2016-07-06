package com.gansuer.algorithms.graphs.directed;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Frank on 7/4/16.
 */
public class BreadthFirstDirectedPaths extends DirectedPaths {

    private int[] distanceTo;

    public BreadthFirstDirectedPaths(Digraph digraph, int source) {
        if (digraph == null) throw new IllegalArgumentException("digraph is null");
        digraph.verifyVertex(source);
        this.source = source;
        this.marked = new boolean[digraph.getVertices()];
        this.edgeTo = new int[digraph.getVertices()];
        this.digraph = digraph;
        this.distanceTo = new int[digraph.getVertices()];
        init(digraph);
    }

    @Override
    protected void init(Digraph digraph) {
        edgeTo[source] = source;
        bfs(digraph);
    }

    private void bfs(Digraph digraph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            marked[source] = true;
            for (int adj : digraph.adj(cur)) {
                if (!marked[adj]) {
                    marked[adj] = true;
                    edgeTo[adj] = cur;
                    distanceTo[adj] = distanceTo[cur] + 1;
                    queue.offer(adj);
                }
            }
        }
    }

    public int distanceTo(int target) {
        if (!hasPathTo(target)) return -1;
        return distanceTo[target];
    }
}
