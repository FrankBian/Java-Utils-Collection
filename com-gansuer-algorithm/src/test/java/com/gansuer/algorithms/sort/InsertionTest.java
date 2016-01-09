package com.gansuer.algorithms.sort;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 5/13/15.
 */
public class InsertionTest {

    private Insertion insertion;

    @Before
    public void setUp() throws Exception {
        insertion = new Insertion();
    }

    @Test
    public void testSortX() throws Exception {
        Integer[] arr = {3, 8, 2, 3, 5, 0, -1};
        insertion.sortX(arr);
        Assert.assertTrue(insertion.isSorted(arr));
        insertion.show(arr);
    }

}