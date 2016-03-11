package com.gansuer.leetcode.array;

import com.gansuer.common.debug.Debug;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 3/11/16.
 */
public class Solution189Test {

    private Solution189 solution189;

    @Before
    public void setUp() throws Exception {
        solution189 = new Solution189();
    }

    @Test
    public void testRotate() throws Exception {
        int[] src = {1,2,3,4,5,6,7};

        Debug.print(src);
        solution189.rotate(src,4);
        Debug.print(src);
        Assert.assertArrayEquals(new int[]{4,5,6,7,1,2,3},src);
        int[] src1 = {1,2};
        solution189.rotate(src1,3);
        Assert.assertArrayEquals(new int[]{2,1},src1);
        Debug.print(src1);

        int[] arr = {1,2,3,4,5,6};
        solution189.rotate(arr,2);
        Debug.print(arr);
        Assert.assertArrayEquals(new int[]{5,6,1,2,3,4},arr);
    }
}