package com.gansuer.algorithms.graphs.spanningtree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Frank on 7/6/16.
 */
public class MST {

    private List<Edge> edges;
    private double weight;

    public MST(EdgeWeightGraph graph) {
        if (graph == null) throw new IllegalArgumentException("graph is null");
        int vertices = graph.getVertices();
        Set<Integer> ves = new HashSet<>();
        ves.add(0);
        this.edges = new ArrayList<>();
        while (ves.size() < vertices) {
            Edge edge = null;
            for (int v : ves) {
                for (Edge item : graph.adj(v)) {
                    if (ves.contains(item.other(v))) continue;
                    if (edge == null) edge = item;
                    else if (item.compareTo(edge) < 0) edge = item;
                }
            }
            if (edge != null) {
                edges.add(edge);
                weight += edge.getWeight();
                ves.add(edge.either());
                ves.add(edge.other(edge.either()));
            }
        }
    }

    /**
     * iterator of MST edge
     *
     * @return
     */
    public Iterable<Edge> getEdges() {
        return edges;
    }

    /**
     * weight of MST
     *
     * @return
     */
    public double getWeight() {
        return weight;
    }

}
