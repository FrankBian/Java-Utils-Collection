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
        String[] strs = new String[]{"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",
                ".98...3..", "...8.3.2.","........6","...2759.."};
        int[][] input = string2int(strs);
        solition1.sudoku(input);
        solition1.show();

    }

    private int[][] string2int(String[] strs) {
        String str = "";
        for (String item : strs) {
            str += item;
        }
        int[][] input = new int[9][9];
        char[] chars = str.toCharArray();
        System.out.println("-----------------------------------");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int index = i * 9 + j;
                input[i][j] = chars[index] == '.' ? 0 : chars[index] - '0';
                System.out.print(input[i][j] + "   ");
            }
            System.out.println();
        }
        System.out.println("-----------------------------------");
        return input;
    }
}