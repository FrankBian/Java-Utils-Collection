package com.gansuer.algorithms.graphs;

import java.util.*;

/**
 * Created by Frank on 7/4/2016.
 */
public class DirectedCycle {

    private Stack<Integer> stack;
    private boolean hasCycle = false;
    private List<Integer> cycle;

    public DirectedCycle(Digraph digraph) {
        if (digraph == null) throw new IllegalArgumentException("graph is null");
        this.stack = new Stack<>();
        for (int v = 0; v < digraph.getVertices(); v++) {
            if (!hasCycle) {
                dfs(digraph, v);
            }
        }
    }

    private void dfs(Digraph digraph, int v) {
        if (hasCycle) return;
        stack.push(v);
        for (int w : digraph.adj(v)) {
            if (hasCycle) return;
            if (stack.contains(w)) {
                hasCycle = true;
                cycle = new ArrayList<>();
                cycle.add(w);
                for (int cur = stack.pop(); cur != w; cur = stack.pop()) {
                    cycle.add(cur);
                }
                cycle.add(w);
                Collections.reverse(cycle);
                return;
            }
            dfs(digraph, w);
        }
        if (!stack.isEmpty()) stack.pop();
    }

    public boolean hasCycle() {
        return hasCycle;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }

    private boolean check() {
        if (hasCycle()) {
            int first = -1, last = -1;
            for (int cur : cycle()) {
                if (first == -1) first = cur;
                last = cur;
            }
            if (first != last) return false;
        }
        return true;
    }
}
