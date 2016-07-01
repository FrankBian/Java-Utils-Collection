package com.gansuer.algorithms.graphs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 6/8/16.
 */
public class DepthFirstSearchTest extends GraphTestBase {

    private DepthFirstUndirectedSearch depthFirstSearch;
    private int root = 5;
    @Before
    public void setUp() throws Exception {
        init(null);
        depthFirstSearch = new DepthFirstUndirectedSearch(graph,root);
    }

    @Test
    public void isConnected() throws Exception {
        Assert.assertEquals(true,depthFirstSearch.isReachable(0));
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