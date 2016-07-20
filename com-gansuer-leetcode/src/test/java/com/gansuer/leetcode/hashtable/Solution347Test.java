package com.gansuer.leetcode.hashtable;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 7/20/16.
 */
public class Solution347Test {

    private Solution347 s;

    @Before
    public void setUp() throws Exception {
        s = new Solution347();
    }

    @Test
    public void topKFrequent() throws Exception {
        Assert.assertArrayEquals(new Integer[]{1,2},
                s.topKFrequent(new int[]{1,1,1,2,3,2},2).toArray(new Integer[2]));
        Assert.assertArrayEquals(new Integer[]{1,2},
                s.topKFrequentX(new int[]{1,1,1,2,3,2},2).toArray(new Integer[2]));
    }

}