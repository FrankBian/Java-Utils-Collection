package com.gansuer.algorithms.graphs.directed;

/**
 * Created by Frank on 7/5/16.
 */
public class StrongConnectedComponent {

    private boolean[] marked;
    private int count;
    private int[] ids;

    public StrongConnectedComponent(Digraph digraph) {
        if (digraph == null) throw new IllegalArgumentException("graph is null");
        this.marked = new boolean[digraph.getVertices()];
        this.ids = new int[digraph.getVertices()];
        DepthFirstOrder depthFirstOrder = new DepthFirstOrder(digraph.reverse());
        for (int v : depthFirstOrder.reversePost()) {
            if (!marked[v]) {
                dfs(digraph, v);
                count++;
            }
        }
    }

    private void dfs(Digraph digraph, int v) {
        marked[v] = true;
        ids[v] = count;
        for (int w : digraph.adj(v)) {
            if (!marked[w]) dfs(digraph, w);
        }
    }

    /**
     * Are v and w strongly connected
     *
     * @param v
     * @param w
     * @return
     */
    public boolean isStronglyConnected(int v, int w) {
        return ids[v] == ids[w];
    }

    /**
     * number of strong components
     *
     * @return
     */
    public int count() {
        return count;
    }

    /**
     * component identifier for v
     *
     * @param v
     * @return
     */
    public int getComponentId(int v) {
        return ids[v];
    }
}
