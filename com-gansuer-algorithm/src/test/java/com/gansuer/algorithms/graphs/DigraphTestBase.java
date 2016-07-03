package com.gansuer.algorithms.graphs;

import com.gansuer.common.util.FileUtils;
import com.gansuer.common.util.StringUtils;

import java.util.List;

/**
 * Created by Frank on 7/1/16.
 */
public class DigraphTestBase {


    protected Digraph digraph;
    private final String defaultFileName = "graph/tinyDG.txt";
    private List<String> lines;
    protected int vertices = 0, edge = 0;

    public void init() throws Exception {
        String path = getClass().getClassLoader()
                .getResource(defaultFileName).getFile();
        lines = FileUtils.readFile(path);
        vertices = Integer.parseInt(lines.get(0));
        edge = Integer.parseInt(lines.get(1));

        digraph = new AdjacencyListDigraph(vertices);
        for (int i = 2; i < lines.size(); i++) {
            String[] token = StringUtils.replaceAllEmptyCharWith(lines.get(i).trim(), " ")
                    .split(" ");
            digraph.addEdge(Integer.parseInt(token[0]), Integer.parseInt(token[1]));
        }
        System.out.println(digraph.toString());
        System.out.println("------------- graph end -------------");
    }
}
