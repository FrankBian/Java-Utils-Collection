package com.gansuer.algorithms.graphs.spanningtree;

import com.gansuer.algorithms.problem.unionFind.UF;
import com.gansuer.algorithms.problem.unionFind.WeightQuickUnion;
import com.gansuer.algorithms.sort.queue.IndexMinPQ;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Frank on 7/8/16.
 */
public class PrimMST {

    private static final double FLOATING_POINT_EPSILON = 1E-12;
    private Edge[] edgeTo; // edgeTo[v] = shortest eged from tree vertex to non-tree vertex
    private double[] distTo; // distTo[v] = weight of shortest such edge
    private boolean[] marked; // marked[v] = true if v on tree, false otherwise
    private IndexMinPQ<Double> pq;

    public PrimMST(EdgeWeightGraph graph) {
        if (graph == null) throw new IllegalArgumentException("graph is null");
        int v = graph.getVertices();
        edgeTo = new Edge[v];
        distTo = new double[v];
        marked = new boolean[v];
        pq = new IndexMinPQ<>(v);

        for (int i = 0; i < v; i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }

        // run from each vertex to find minimum spanning tree
        for (int i = 0; i < v; i++) {
            if (!marked[v]) prim(graph, i);
        }

    }

    private void prim(EdgeWeightGraph graph, int v) {
        distTo[v] = 0.0;
        pq.insert(v, distTo[v]);
        while (!pq.isEmpty()) {
            int t = pq.delMin();
            scan(graph, t);
        }
    }

    private void scan(EdgeWeightGraph graph, int v) {
        marked[v] = true;
        for (Edge e : graph.adj(v)) {
            int w = e.other(v);
            if (marked[w]) continue; // v-w is obsolete edge
            if (e.getWeight() < distTo[w]) {
                distTo[w] = e.getWeight();
                edgeTo[w] = e;
                if (pq.contains(w)) pq.decreaseKey(w, distTo[w]);
                else pq.insert(w, distTo[w]);
            }
        }
    }

    public Iterable<Edge> edges() {
        Queue<Edge> mst = new LinkedList<>();
        for (int v = 0; v < edgeTo.length; v++) {
            Edge edge = edgeTo[v];
            if (edge != null) {
                mst.offer(edge);
            }
        }
        return mst;
    }

    public double getWeight() {
        double weight = 0.0;
        for (Edge edge : edges()) {
            weight += edge.getWeight();
        }
        return weight;
    }

    private boolean check(EdgeWeightGraph graph) {
        double totalWeight = 0.0;

        //check weight
        for (Edge e : edges()) {
            totalWeight += e.getWeight();
        }

        assert Math.abs(totalWeight - getWeight()) < FLOATING_POINT_EPSILON;

        UF uf = new WeightQuickUnion(graph.getVertices());
        for (Edge edge : edges()) {
            int v = edge.either(), w = edge.other(v);
            if (uf.connected(v, w)) {
                System.err.println("Not a forest");
                return false;
            }
            uf.union(v, w);
        }

        //check that it is a spanning forest
        for (Edge edge : graph.getEdgeList()) {
            int v = edge.either(), w = edge.other(v);
            if (!uf.connected(v, w)) {
                System.err.println("not a spanning forest");
                return false;
            }
        }

        // check that it is a minimal spanning forest (cut optimality conditions)
        for (Edge e : edges()) {
            // all edges in MST except e
            uf = new WeightQuickUnion(graph.getVertices());
            for (Edge edge : edges()) {
                int x = edge.either(), y = edge.other(x);
                if (edge != e) uf.union(x, y);
            }

            // check that e is min weight edge in crossing cut
            for (Edge edge : graph.getEdgeList()) {
                int x = edge.either(), y = edge.other(x);
                if (!uf.connected(x, y)) {
                    if (edge.getWeight() < e.getWeight()) {
                        System.err.println("Edge " + edge + " violates cut optimality conditions");
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
