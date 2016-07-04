package com.gansuer.algorithms.graphs;

import com.gansuer.common.util.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Frank on 6/8/16.
 */
public class AdjacencyMatrixUndigraphTest extends GraphTestBase{


    private AdjacencyMatrixUndigraph graph;

    @Before
    public void setUp() throws Exception {
        String path = getClass().getClassLoader().getResource("graph/tinyG.txt").getFile();
        List<String> lines = FileUtils.readFile(path);
        vertices = Integer.parseInt(lines.get(0));
        edge = Integer.parseInt(lines.get(1));

        graph = new AdjacencyMatrixUndigraph(vertices);
        for (int i = 2; i < lines.size(); i++) {
            String[] token = lines.get(i).split(" ");
            graph.addEdge(Integer.parseInt(token[0]), Integer.parseInt(token[1]));
        }
        System.out.println(graph.toString());
        System.out.println("------------- graph end -------------");
    }

    @Test
    public void v() throws Exception {
        Assert.assertEquals(13,graph.getVertices());
    }

    @Test
    public void e() throws Exception {
        Assert.assertEquals(edge,graph.getEdges());
    }

    @Test
    public void addEdge() throws Exception {
        Assert.assertEquals(edge,graph.getEdges());
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