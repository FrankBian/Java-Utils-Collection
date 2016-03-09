package com.gansuer.algorithms.problem.theKInArray;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 7/24/15.
 */
public class JavaSolutionTest {

    private JavaSolution solution;

    @Before
    public void setUp() throws Exception {
        solution = new JavaSolution();
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
        int k = 3;

        Integer res = (Integer) solution.kTurnInArray(src, k);

        Assert.assertEquals(6, res.intValue());

    }
}