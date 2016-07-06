package com.gansuer.algorithms.graphs.undirected;

import com.gansuer.algorithms.graphs.Graph;

/**
 * Created by Frank on 6/8/16.
 */
public class DepthFirstUndirectedSearch extends UndirectedSearch {


    public DepthFirstUndirectedSearch(Graph graph, int root) {
        if (graph == null) throw new NullPointerException("graph is NULL");
        this.vertices = graph.getVertices();
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
