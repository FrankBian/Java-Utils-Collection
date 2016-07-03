package com.gansuer.algorithms.graphs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 7/1/16.
 */
public class AdjacencyMatrixDigraphTest extends DigraphTestBase {

    @Before
    public void setUp() throws Exception {
        init();
    }

    @Test
    public void addEdge() throws Exception {
        digraph.adj(0).forEach(item -> Assert.assertTrue(item == 1 || item == 5));
        digraph.adj(2).forEach(item -> Assert.assertTrue(item == 0 || item == 3));
        digraph.adj(7).forEach(item -> Assert.assertTrue(item == 6 || item == 9));
        digraph.adj(9).forEach(item -> Assert.assertTrue(item == 10 || item == 11));
        digraph.adj(11).forEach(item -> Assert.assertTrue(item == 4 || item == 12));
        digraph.adj(12).forEach(item -> Assert.assertTrue(item == 9));
    }

    @Test
    public void adj() throws Exception {
        addEdge();
    }

    @Test
    public void reverse() throws Exception {
        Digraph res = digraph.reverse();
        Assert.assertNotNull(res);
        System.out.println(res.toString());
    }

}