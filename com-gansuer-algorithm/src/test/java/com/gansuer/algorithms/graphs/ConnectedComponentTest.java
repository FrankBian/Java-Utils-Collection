package com.gansuer.algorithms.graphs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 6/28/16.
 */
public class ConnectedComponentTest extends GraphTestBase{

    private ConnectedComponent connectedComponent;

    @Before
    public void setUp() throws Exception {
        init(null);
        connectedComponent = new ConnectedComponent(graph);
    }

    @Test
    public void isConnected() throws Exception {
        Assert.assertTrue(connectedComponent.isConnected(0,1));
        Assert.assertTrue(connectedComponent.isConnected(0,2));
        Assert.assertTrue(connectedComponent.isConnected(0,3));
        Assert.assertTrue(connectedComponent.isConnected(0,4));
        Assert.assertTrue(connectedComponent.isConnected(0,5));
        Assert.assertTrue(connectedComponent.isConnected(0,6));
        Assert.assertTrue(!connectedComponent.isConnected(0,7));
        Assert.assertTrue(!connectedComponent.isConnected(0,11));
        Assert.assertTrue(!connectedComponent.isConnected(7,11));
        Assert.assertTrue(connectedComponent.isConnected(7,8));
        Assert.assertTrue(connectedComponent.isConnected(10,12));
    }

    @Test
    public void count() throws Exception {
        Assert.assertEquals(3,connectedComponent.count());
    }

    @Test
    public void id() throws Exception {
        Assert.assertEquals(1,connectedComponent.id(7));
        Assert.assertEquals(1,connectedComponent.id(8));
        Assert.assertEquals(2,connectedComponent.id(10));
        Assert.assertEquals(2,connectedComponent.id(12));
        Assert.assertEquals(0,connectedComponent.id(1));
    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals(7,connectedComponent.size(0));
        Assert.assertEquals(7,connectedComponent.size(1));
        Assert.assertEquals(7,connectedComponent.size(2));
        Assert.assertEquals(7,connectedComponent.size(3));
        Assert.assertEquals(7,connectedComponent.size(4));
        Assert.assertEquals(7,connectedComponent.size(5));
        Assert.assertEquals(7,connectedComponent.size(6));
        Assert.assertEquals(2,connectedComponent.size(7));
        Assert.assertEquals(2,connectedComponent.size(8));
        Assert.assertEquals(4,connectedComponent.size(12));
    }
}