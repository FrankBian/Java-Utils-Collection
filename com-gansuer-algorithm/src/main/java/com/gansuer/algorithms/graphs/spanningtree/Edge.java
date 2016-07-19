package com.gansuer.algorithms.graphs.spanningtree;

/**
 * Created by Frank on 7/6/16.
 */
public final class Edge implements Comparable<Edge> {

    private final int v;
    private final int w;
    private final double weight;

    public Edge(int v, int w, double weight) {
        if (v < 0)
            throw new IndexOutOfBoundsException("Vertex name must be a non-negative integer");
        if (w < 0)
            throw new IndexOutOfBoundsException("Vertex name must be a non-negative integer");
        if (Double.isNaN(weight))
            throw new IllegalArgumentException("Weight is NaN");
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge that) {
        return Double.compare(this.weight, that.getWeight());
    }

    /**
     * either endpoint of this edge
     *
     * @return
     */
    public int either() {
        return v;
    }

    /**
     * return the endpoint of this edge that is different from the given vertex
     *
     * @param vertex
     * @return
     */
    public int other(int vertex) {
        if (vertex == v) return w;
        else if (vertex == w) return v;
        else
            throw new IllegalArgumentException("Illegal Endpoint for this edge:(" + v + "," + w + ")");
    }

    public double getWeight() {
        return weight;
    }

    public String toString() {
        return String.format("%d-%d %.5f", v, w, weight);
    }
}
