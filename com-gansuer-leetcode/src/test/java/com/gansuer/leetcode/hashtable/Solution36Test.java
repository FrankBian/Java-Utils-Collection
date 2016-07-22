package com.gansuer.leetcode.hashtable;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 7/22/16.
 */
public class Solution36Test {

    private Solution36 solution;

    @Before
    public void setUp() throws Exception {
        solution = new Solution36();
    }

    @Test
    public void isValidSudoku() throws Exception {
        String str = "53..7....6..195....98....6.8...6...34..8.3..17...2...6" +
                ".6....28....419..5....8..79";
        char[][] input = string2chars(str);
        Assert.assertTrue(solution.isValidSudoku(input));
        String[] strs = {"....5..1.", ".4.3.....", ".....3..1", "8......2.", "..2.7....", ".15......",
                ".....2...", ".2.9.....", "..4......"};
        str = "";
        for (String item : strs) {
            str += item;
        }

        input = string2chars(str);
        Assert.assertTrue(!solution.isValidSudoku(input));
    }

    @Test
    public void isValidSudokuX() throws Exception {
        String str = "53..7....6..195....98....6.8...6...34..8.3..17...2...6" +
                ".6....28....419..5....8..79";
        char[][] input = string2chars(str);
        Assert.assertTrue(solution.isValidSudokuX(input));
        String[] strs = {"....5..1.", ".4.3.....", ".....3..1", "8......2.", "..2.7....", ".15......",
                ".....2...", ".2.9.....", "..4......"};
        str = "";
        for (String item : strs) {
            str += item;
        }

        input = string2chars(str);
        Assert.assertTrue(!solution.isValidSudokuX(input));

    }

    private char[][] string2chars(String str) {
        char[][] input = new char[9][9];
        char[] chars = str.toCharArray();
        System.out.println("-----------------------------------");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int index = i * 9 + j;
                input[i][j] = chars[index];
                System.out.print(chars[index] + "   ");
            }
            System.out.println();
        }
        System.out.println("-----------------------------------");
        return input;
    }
}