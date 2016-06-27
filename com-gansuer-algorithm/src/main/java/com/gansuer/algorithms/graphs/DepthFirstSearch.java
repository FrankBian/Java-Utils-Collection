package com.gansuer.algorithms.graphs;

/**
 * Created by Frank on 6/8/16.
 */
public class DepthFirstSearch extends Search {


    public DepthFirstSearch(Graph graph, int root) {
        if (graph == null) throw new NullPointerException("graph is NULL");
        this.vertices = graph.V();
        if (root < 0 || root >= vertices)
            throw new IllegalArgumentException("root is out of bounds, max is : " + vertices);
        this.marked = new boolean[vertices];
        search(graph, root);
    }


    private void depthFirstSearch(Graph graph, int target) {
        count++;
        marked[target] = true;
        for (int item : graph.adj(target)) {
            if (!marked[item]) {
                depthFirstSearch(graph, item);
            }
        }
    }
    /**
     * DFS or BFS
     *
     * @param graph
     */
    @Override
    protected void search(Graph graph, int v) {
        depthFirstSearch(graph, v);
    }
}
