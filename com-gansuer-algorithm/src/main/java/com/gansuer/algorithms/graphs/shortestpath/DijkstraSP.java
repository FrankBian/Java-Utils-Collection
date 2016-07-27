package com.gansuer.algorithms.graphs.shortestpath;

import com.gansuer.algorithms.sort.queue.IndexMinPQ;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Frank on 7/27/16.
 */
public class DijkstraSP {

    private double[] distTo;    // distTo[v] = distance of shortest s->v path
    private DirectedEdge[] edgeTo;   // edgeTo[v] = last edge on shortest s->v path
    private IndexMinPQ<Double> pq; // priority queue of vertices

    /**
     * Computes a shortest-paths-tree from the source vertex s to every other reachable vertices
     * in the edge-weight-digraph
     *
     * @param digraph
     * @param s
     */
    public DijkstraSP(EdgeWeightDigraph digraph, int s) {
        for (DirectedEdge edge : digraph.getEdgeList()) {
            if (edge.getWeight() < 0)
                throw new IllegalArgumentException("edge(" + edge + ") has negative weight");
        }

        distTo = new double[digraph.getVertices()];
        edgeTo = new DirectedEdge[digraph.getVertices()];
        for (int v = 0; v < digraph.getVertices(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;

        //relax vertices in order of distance from s
        pq = new IndexMinPQ<>(digraph.getVertices());
        pq.insert(s, distTo[s]);
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            digraph.adj(v).forEach(this::relax);
        }

        assert check(digraph, s);
    }

    //relax edge e and update pq if changed
    private void relax(DirectedEdge edge) {
        int v = edge.getFrom(), w = edge.getTo();
        if (distTo[w] > distTo[v] + edge.getWeight()) {
            distTo[w] = distTo[v] + edge.getWeight();
            edgeTo[w] = edge;
            if (pq.contains(w)) pq.decreaseKey(w, distTo[w]);
            else pq.insert(w, distTo[w]);
        }
    }

    /**
     * returns the length of a shortest path from source <tt>s</tt> to vertex <tt>v</tt>
     *
     * @param v the destination vertex
     * @return the length of a shortest path from the source vertex <tt>s</tt> to vertex
     * <tt>v</tt>; <tt>Double.POSITIVE_INFINITE</tt> if no such path
     */
    public double distTo(int v) {
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public List<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        List<DirectedEdge> res = new LinkedList<>();
        for (DirectedEdge edge = edgeTo[v]; edge != null; edge = edgeTo[edge.getFrom()])
            res.add(edge);
        Collections.reverse(res);
        return res;
    }

    private boolean check(EdgeWeightDigraph digraph, int s) {

        //check that edge weight are non-negative
        if (digraph.getEdgeList().stream().filter(item -> item.getWeight() < 0).count() > 0) {
            System.err.println("negative edge weight detected ");
            return false;
        }
        //check that distTo[v] and edgeTo[v] are consistent
        if (distTo[s] != 0.0 || edgeTo[s] != null) {
            System.err.println("distTo[s] and edgeTo[s] inconsistent");
            return false;
        }

        for (int v = 0; v < digraph.getVertices(); v++) {
            if (v == s) continue;
            if (edgeTo[v] == null && distTo[v] != Double.POSITIVE_INFINITY) {
                System.err.println("distTo[v] and edgeTo[v] inconsistent : v =" + v);
                return false;
            }
        }

        //check that all edges e= v->w satisfy distTo[w] <= distTo[v] + e.getWeight()
        for (int v = 0; v < digraph.getVertices(); v++) {
            for (DirectedEdge edge : digraph.adj(v)) {
                int w = edge.getTo();
                if (distTo[w] > distTo[v] + edge.getWeight()) {
                    System.err.println("edge " + edge + " not relaxed");
                    return false;
                }
            }
        }

        for (int w = 0; w > digraph.getVertices(); w++) {
            if (edgeTo[w] == null) continue;
            DirectedEdge edge = edgeTo[w];
            int v = edge.getFrom();
            if (w != edge.getTo()) return false;
            if (distTo[v] + edge.getWeight() != distTo[w]) {
                System.err.println("edge " + edge + " on shortest path not tight");
                return false;
            }
        }

        return true;
    }
}
