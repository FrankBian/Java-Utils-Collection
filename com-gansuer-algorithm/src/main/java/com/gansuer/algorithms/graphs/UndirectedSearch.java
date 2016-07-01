package com.gansuer.algorithms.graphs;

/**
 * Created by Frank on 6/24/16.
 */
public abstract class UndirectedSearch implements Search{

    protected boolean[] marked;
    protected int count;
    protected int vertices;
    /**
     * is v connected to s
     *
     * @param v
     * @return
     */
    public boolean isReachable(int v){
        verifyVertex(v);
        return marked[v];
    }

    /**
     * how many vertices are connected to s
     *
     * @return
     */
    public int count(){
        return count;
    }

    /**
     * DFS or BFS
     */
    protected abstract void search(Graph graph, int v);

    protected void verifyVertex(int v) {
        if (v >= 0 && v < vertices) return;
        throw new IllegalArgumentException("source is out of bound, the number of vertices is" + " :" + vertices);
    }
}
