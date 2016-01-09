package com.gansuer.algorithms.sort;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 7/26/15.
 */
public class MergeXTest {

    private MergeX mergeX;

    @Before
    public void setUp() throws Exception {
        mergeX = new MergeX();
    }

    @Test
    public void testSort() throws Exception {
        String s = "MERGESORTEXAMPLE";
        String[] arr = new String[s.length()];
        int index = 0;
        for (char ch : s.toCharArray()) {
            arr[index] = s.charAt(index) + "";
            index++;
        }
        mergeX.show(arr);

        mergeX.sort(arr);

        Assert.assertTrue(mergeX.isSorted(arr));

        mergeX.show(arr);
    }
}