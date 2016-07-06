package com.gansuer.algorithms.graphs;

import com.gansuer.algorithms.graphs.directed.DepthFirstDirectedPaths;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 7/4/16.
 */
public class DepthFirstDirectedPathsTest extends DigraphTestBase{

    private DepthFirstDirectedPaths depthFirstDirectedPaths;

    @Before
    public void setUp() throws Exception {
        init(false);
        depthFirstDirectedPaths = new DepthFirstDirectedPaths(digraph,3);
    }

    @Test
    public void hasPathTo() throws Exception {
        Assert.assertTrue(depthFirstDirectedPaths.hasPathTo(0));
        Assert.assertTrue(depthFirstDirectedPaths.hasPathTo(1));
        Assert.assertTrue(depthFirstDirectedPaths.hasPathTo(2));
        Assert.assertTrue(depthFirstDirectedPaths.hasPathTo(3));
        Assert.assertTrue(depthFirstDirectedPaths.hasPathTo(4));
        Assert.assertTrue(depthFirstDirectedPaths.hasPathTo(5));
        Assert.assertTrue(!depthFirstDirectedPaths.hasPathTo(6));
        Assert.assertTrue(!depthFirstDirectedPaths.hasPathTo(7));
        Assert.assertTrue(!depthFirstDirectedPaths.hasPathTo(8));
        Assert.assertTrue(!depthFirstDirectedPaths.hasPathTo(9));
        Assert.assertTrue(!depthFirstDirectedPaths.hasPathTo(10));
        Assert.assertTrue(!depthFirstDirectedPaths.hasPathTo(11));
        Assert.assertTrue(!depthFirstDirectedPaths.hasPathTo(12));
    }

    @Test
    public void pathTo() throws Exception {
        int[] case1 = {3,2,0};
        int index = 0;
        for (int item : depthFirstDirectedPaths.pathTo(0)){
            Assert.assertEquals(case1[index++],item);
            //System.out.print(item +"  ");
        }
    }

}