package com.gansuer.algorithms.graphs;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Frank on 7/5/2016.
 */
public class DirectedCycleTest extends DigraphTestBase{

    private DirectedCycle cycle;


    @Test
    public void hasCycle() throws Exception {
        init(false);
        cycle = new DirectedCycle(digraph);
        Assert.assertTrue(cycle.hasCycle());
    }

    @Test
    public void hasCycleError() throws Exception {
        init(true);
        cycle = new DirectedCycle(digraph);
        Assert.assertTrue(!cycle.hasCycle());
    }

    @Test
    public void cycle() throws Exception {
        init(false);
        cycle = new DirectedCycle(digraph);
        cycle.cycle().forEach(item -> System.out.print(item +" "));
        int[] case1 = {0,5,4,2,0};
        int i = 0;
        for (int item : cycle.cycle()){
            Assert.assertEquals(case1[i++],item);
        }
    }

}