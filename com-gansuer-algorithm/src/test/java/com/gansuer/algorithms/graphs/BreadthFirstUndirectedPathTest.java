package com.gansuer.algorithms.graphs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 6/27/16.
 */
public class BreadthFirstUndirectedPathTest extends GraphTestBase{

    private BreadthFirstUndirectedPath breadthFirstPaths;

    private final String fileName = "graph/tinyCG.txt";

    @Before
    public void setUp() throws Exception {
        init(fileName);
    }

    @Test
    public void distanceTo() throws Exception {
        breadthFirstPaths = new BreadthFirstUndirectedPath(graph, 0);
        Assert.assertEquals(0, breadthFirstPaths.distanceTo(0));
        Assert.assertEquals(1, breadthFirstPaths.distanceTo(5));
        Assert.assertEquals(1, breadthFirstPaths.distanceTo(1));
        Assert.assertEquals(1, breadthFirstPaths.distanceTo(2));
        Assert.assertEquals(2, breadthFirstPaths.distanceTo(3));
        Assert.assertEquals(2, breadthFirstPaths.distanceTo(4));

    }

    @Test
    public void pathTo() throws Exception {
        breadthFirstPaths = new BreadthFirstUndirectedPath(graph, 0);
        for (int v = 0; v < vertices; v++) {
            if (breadthFirstPaths.hasPathTo(v)) {
                System.out.printf("0 to %d (%d):  ", v, breadthFirstPaths.distanceTo(v));
                for (int x : breadthFirstPaths.pathTo(v)) {
                    if (x == 0) System.out.print(x);
                    else System.out.print("-" + x);
                }
                System.out.println();
            } else {
                System.out.printf("%d to %d (-):  not connected\n", 0, v);
            }
        }
    }
}