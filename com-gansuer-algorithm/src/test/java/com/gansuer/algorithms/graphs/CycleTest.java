package com.gansuer.algorithms.graphs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 7/4/2016.
 */
public class CycleTest extends GraphTestBase{

    private Cycle cycle;
    @Before
    public void setUp() throws Exception {
        init(null);
        cycle = new Cycle(graph);
    }

    @Test
    public void hasCycle() throws Exception {
        Assert.assertTrue(cycle.hasCycle());
    }

    @Test
    public void getCycle() throws Exception {
        int[] case1 = {4,3,5,4};
        int index =0 ;
        for (int item : cycle.getCycle()){
            Assert.assertEquals(case1[index++],item);
        }
    }

}
