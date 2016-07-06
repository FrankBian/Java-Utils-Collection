package com.gansuer.algorithms.graphs.spanningtree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Frank on 7/6/16.
 */
public class EdgeWeightGraph extends AbstractEdgeWeightGraph {

    private List<Edge>[] adjs;

    public EdgeWeightGraph(int vertices) {
        if (vertices < 0)
            throw new IllegalArgumentException("vertices must be a non-negative integer");
        this.vertices = vertices;
        this.adjs = new List[vertices];
        for (List<Edge> item : adjs) {
            item = new ArrayList<>();
        }
    }

    public Iterable<Edge> getEdgeList() {
        Set<Edge> res = new HashSet<>();
        for (List<Edge> item : adjs) {
            res.addAll(item);
        }
        return res;
    }

    /**
     * add edge to this graph
     *
     * @param edge
     */
    @Override
    public boolean addEdge(Edge edge) {
        if (edge == null) throw new NullPointerException("edge is null");
        int v = edge.either();
        int w = edge.other(v);
        validateVertices(v);
        validateVertices(w);
        adjs[v].add(edge);
        adjs[w].add(edge);
        return true;
    }

    /**
     * vertices adjacent to v
     *
     * @param v
     * @return
     */
    @Override
    public Iterable<Edge> adj(int v) {
        validateVertices(v);
        return adjs[v];
    }
}
