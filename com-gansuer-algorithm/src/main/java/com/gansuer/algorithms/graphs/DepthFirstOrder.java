package com.gansuer.algorithms.graphs;

import java.util.*;

/**
 * Compute pre-order or post-order for a digraph or edge-weighted digraph
 * Runs in O(E+V) time
 * <p>
 * Created by Frank on 7/5/16.
 */
public class DepthFirstOrder {


    private Queue<Integer> preOrder;
    private Queue<Integer> postOrder;
    private boolean[] marked;
    private Digraph digraph;

    private int[] preNumber;
    private int[] postNumber;
    private int preCount;
    private int postCount;

    public DepthFirstOrder(Digraph digraph) {
        if (digraph == null) throw new IllegalArgumentException("digraph is null");
        this.marked = new boolean[digraph.getVertices()];
        this.preOrder = new LinkedList<>();
        this.postOrder = new LinkedList<>();
        this.preNumber = new int[digraph.getVertices()];
        this.postNumber = new int[digraph.getVertices()];
        this.digraph = digraph;
        for (int v = 0; v < digraph.getVertices(); v++) {
            if (!marked[v]) dfs(digraph, v);
        }
    }

    /**
     * compute
     * @param digraph
     * @param v
     */
    private void dfs(Digraph digraph, int v) {
        marked[v] = true;
        preNumber[v] = preCount++;
        preOrder.offer(v);
        for (int w : digraph.adj(v)) {
            if (!marked[w]) dfs(digraph, w);
        }
        postOrder.offer(v);
        postNumber[v] = postCount++;
    }

    public Iterable<Integer> preOrder() {
        return preOrder;
    }

    /**
     * return the preOrder Number of vertex
     *
     * @param v
     * @return
     */
    public int pre(int v) {
        digraph.verifyVertex(v);
        return preNumber[v];
    }

    public Iterable<Integer> postOrder() {
        return postOrder;
    }

    /**
     * return the postOrder number of vertex
     *
     * @param v
     * @return
     */
    public int post(int v) {
        digraph.verifyVertex(v);
        return postNumber[v];
    }


    public Iterable<Integer> reversePost() {
        Stack<Integer> stack = new Stack<>();
        postOrder.forEach(item -> stack.push(item));
        List<Integer> res = new ArrayList<>();
        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }
}
