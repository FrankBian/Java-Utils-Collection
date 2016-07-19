package com.gansuer.algorithms.graphs.spanningtree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 7/19/16.
 */
public class KruskalMSTTest extends EWGTestBase{

    private KruskalMST mst;

    @Before
    public void setUp() throws Exception {
        init(false);
        mst = new KruskalMST(graph);
    }

    @Test
    public void getEdges() throws Exception {
        int vertices = graph.getVertices();
        Assert.assertEquals(vertices-1, mst.getEdges().size());
        mst.getEdges().forEach(edge -> System.out.println(edge));
    }

    @Test
    public void getWeight() throws Exception {

    }

}