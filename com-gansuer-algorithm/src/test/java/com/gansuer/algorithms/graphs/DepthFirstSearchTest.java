package com.gansuer.algorithms.graphs;

import com.gansuer.common.util.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Frank on 6/8/16.
 */
public class DepthFirstSearchTest {

    private DepthFirstSearch depthFirstSearch;
    private final String fileName = "graph/tinyG.txt";
    private List<String> lines;
    private int v = 0, e = 0;
    private int root = 5;
    private Graph graph;
    @Before
    public void setUp() throws Exception {
        String path = getClass().getClassLoader().getResource(fileName).getFile();
        lines = FileUtils.readFile(path);
        v = Integer.parseInt(lines.get(0));
        e = Integer.parseInt(lines.get(1));

        graph = new AdjacencyMatrixGraph(v);
        for (int i = 2; i < lines.size(); i++) {
            String[] token = lines.get(i).split(" ");
            graph.addEdge(Integer.parseInt(token[0]),Integer.parseInt(token[1]));
        }

        depthFirstSearch = new DepthFirstSearch(graph,root);
    }

    @Test
    public void isConnected() throws Exception {
        Assert.assertEquals(true,depthFirstSearch.isConnected(0));
    }

    @Test
    public void count() throws Exception {
        Assert.assertEquals(7,depthFirstSearch.count());
    }

    @Test
    public void TestToString() throws Exception {
        System.out.println(graph.toString());
    }
}