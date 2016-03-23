package com.gansuer.algorithms.problem.theKInArray;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 7/24/15.
 */
public class JavaSolutionTest {

    private Solution1 solution;

    @Before
    public void setUp() throws Exception {
        solution = new Solution1();
    }

    @Test
    public void testTheKofArray() throws Exception {
        int[] src = {2, 4, 6, -1, 8, 9};
        int k = 3;

        int res = solution.theKofArray(src, k);

        Assert.assertEquals(6, res);
    }

    @Test
    public void testKTurnInArray() throws Exception {
        Integer[] src = {2, 4, 6, -1, 8, 9};
        Assert.assertEquals(4,solution.kTurnInArray(src,4));
        Assert.assertEquals(9,solution.kTurnInArray(src,1));
        Assert.assertEquals(8,solution.kTurnInArray(src,2));
        Assert.assertEquals(6,solution.kTurnInArray(src,3));
        Assert.assertEquals(2,solution.kTurnInArray(src,5));
        Assert.assertEquals(-1,solution.kTurnInArray(src,6));

        Integer[] case1 = {2, 1};
        Assert.assertEquals(2, solution.kTurnInArray(case1, 1));
    }
}