package com.gansuer.algorithms.graphs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 6/8/16.
 */
public class DepthFirstUndirectedPathTest extends GraphTestBase{

    private DepthFirstUndirectedPath depthFirstPaths;
    private int root = 5;
    @Before
    public void setUp() throws Exception {
        init(null);
        depthFirstPaths = new DepthFirstUndirectedPath(graph,root);
    }

    @Test
    public void hasPathTo() throws Exception {
        Assert.assertEquals(true,depthFirstPaths.hasPathTo(1));
        Assert.assertEquals(false,depthFirstPaths.hasPathTo(11));
        Assert.assertEquals(false,depthFirstPaths.hasPathTo(9));
        Assert.assertEquals(false,depthFirstPaths.hasPathTo(8));
        Assert.assertEquals(false,depthFirstPaths.hasPathTo(7));
        Assert.assertEquals(true,depthFirstPaths.hasPathTo(0));
        Assert.assertEquals(true,depthFirstPaths.hasPathTo(6));
    }

    @Test
    public void pathTo() throws Exception {
        print(1);
        print(6);
        print(2);
        print(3);
        print(4);
        print(5);
    }

    private void print(int target){
        depthFirstPaths.pathTo(target).forEach(item -> System.out.print(item+" "));
        System.out.println();
    }
}