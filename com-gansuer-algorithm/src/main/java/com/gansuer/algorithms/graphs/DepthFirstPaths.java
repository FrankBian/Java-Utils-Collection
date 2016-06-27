package com.gansuer.algorithms.graphs;

/**
 * Created by Frank on 6/8/16.
 */
public class DepthFirstPaths extends Paths {

    public DepthFirstPaths(Graph graph, int root) {
        if (graph == null) throw new NullPointerException("graph is NULL");
        int vertices = graph.V();
        if (root < 0 || root >= vertices)
            throw new IllegalArgumentException("root is out of bounds, max is : " + vertices);
        this.marked = new boolean[vertices];
        this.edgeTo = new int[vertices];
        this.s = root;
    }

    /**
     * DFS or BFS
     */
    @Override
    public void init(Graph graph) {
        dfs(graph, s);
    }
    private void dfs(Graph graph, int target) {
        marked[target] = true;
        for (int item : graph.adj(target)) {
            if (!marked[item]) {
                edgeTo[item] = target;
                dfs(graph, item);
            }
        }
    }
}
