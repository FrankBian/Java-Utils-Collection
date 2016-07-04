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
        this.vertices = graph.getVertices();
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
     */
    private void bfs(Graph graph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(this.s);
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
        edgeTo[s] = s;
        bfs(graph);
    }

    /**
     * the shortest distance from s to target
     *
     * @param target
     * @return
     */
    public int distanceTo(int target) {
        if (!hasPathTo(target)) return -1;
        return distanceTo[target];
    }
}
