package com.gansuer.algorithms.graphs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 7/3/2016.
 */
public class DirectedSearchTest extends DigraphTestBase{

    private DirectedSearch directedSearch;
    private int source;
    @Before
    public void setUp() throws Exception {
        init(false);
        source = 6;
        directedSearch = new DepthFirstDirectedSearch(digraph,6);
    }

    @Test
    public void isReachable() throws Exception {
        Assert.assertTrue(directedSearch.isReachable(0));
        Assert.assertTrue(directedSearch.isReachable(4));
        Assert.assertTrue(directedSearch.isReachable(8));
        Assert.assertTrue(directedSearch.isReachable(9));
        Assert.assertTrue(directedSearch.isReachable(6));
        Assert.assertTrue(directedSearch.isReachable(11));
        Assert.assertTrue(!directedSearch.isReachable(7));
    }

    @Test
    public void count() throws Exception {
        Assert.assertEquals(12,directedSearch.count());
    }

}