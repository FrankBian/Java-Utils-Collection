package com.gansuer.leetcode.array;

/**
 * Created by Frank on 7/22/16.
 */
public class Solution37 {


    /**
     * Accepted
     * 26ms
     * 38.94%
     *
     * @param board
     */
    public void solveSudoku(char[][] board) {
        boolean res = solve(board, 0);
        if (!res) throw new IllegalArgumentException("board is not validated sudoku input");
    }

    private boolean solve(char[][] board, int index) {
        if (index == 81) return true;
        int i = index / 9, j = index % 9;
        if (board[i][j] != '.') {
            return solve(board, index + 1);
        }
        for (char v = '1'; v <= '9'; v++) {
            board[i][j] = v;
            if (isValid(board, i, j) && solve(board, index + 1)) {
                return true;
            }
        }
        board[i][j] = '.'; // backtrack
        return false;
    }


    private boolean isValid(char[][] board, int i, int j) {
        int[] query = {0, 0, 0, 3, 3, 3, 6, 6, 6};
        // row
        int row, col;
        for (col = 0; col < 9; col++) {
            if (board[i][col] == '.' || col == j) continue;
            if (board[i][col] == board[i][j]) return false;
        }
        // col
        for (row = 0; row < 9; row++) {
            if (board[row][j] == '.' || row == i) continue;
            if (board[row][j] == board[i][j]) return false;
        }
        for (row = query[i]; row < query[i] + 3; row++) {
            for (col = query[j]; col < query[j] + 3; col++) {
                if (board[row][col] == '.' || (row == i && col == j)) continue;
                if (board[row][col] == board[i][j]) return false;
            }
        }
        return true;
    }
}
