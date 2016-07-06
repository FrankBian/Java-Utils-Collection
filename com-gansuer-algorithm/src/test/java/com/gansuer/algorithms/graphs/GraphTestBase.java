package com.gansuer.algorithms.graphs;

import com.gansuer.algorithms.graphs.undirected.AdjacencyListUndigraph;
import com.gansuer.common.util.FileUtils;

import java.util.List;

/**
 * Created by Frank on 6/28/16.
 */
public class GraphTestBase {

    protected AdjacencyListUndigraph graph;
    private final String defaultFileName = "graph/tinyG.txt";
    private List<String> lines;
    protected int vertices = 0 , edge = 0;

    public void init(String fileName) throws Exception {
        String path = getClass().getClassLoader()
                .getResource(fileName == null ? defaultFileName : fileName).getFile();
        lines = FileUtils.readFile(path);
        vertices = Integer.parseInt(lines.get(0));
        edge = Integer.parseInt(lines.get(1));

        graph = new AdjacencyListUndigraph(vertices);
        for (int i = 2; i < lines.size(); i++) {
            String[] token = lines.get(i).split(" ");
            graph.addEdge(Integer.parseInt(token[0]), Integer.parseInt(token[1]));
        }
        System.out.println(graph.toString());
        System.out.println("------------- graph end -------------");
    }
}
