package com.gansuer.algorithms.graphs.shortestpath;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Frank on 7/19/16.
 */
public class EdgeWeightDigraph {

    private int vertices;
    private int edges;
    private Set<DirectedEdge>[] adjs;

    public EdgeWeightDigraph(int vertices) {
        this.vertices = vertices;
        this.adjs = new Set[vertices];
        for (int i = 0; i < vertices; i++) {
            adjs[i] = new HashSet<>();
        }
    }

    public int getVertices() {
        return vertices;
    }

    public int getEdges() {
        return edges;
    }

    public boolean addEdge(DirectedEdge edge) {
        if (edge == null) return false;
        adjs[edge.getFrom()].add(edge);
        edges++;
        return true;
    }

    public Set<DirectedEdge> adj(int v) {
        return adjs[v];
    }

    public List<DirectedEdge> getEdgeList() {
        List<DirectedEdge> edgeList = new ArrayList<>();
        for (int i = 0; i < adjs.length; i++) {
            edgeList.addAll(adjs[i]);
        }
        return edgeList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < vertices; i++) {
            stringBuilder.append(i).append(" : ");
            adjs[i].forEach(edge -> stringBuilder.append(edge.toString()).append(" "));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
