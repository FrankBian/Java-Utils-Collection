package com.gansuer.algorithms.graphs.shortestpath;

/**
 * Created by Frank on 7/19/16.
 */
public final class DirectedEdge implements Comparable<DirectedEdge> {

    private final int from;
    private final int to;
    private final double weight;

    public DirectedEdge(int from, int to, double weight) {
        if (from < 0)
            throw new IndexOutOfBoundsException("Vertex name must be a non-negative integer");
        if (to < 0)
            throw new IndexOutOfBoundsException("Vertex name must be a non-negative integer");
        this.from = from;
        this.to = to;
        if (Double.isNaN(weight) || weight < 0)
            throw new IllegalArgumentException("weight must be positive(or zero) :" + weight);
        this.weight = weight;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public double getWeight() {
        return weight;
    }


    @Override
    public int compareTo(DirectedEdge that) {
        return Double.compare(this.weight, that.getWeight());
    }

    public String toString() {
        return from + " -> " + to + "(" + String.format("%5.2f", weight) + ")";
    }
}
