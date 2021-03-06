package com.gansuer.algorithms.graphs.spanningtree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 7/7/16.
 */
public class LazyPrimMSTTest extends EWGTestBase {

    private LazyPrimMST mst;

    @Before
    public void setUp() throws Exception {
        init(true);
        //init(false);
        mst = new LazyPrimMST(graph);
    }

    @Test
    public void getWeight() throws Exception {
        //Assert.assertEquals(1.81, mst.getWeight(), 0.0); //tinyEWG
        Assert.assertEquals(10.46351, mst.getWeight(), 0.00001); //mediumEWG
    }

    @Test
    public void getEdges() throws Exception {
        mst.getEdges().forEach(item -> System.out.println(item));
    }

}