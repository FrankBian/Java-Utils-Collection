package com.gansuer.algorithms.graphs;

import com.gansuer.algorithms.graphs.directed.AdjacencyListDigraph;
import com.gansuer.algorithms.graphs.directed.Digraph;
import com.gansuer.common.util.FileUtils;
import com.gansuer.common.util.StringUtils;

import java.util.List;

/**
 * Created by Frank on 7/1/16.
 */
public class DigraphTestBase {


    protected Digraph digraph;
    private final String directedGraph = "graph/tinyDG.txt";
    private final String directedAcyclicGraph = "graph/tinyDAG.txt";
    private List<String> lines;
    protected int vertices = 0, edge = 0;

    public void init(boolean isDAG) throws Exception {
        String path = getClass().getClassLoader()
                .getResource(!isDAG?directedGraph : directedAcyclicGraph).getFile();
        lines = FileUtils.readFile(path);
        vertices = Integer.parseInt(lines.get(0));
        edge = Integer.parseInt(lines.get(1));

        digraph = new AdjacencyListDigraph(vertices);
        String[] token;
        for (int i = 2; i < lines.size(); i++) {
            String temp  =StringUtils.replaceAllEmptyCharWith(lines.get(i).trim(), " ");
            if (temp.equals("")) continue;
            token = temp.split(" ");
            digraph.addEdge(Integer.parseInt(token[0]), Integer.parseInt(token[1]));
        }
        System.out.println(digraph.toString());
        System.out.println("------------- graph end -------------");
    }
}
