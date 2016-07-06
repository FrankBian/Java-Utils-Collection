package com.gansuer.algorithms.graphs.undirected;

import com.gansuer.algorithms.graphs.Graph;

/**
 * Created by Frank on 6/28/16.
 */
public class ConnectedComponent {

    private boolean[] marked;
    private int[] ccs; // specify the cc id of every vertices
    private int count;
    private int[] size;

    public ConnectedComponent(Graph graph) {
        int vertices = graph.getVertices();
        marked = new boolean[vertices];
        ccs = new int[vertices];
        size = new int[vertices];
        init(graph);
    }

    private void init(Graph graph) {
        for (int i = 0; i < marked.length; i++) {
            if (!marked[i]) {
                count++;
                dfs(graph, i);
            }
        }
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        ccs[v] = count;
        size[count] = size[count] + 1;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph, w);
            }
        }
    }

    /**
     * are v and w connected
     *
     * @param v
     * @param w
     * @return
     */
    public boolean isConnected(int v, int w) {
        return ccs[v] == ccs[w];
    }

    /**
     * number of connected components
     *
     * @return
     */
    public int count() {
        return count;
    }

    /**
     * component identifier for v (between 0 and count() -1)
     *
     * @param v
     * @return
     */
    public int id(int v) {
        return ccs[v] - 1;
    }

    /**
     * return the number of vertices in the connected component containing this vertex v
     * @param v
     * @return
     */
    public int size(int v){
        return size[ccs[v]];
    }
}
