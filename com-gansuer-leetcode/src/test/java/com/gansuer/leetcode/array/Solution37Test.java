package com.gansuer.leetcode.array;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 7/22/16.
 */
public class Solution37Test {

    private Solution37 solution;

    @Before
    public void setUp() throws Exception {
        solution = new Solution37();
    }

    @Test
    public void solveSudoku() throws Exception {
        String[] str = {"..9748...", "7........", ".2.1.9...", "..7...24.", ".64.1.59.", ".98...3..",
                "...8.3.2.", "........6", "...2759.."};
        char[][] input = string2chars(str);

        solution.solveSudoku(input);
        print(input);

        str = new String[]{"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..",
                "...8.3.2.","........6","...2759.."};

        input = string2chars(str);
        solution.solveSudoku(input);
        print(input);
    }

    private char[][] string2chars(String[] strs) {
        String str = "";
        for (String item : strs) {
            str += item;
        }
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

    private void print(char[][] chars){
        System.out.println(" -------------- res -------------");
        for (int i = 0; i < 9 ; i++){
            for (int j =0; j< 9; j++){
                System.out.print(chars[i][j] +"  ");
            }
            System.out.println();
        }
    }
}