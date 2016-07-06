package com.gansuer.algorithms.graphs.directed;

/**
 * Created by Frank on 7/3/2016.
 */
public class DepthFirstDirectedPaths extends DirectedPaths {

    public DepthFirstDirectedPaths(Digraph digraph, int source) {
        if (digraph == null) throw new IllegalArgumentException("digraph is null");
        digraph.verifyVertex(source);
        this.source = source;
        this.marked = new boolean[digraph.getVertices()];
        this.edgeTo = new int[digraph.getVertices()];
        this.digraph = digraph;
        init(digraph);
    }

    @Override
    protected void init(Digraph digraph) {
        edgeTo[source] = source;
        dfs(digraph, source);
    }

    private void dfs(Digraph digraph, int v) {
        marked[v] = true;
        for (int w : digraph.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(digraph, w);
            }
        }
    }
}
