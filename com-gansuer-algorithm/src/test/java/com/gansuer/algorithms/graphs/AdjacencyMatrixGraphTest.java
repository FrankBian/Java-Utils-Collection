package com.gansuer.algorithms.graphs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 6/8/16.
 */
public class AdjacencyMatrixGraphTest extends GraphTestBase{


    @Before
    public void setUp() throws Exception {
        init(null);
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