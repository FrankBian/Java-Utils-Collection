package com.gansuer.algorithms.graphs;

import com.gansuer.common.util.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Frank on 6/8/16.
 */
public class AdjacencyMatrixGraphTest {

    private Graph graph;
    private final String fileName = "graph/tinyG.txt";
    private List<String> lines;
    private int v = 0, e = 0;

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
    }

    @Test
    public void v() throws Exception {
        Assert.assertEquals(13,graph.V());
    }

    @Test
    public void e() throws Exception {
        Assert.assertEquals(e,graph.E());
    }

    @Test
    public void addEdge() throws Exception {
        Assert.assertEquals(e,graph.E());
    }

    @Test
    public void adj() throws Exception {
        for (int item : graph.adj(0)){
            Assert.assertTrue(item == 1 || item == 2 || item == 5 || item == 6);
        }
    }

    @Test
    public void degree() throws Exception {
        Assert.assertEquals(4,graph.degree(0));
        Assert.assertEquals(3,graph.degree(5));
        Assert.assertEquals(3,graph.degree(4));
        Assert.assertEquals(2,graph.degree(3));
        Assert.assertEquals(2,graph.degree(6));
        Assert.assertEquals(3,graph.degree(9));
        Assert.assertEquals(2,graph.degree(11));
    }

    @Test
    public void testToString() throws Exception {
        System.out.println(graph.toString());
    }

}