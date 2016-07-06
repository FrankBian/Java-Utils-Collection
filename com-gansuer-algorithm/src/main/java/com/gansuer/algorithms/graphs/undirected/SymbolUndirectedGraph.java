package com.gansuer.algorithms.graphs.undirected;

import com.gansuer.algorithms.graphs.Graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Frank on 7/5/16.
 */
public class SymbolUndirectedGraph {

    private Map<String, Integer> keyIndexMap;
    private String[] indexKeyMap;
    private int index;
    private UndirectedGraph graph;

    public SymbolUndirectedGraph(List<String> list, String separator) {
        if (list == null || list.size() == 0) throw new IllegalArgumentException("list is empty");
        this.keyIndexMap = new HashMap<>();
        list.forEach(item -> {
            String[] strings = item.split(separator);
            for (String str : strings) {
                if (!keyIndexMap.containsKey(str)) keyIndexMap.put(str, index++);
            }
        });
        this.indexKeyMap = new String[keyIndexMap.size()];
        keyIndexMap.forEach((key, value) -> indexKeyMap[value] = key);
        this.graph = new AdjacencyListUndigraph(index);
        list.forEach(item -> {
            String[] strings = item.split(separator);
            int v = keyIndexMap.get(strings[0]);
            for (int i = 1; i < strings.length; i++) {
                graph.addEdge(v, keyIndexMap.get(strings[i]));
            }
        });
    }

    /**
     * is key a vertex?
     *
     * @param key
     * @return
     */
    public boolean contains(String key) {
        return keyIndexMap.containsKey(key);
    }

    /**
     * index associated with key
     *
     * @param key
     * @return
     */
    public int getIndex(String key) {
        if (!contains(key)) return -1;
        return keyIndexMap.get(key);
    }

    /**
     * key associated with index v
     *
     * @param v
     * @return
     */
    public String getName(int v) {
        return indexKeyMap[v];
    }

    public Graph getGraph() {
        return graph;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int v = 0; v < graph.getVertices(); v++) {
            sb.append(getName(v)).append(" : ");
            for (int w : graph.adj(v)) {
                sb.append(getName(w)).append("  ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
