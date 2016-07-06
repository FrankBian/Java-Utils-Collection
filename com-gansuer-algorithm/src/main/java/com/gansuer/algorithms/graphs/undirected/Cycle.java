package com.gansuer.algorithms.graphs.undirected;

import com.gansuer.algorithms.graphs.Graph;

import java.util.Stack;

/**
 * Cycle detection: Is a given graph acyclic
 * TODO: to complete
 * <p>
 * Created by Frank on 6/28/16.
 */
public class Cycle {

    private Stack<Integer> cycle;
    private boolean[] marked;
    private int[] edgeTo;

    public Cycle(Graph graph) {
        if (graph == null) throw new IllegalArgumentException("graph is null");
        if (hasSelfLoop(graph)) return;
        if (hasParallelEdges(graph)) return;
        marked = new boolean[graph.getVertices()];
        edgeTo = new int[graph.getVertices()];
        for (int v = 0; v <graph.getVertices();v++){
            if (cycle == null && !marked[v]){
                dfs(graph,-1,v);
            }
        }
    }

    private boolean hasSelfLoop(Graph graph) {
        for (int v = 0; v < graph.getVertices(); v++) {
            for (int w : graph.adj(v)) {
                if (v == w) {
                    cycle = new Stack<>();
                    cycle.push(v);
                    cycle.push(v);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasParallelEdges(Graph graph) {
        marked = new boolean[graph.getVertices()];

        for (int v = 0; v < graph.getVertices(); v++) {
            for (int w : graph.adj(v)) {
                if (marked[w]) {
                    cycle = new Stack<>();
                    cycle.push(v);
                    cycle.push(w);
                    cycle.push(v);
                    return true;
                }
                marked[w] = true;
            }
            for (int w : graph.adj(v)) {
                marked[w] = false;
            }
        }
        return false;
    }

    public boolean hasCycle() {
        return this.cycle != null;
    }

    public Iterable<Integer> getCycle() {
        return cycle;
    }

    private void dfs(Graph graph, int v, int w) {
        marked[w] = true;
        for (int adj : graph.adj(w)){
            if (cycle != null) return;
            if (!marked[adj]){
                edgeTo[adj] = w;
                dfs(graph,w,adj);
            }else if (adj != v){
                cycle = new Stack<>();
                for (int x = w; x != adj; x = edgeTo[x]){
                    cycle.push(x);
                }
                cycle.push(adj);
                cycle.push(w);
            }
        }
    }

}
