package com.gansuer.algorithms.problem.sudoku;

import java.util.Arrays;

/**
 * Created by Frank on 7/22/15.
 * <p>
 * Backtracking
 */
public class Solution1 {

    private final String illegalArguments = "Input array must be a 9*9 array!";

    private int[][] src = new int[9][9];

    public int[][] getSrc() {
        return src;
    }

    public void setSrc(int[][] src) {
        this.src = src;
    }

    private boolean isValid(int i, int j) {

        int n = src[i][j];
        int[] query = new int[]{0, 0, 0, 3, 3, 3, 6, 6, 6};

        int t, u;
        for (t = 0; t < 9; t++) {
            if ((t != i && src[t][j] == n) || (t != j && src[i][t] == n)) {
                return false;
            }
        }

        for (t = query[i]; t < query[i] + 3; t++) {
            for (u = query[j]; u < query[j] + 3; u++) {
                if ((t != i || u != j) && src[t][u] == n) {
                    return false;
                }
            }
        }

        return true;
    }

    public void show() {
        int n = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(src[i][j] + "   ");
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------------");
    }

    private boolean run(int n) {
        if (n == 81) { // is finished?
            return true;
        }

        int i = n / 9, j = n % 9;

        if (src[i][j] != 0) { // if this cell is DONE , the next one
            return run(n + 1);
        }

        for (int k = 0; k < 9; k++) {
            src[i][j]++; // from 1 to 9 , try all possible solution
            if (isValid(i, j) && run(n + 1)) { // the next one if this is OK
                return true;
            }
        }
        src[i][j] = 0;
        return false;
    }

    public void sudoku(int array[][]) {
        if (array.length != 9) {
            throw new IllegalArgumentException(illegalArguments);
        }
        for (int i = 0; i < 9; i++) {
            if (array[i].length != 9) {
                throw new IllegalArgumentException(illegalArguments);
            }
            src[i] = Arrays.copyOf(array[i], 9);
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (src[i][j] != 0 && !isValid(i, j)) {
                    throw new IllegalArgumentException(illegalArguments);
                }
            }
        }
        // input array validation done

        run(0);
    }

    public int[][] result() {
        return getSrc();
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
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
                        {0, 0, 6, 1, 0, 0, 0, 4, 9}
                };
        solution1.setSrc(soduku);
        solution1.run(0);
        solution1.show();

    }
}
