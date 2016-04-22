package com.gansuer.algorithms.sort;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 7/26/15.
 */
public class MergeTest {

    private Merge merge;

    @Before
    public void setUp() throws Exception {
        merge = new Merge();
    }

    @Test
    public void testSort() throws Exception {
//        Integer[] arr = {9,8,5,6,3,34,12};
        String s = "MERGESORTEXAMPLE";
        String[] arr = new String[s.length()];
        int index = 0;
        for (char ch : s.toCharArray()) {
            arr[index] = s.charAt(index) + "";
            index++;
        }
        merge.show(arr);

        merge.sort(arr);

        Assert.assertTrue(merge.isSorted(arr));

        merge.show(arr);
    }
}