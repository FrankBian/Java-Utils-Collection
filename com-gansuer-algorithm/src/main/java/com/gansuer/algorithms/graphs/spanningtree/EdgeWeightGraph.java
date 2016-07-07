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
        for (int i = 0; i < vertices; i++) {
            adjs[i] = new ArrayList<>();
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

    /**
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        for (List<Edge> list : adjs) {
            stringBuilder.append(index).append(" : ");
            for (Edge edge : list) {
                stringBuilder.append(edge.other(index)).append(" - ")
                        .append(edge.getWeight()).append(" , ");
            }
            stringBuilder.append("\n");
            index++;
        }
        return stringBuilder.toString();
    }
}
