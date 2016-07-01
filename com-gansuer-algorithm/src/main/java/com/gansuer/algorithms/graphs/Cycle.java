package com.gansuer.algorithms.graphs;

/**
 * Cycle detection: Is a given graph acyclic
 *
 * Created by Frank on 6/28/16.
 */
public class Cycle {

    public Cycle(Graph g) {

    }

    private boolean hasSelfLoop(Graph g) {
        return false;
    }

    private boolean hasParallelEdges(Graph g) {
        return false;
    }

    public boolean hasCycle() {
        return false;
    }

    public Iterable<Integer> getCycle() {
        return null;
    }


}
