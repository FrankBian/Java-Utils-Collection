package com.gansuer.algorithms.graphs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Frank on 7/5/16.
 */
public class SymbolDirectedGraph{

    private Map<String, Integer> keyIndexMap;
    private int count;
    private String[] indexKeyMap;
    private Digraph digraph;
    private String separator;

    public SymbolDirectedGraph(List<String> list, String separator) {
        if (list == null || list.isEmpty()) throw new IllegalArgumentException("list is empty");
        if (separator == null) throw new IllegalArgumentException("separator is null");
        this.keyIndexMap = new HashMap<>();
        this.separator = separator;
        list.forEach(item -> {
            String[] strs = item.split(separator);
            for (String str : strs) {
                if (!keyIndexMap.containsKey(str)) keyIndexMap.put(str, count++);
            }
        });
        this.indexKeyMap = new String[count];
        keyIndexMap.forEach((key, val) -> indexKeyMap[val] = key);
        this.digraph = new AdjacencyListDigraph(count);
        list.forEach(item -> {
            String[] strs = item.split(separator);
            int v = keyIndexMap.get(strs[0]);
            for (int i = 1; i < strs.length; i++) {
                digraph.addEdge(v, keyIndexMap.get(strs[i]));
            }
        });
    }

    public boolean contains(String key) {
        return keyIndexMap.containsKey(key);
    }

    public int getIndex(String key) {
        if (contains(key)) return keyIndexMap.get(key);
        return -1;
    }

    public String getName(int index) {
        return indexKeyMap[index];
    }

    public Digraph getDigraph() {
        return digraph;
    }

    /**
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int v = 0; v < digraph.getVertices(); v++) {
            stringBuilder.append(getName(v)).append(" : ");
            for (int w : digraph.adj(v)) {
                stringBuilder.append(getName(w)).append(" "+ separator +" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
