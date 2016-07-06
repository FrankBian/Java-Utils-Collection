package com.gansuer.algorithms.graphs.directed;

/**
 * compute topological ordering of a DAG or EdgeWeighted DAG
 * Runs in O(E+V) time
 * <p>
 * Created by Frank on 7/5/16.
 */
public class Topological {

    private Iterable<Integer> order;
    private int[] rank;

    public Topological(Digraph digraph) {
        DirectedCycle cycle = new DirectedCycle(digraph);
        if (cycle.hasCycle()) return;
        DepthFirstOrder depthFirstOrder = new DepthFirstOrder(digraph);
        order = depthFirstOrder.reversePost();
        int i = 0;
        rank = new int[digraph.getVertices()];
        for (int item : order) {
            rank[item] = i++;
        }
    }

    public Iterable<Integer> getOrder() {
        return order;
    }

    public boolean hasOrder() {
        return order != null;
    }

    public int rank(int v) {
        validateVertex(v);
        if (hasOrder()) return rank[v];
        else return -1;
    }

    private void validateVertex(int v) {
        int V = rank.length;
        if (v < 0 || v >= V)
            throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V - 1));
    }
}
