package com.gansuer.algorithms.sort;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Frank on 2/21/2016.
 */
public class HeapTest {

    @Test
    public void testSort() throws Exception {
        String src = "s,o,r,t,e,x,a,m,p,l,e";
        String[] res = src.split(",");

        Heap heap = new Heap();
        heap.sort(res);
        Heap.show(res);

        Assert.assertEquals(true,heap.isSorted(res));
    }
}