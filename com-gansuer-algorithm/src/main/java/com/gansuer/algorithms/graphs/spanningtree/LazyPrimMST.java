package com.gansuer.algorithms.graphs.spanningtree;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Frank on 7/7/16.
 */
public class LazyPrimMST {


    private static final double FLOATING_POINT_EPSILON = 1E-12;

    private double weight; // total weight of MST
    private Queue<Edge> mst; // edges int the MST
    private boolean[] marked; // marked[v] = true if v on tree
    private PriorityQueue<Edge> crossingEdgePQ; // edges with one endpoint in tree

    public LazyPrimMST(EdgeWeightGraph graph) {
        if (graph == null) throw new IllegalArgumentException("graph is null");
        this.mst = new LinkedList<>();
        this.marked = new boolean[graph.getVertices()];
        this.crossingEdgePQ = new PriorityQueue<>();
        init(graph);
    }

    private void init(EdgeWeightGraph graph) {
        for (int v = 0; v < graph.getVertices(); v++) {
            if (!marked[v]) prim(graph, v);
        }
    }

    private void prim(EdgeWeightGraph graph, int v) {
        scan(graph, v);
        while (!crossingEdgePQ.isEmpty()) {
            Edge edge = crossingEdgePQ.poll();
            int vx = edge.either(), w = edge.other(vx);
            assert marked[vx] || marked[w];
            if (marked[vx] && marked[w]) continue;
            mst.offer(edge);
            weight += edge.getWeight();
            if (!marked[vx]) scan(graph, vx);
            if (!marked[w]) scan(graph, w);
        }
    }

    private void scan(EdgeWeightGraph graph, int v) {
        assert !marked[v];
        marked[v] = true;
        for (Edge e : graph.adj(v)) {
            if (!marked[e.other(v)]) crossingEdgePQ.offer(e);
        }
    }

    public double getWeight(){
        return weight;
    }

    public Iterable<Edge> getEdges(){
        return mst;
    }
}
