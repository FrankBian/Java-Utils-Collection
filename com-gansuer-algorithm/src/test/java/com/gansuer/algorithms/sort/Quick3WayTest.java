package com.gansuer.algorithms.sort;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 7/26/16.
 */
public class Quick3WayTest {

    private Quick3Way sort;

    @Before
    public void setUp() throws Exception {
        sort = new Quick3Way();
    }

    @Test
    public void sort() throws Exception {
        Integer[] arr = {5,4,3,9,10};
        sort.sort(arr);
        sort.show(arr);
        Assert.assertEquals(true,sort.isSorted(arr));
    }

}