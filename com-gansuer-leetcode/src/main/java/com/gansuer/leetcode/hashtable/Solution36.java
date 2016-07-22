package com.gansuer.leetcode.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by Frank on 7/21/16.
 */
public class Solution36 {


    /**
     * Accepted
     * 11ms
     * 7.70%
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> set = new HashSet<>();
        // row
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') continue;
                if (set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
            set.clear();
        }

        //column
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] == '.') continue;
                if (set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
            set.clear();
        }

        Map<Integer, HashSet<Character>> map = new HashMap<>();
        set = null;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') continue;
                int index = i / 3 * 3 + j / 3;
                if (map.containsKey(index)) set = map.get(index);
                else {
                    set = new HashSet<>();
                    map.put(index, set);
                }
                if (set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }
        return true;
    }

    /**
     * Accepted
     * 13ms
     * 4.28%
     *
     * @param board
     * @return
     */
    public boolean isValidSudokuX(char[][] board) {
        Map<String, HashSet<Character>> map = new HashMap<>();
        final String ROW = "i";
        final String COLUMN = "j";
        final String BLOCK = "IJ";
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                //row
                if (!isValid(map, ROW + i, board[i][j])) return false;
                //column
                if (!isValid(map, COLUMN + j, board[i][j])) return false;
                //block
                int index = i / 3 * 3 + j / 3;
                if (!isValid(map, BLOCK + index, board[i][j])) return false;
            }
        }
        return true;
    }

    private boolean isValid(Map<String, HashSet<Character>> map, String key, Character character) {
        HashSet<Character> set;
        if (map.containsKey(key)) {
            set = map.get(key);
            if (set.contains(character)) return false;
        } else {
            set = new HashSet<>();
            map.put(key, set);
        }
        set.add(character);
        return true;
    }
}
