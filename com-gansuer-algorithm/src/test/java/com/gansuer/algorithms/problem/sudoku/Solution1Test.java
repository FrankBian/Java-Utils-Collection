package com.gansuer.algorithms.problem.sudoku;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Created by Frank on 7/22/15.
 */
public class Solution1Test {

    public Solution1 solition1;

    @Before
    public void setUp() throws Exception {
        solition1 = new Solution1();
    }

    @Test
    public void testShow() throws Exception {
    }

    @Test
    public void testSudoku() throws Exception {
        int[][] soduku = new int[][]
                {
                        {0, 0, 0, 7, 2, 8, 0, 0, 0},
                        {0, 9, 0, 0, 5, 1, 6, 0, 0},
                        {0, 0, 0, 0, 6, 0, 0, 8, 2},
                        {3, 0, 0, 8, 0, 2, 7, 0, 4},
                        {1, 7, 4, 0, 3, 0, 0, 2, 0},
                        {2, 8, 0, 5, 0, 0, 0, 3, 0},
                        {0, 1, 0, 3, 0, 0, 2, 0, 0},
                        {0, 0, 7, 0, 4, 6, 0, 0, 5},
                        {0, 0, 6, 1, 0, 0, 0, 4, 9}};
        Date begin = new Date();

        solition1.sudoku(soduku);
        int[][] res = solition1.result();

        Date end = new Date();
        solition1.show();
        Assert.assertNotNull(res);

        System.out.println(end.getTime() - begin.getTime());

    }

    @Test
    public void testResult() throws Exception {

    }
}