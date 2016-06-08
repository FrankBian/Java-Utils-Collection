package com.gansuer.algorithms.graphs;

import java.util.Stack;

/**
 * Created by Frank on 6/8/16.
 */
public class DepthFirstPaths implements Paths{

    private boolean[] marked;
    private int[] edgeTo;
    private final int root;

    public DepthFirstPaths(Graph graph, int root) {
        if (graph == null) throw new NullPointerException("graph is NULL");
        int vertices = graph.V();
        if (root < 0 || root >= vertices) throw new IllegalArgumentException("root is out of " +
                "bounds, max is : " + vertices);
        this.marked = new boolean[vertices];
        this.edgeTo = new int[vertices];
        this.root = root;
        dfs(graph, root);
    }

    public boolean hasPathTo(int target) {
        return marked[target];
    }

    public Iterable<Integer> pathTo(int target) {
        if (!hasPathTo(target)) return null;
        Stack<Integer> stack = new Stack<>();
        for (int x = target; x != root; x = edgeTo[x]) {
            stack.push(x);
        }
        stack.push(root);
        return stack;
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
