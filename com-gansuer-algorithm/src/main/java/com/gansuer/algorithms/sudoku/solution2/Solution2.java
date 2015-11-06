package com.gansuer.algorithms.sudoku.solution2;

/**
 * Created by Frank on 11/6/15.
 */
public class Solution2 {

    private Layout layout ;

    public Solution2(int[][] array) {
        layout = new Layout(array);
    }

    public void run(){

        int result = layout.isSolvable();

    }
}
