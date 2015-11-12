package com.gansuer.algorithms.sudoku.solution2;

import java.util.Set;

/**
 * Created by Frank on 11/6/15.
 */
public class Solver {

    private Layout layout ;
    private Layout solution;

    private Solver(int[][] array) {
        layout = new Layout(array);
    }

    public static Solver solve(int[][] array){
        Solver solver = new Solver(array);
        solver.run();
        return solver;
    }

    /**
     *  start to run
     */
    private void run() {
        solution = recursiveSpeculate(layout);
    }

    /**
     * the result solution
     * @return
     */
    public Layout getSolution() {
        return solution;
    }

    private Layout recursiveSpeculate(Layout input) {
        int result = input.isSolvable();
        if (result == 1){
            return input;
        }else if (result == -1){
            return null;
        }else {
            return speculateOnGrid(input);
        }
    }

    private Layout speculateOnGrid(Layout input) {
        Grid grid = input.speculateGrid();
        if (grid == null) {
            return null;
        }
        Set<Integer> cands = grid.getCandidates();
        Layout temp = null;
        for (int cand : cands){
            Layout speculatedLayout = new Layout(input);
            boolean decide = speculatedLayout.decide(grid.getIndex(),cand);
            if (!decide) continue;
            temp = recursiveSpeculate(speculatedLayout);
            if (temp != null) break;
        }
        return temp;
    }
}
