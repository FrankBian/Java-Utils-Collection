package com.gansuer.algorithms.graphs;

/**
 * Created by Frank on 6/8/16.
 */
public class DepthFirstUndirectedPath extends UndirectedPath {

    public DepthFirstUndirectedPath(Graph graph, int root) {
        if (graph == null) throw new NullPointerException("graph is NULL");
        this.vertices = graph.V();
        verifyVertex(root);
        this.marked = new boolean[this.vertices];
        this.edgeTo = new int[this.vertices];
        this.s = root;
        init(graph);
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
