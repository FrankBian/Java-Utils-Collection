package com.gansuer.algorithms.graphs;

/**
 * Created by Frank on 7/2/2016.
 */
public class DepthFirstDirectedSearch extends DirectedSearch {

    public DepthFirstDirectedSearch(Digraph graph, int source) {
        if (graph == null) throw new NullPointerException("graph is NULL");
        graph.verifyVertex(source);
        this.source = source;
        this.digraph = graph;
        this.marked = new boolean[digraph.getVertices()];
        init(graph);
    }

    @Override
    protected void init(Digraph graph) {
        dfs(graph,this.source);
    }

    private void dfs(Digraph digraph, int v){
        marked[v] = true;
        count++;  // it's reachable to itself
        for (int w : digraph.adj(v)){
            if (!marked[w]){
                dfs(digraph,w);
            }
        }
    }
}
