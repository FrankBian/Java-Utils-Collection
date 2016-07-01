package com.gansuer.algorithms.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Frank on 6/24/16.
 */
public class BreadthFirstUndirectedPath extends UndirectedPath {

    private int[] distanceTo;

    public BreadthFirstUndirectedPath(Graph graph, int source) {
        if (graph == null) throw new NullPointerException("graph is null");
        this.vertices = graph.V();
        verifyVertex(source);
        this.s = source;
        this.edgeTo = new int[vertices];
        this.marked = new boolean[vertices];
        this.distanceTo = new int[vertices];
        init(graph);

    }

    /**
     * BFS
     *
     * @param graph
     * @param s
     */
    private void bfs(Graph graph, int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        for (int i = 0; i < distanceTo.length; i++) {
            distanceTo[i] = Integer.MAX_VALUE;
        }
        distanceTo[s] = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            marked[cur] = true;
            for (int adj : graph.adj(cur)) {
                if (!marked[adj]) {
                    marked[adj] = true;
                    edgeTo[adj] = cur;
                    distanceTo[adj] = distanceTo[cur] + 1;
                    queue.offer(adj);
                }
            }
        }
    }

    /**
     * DFS or BFS
     *
     * @param graph
     */
    @Override
    protected void init(Graph graph) {
        bfs(graph, s);
    }

    /**
     * the shortest distance from s to target
     *
     * @param target
     * @return
     */
    public int distanceTo(int target) {
        verifyVertex(target);
        return distanceTo[target];
    }
}
