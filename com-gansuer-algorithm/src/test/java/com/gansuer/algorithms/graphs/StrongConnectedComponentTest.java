package com.gansuer.algorithms.graphs;

import com.gansuer.algorithms.graphs.directed.StrongConnectedComponent;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 7/6/16.
 */
public class StrongConnectedComponentTest extends DigraphTestBase {

    private StrongConnectedComponent scc;

    @Before
    public void setUp() throws Exception {
        init(false);
        scc = new StrongConnectedComponent(digraph);
    }

    @Test
    public void isStronglyConnected() throws Exception {
        Assert.assertTrue(scc.isStronglyConnected(0,2));
        Assert.assertTrue(scc.isStronglyConnected(0,3));
        Assert.assertTrue(scc.isStronglyConnected(0,4));
        Assert.assertTrue(scc.isStronglyConnected(0,5));
        Assert.assertTrue(!scc.isStronglyConnected(0,1));


    }

    @Test
    public void count() throws Exception {
        Assert.assertEquals(5,scc.count());
    }

    @Test
    public void getComponentId() throws Exception {
        for (int v = 0 ; v < digraph.getVertices();v++){
            System.out.println("vertex " + v +" id = " + scc.getComponentId(v));
        }
    }

}