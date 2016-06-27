package com.gansuer.algorithms.graphs;

/**
 * Created by Frank on 6/8/16.
 */
public class DepthFirstSearch implements Search{

    private boolean[] marks;
    private int count;

    public DepthFirstSearch(Graph graph, int root) {
        if (graph == null) throw new NullPointerException("graph is NULL");
        int vertices = graph.V();
        if (root < 0 || root >= vertices)
            throw new IllegalArgumentException("root is out of bounds, max is : " + vertices);
        this.marks = new boolean[vertices];
        depthFirstSearch(graph, root);
    }

    public boolean isConnected(int target) {
        return marks[target];
    }

    /**
     * how many vertices are connected to s
     *
     * @return
     */
    public int count() {
        return count;
    }

    private void depthFirstSearch(Graph graph, int target) {
        count++;
        marks[target] = true;
        for (int item : graph.adj(target)) {
            if (!marks[item]) {
                depthFirstSearch(graph, item);
            }
        }
    }
}
