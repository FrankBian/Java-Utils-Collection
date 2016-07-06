package com.gansuer.algorithms.graphs;

import com.gansuer.algorithms.graphs.directed.DepthFirstOrder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 7/5/16.
 */
public class DepthFirstOrderTest extends DigraphTestBase {

    private DepthFirstOrder depthFirstOrder;

    @Before
    public void setUp() throws Exception {
        init(true);
        depthFirstOrder = new DepthFirstOrder(digraph);
    }

    @Test
    public void preOrder() throws Exception {
        int[] case1 = {0, 1, 5, 4, 6, 9, 10, 11, 12, 2, 3, 7, 8};
        int index = 0;
        for (int item : depthFirstOrder.preOrder()) {
            Assert.assertEquals(case1[index++], item);
            System.out.print(item +" " );
        }
    }

    @Test
    public void pre() throws Exception {
        for (int v = 0; v < digraph.getVertices(); v++) {
            System.out.println(v + " pre() : " + depthFirstOrder.pre(v));
        }
    }

    @Test
    public void postOrder() throws Exception {
        depthFirstOrder.postOrder().forEach(item -> System.out.print(item + " "));
    }

    @Test
    public void post() throws Exception {
        int index = 0;
        for (int item : depthFirstOrder.postOrder()) {
            System.out.print(item + " ");
            Assert.assertEquals(index++, depthFirstOrder.post(item));
        }
    }

    @Test
    public void reversePost() throws Exception {
        depthFirstOrder.reversePost().forEach(item -> System.out.print(item + " "));
    }

}