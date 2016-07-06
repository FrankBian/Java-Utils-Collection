package com.gansuer.algorithms.graphs;

import com.gansuer.algorithms.graphs.directed.BreadthFirstDirectedPaths;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 7/4/16.
 */
public class BreadthFirstDirectedPathsTest extends DigraphTestBase {

    private BreadthFirstDirectedPaths breadthFirstDirectedPaths;

    @Before
    public void setUp() throws Exception {
        init(false);
        breadthFirstDirectedPaths = new BreadthFirstDirectedPaths(digraph,3);
    }

    @Test
    public void distanceTo() throws Exception {
        Assert.assertEquals(0,breadthFirstDirectedPaths.distanceTo(3));
        Assert.assertEquals(1,breadthFirstDirectedPaths.distanceTo(2));
        Assert.assertEquals(2,breadthFirstDirectedPaths.distanceTo(0));
        Assert.assertEquals(-1,breadthFirstDirectedPaths.distanceTo(11));
    }

    @Test
    public void hasPathTo() throws Exception {
        Assert.assertTrue(!breadthFirstDirectedPaths.hasPathTo(6));
        Assert.assertTrue(!breadthFirstDirectedPaths.hasPathTo(7));
        Assert.assertTrue(!breadthFirstDirectedPaths.hasPathTo(8));
        Assert.assertTrue(!breadthFirstDirectedPaths.hasPathTo(9));
        Assert.assertTrue(!breadthFirstDirectedPaths.hasPathTo(10));
        Assert.assertTrue(!breadthFirstDirectedPaths.hasPathTo(11));
        Assert.assertTrue(!breadthFirstDirectedPaths.hasPathTo(12));
        Assert.assertTrue(breadthFirstDirectedPaths.hasPathTo(0));
        Assert.assertTrue(breadthFirstDirectedPaths.hasPathTo(1));
        Assert.assertTrue(breadthFirstDirectedPaths.hasPathTo(2));
        Assert.assertTrue(breadthFirstDirectedPaths.hasPathTo(3));
        Assert.assertTrue(breadthFirstDirectedPaths.hasPathTo(4));
        Assert.assertTrue(breadthFirstDirectedPaths.hasPathTo(5));

    }

    @Test
    public void pathTo() throws Exception {
        int[] case1 = {3,2,0};
        int index = 0;
        for (int item : breadthFirstDirectedPaths.pathTo(0)){
            Assert.assertEquals(case1[index++],item);
            //System.out.print(item +"  ");
        }
    }

}