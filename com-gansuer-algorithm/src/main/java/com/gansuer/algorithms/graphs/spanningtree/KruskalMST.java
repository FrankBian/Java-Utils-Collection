package com.gansuer.algorithms.graphs.spanningtree;

import com.gansuer.algorithms.problem.unionFind.QuickUnion;
import com.gansuer.algorithms.problem.unionFind.UF;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Frank on 7/19/16.
 */
public class KruskalMST {

    private List<Edge> edges;
    private int weight;


    public KruskalMST(EdgeWeightGraph graph) {
        if (graph == null) throw new IllegalArgumentException("graph is null");
        int vertices = graph.getVertices();
        Set<Edge> edgeSet = graph.getOrderedEdgeSet();
        edges = new ArrayList<>();
        UF uf = new QuickUnion(vertices);
        Iterator<Edge> iterator = edgeSet.iterator();

        while (edges.size() < vertices -1 && iterator.hasNext()) {
            Edge edge = iterator.next();
            int v = edge.either(), w = edge.other(v);
            if (!uf.connected(v,w)){
                uf.union(v,w);
                edges.add(edge);
                weight += edge.getWeight();
            }
            iterator.remove();
        }
    }



    public List<Edge> getEdges() {
        return edges;
    }

    public int getWeight() {
        return weight;
    }
}
