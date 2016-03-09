package com.gansuer.algorithms.problem.sudoku.solution2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Created by Frank on 11/12/15.
 */
public class SolverTest {

    private int[][] inputArray = null;

    private Solver solver = null;

    @Before
    public void setUp() throws Exception {
        inputArray = new int[9][9];
        inputArray[0][0] = 3;
        inputArray[0][8] = 1;
        inputArray[1][6] = 2;
        inputArray[2][3] = 7;
        inputArray[4][2] = 5;
        inputArray[5][5] = 9;
        inputArray[6][4] = 8;
        inputArray[7][1] = 4;
        inputArray[8][7] = 6;

    }

    @Test
    public void testRun() throws Exception {
        Date begin = new Date();
        solver = Solver.solve(inputArray);
        Date end = new Date();

        System.out.println("times : " + (end.getTime() - begin.getTime()));
        Assert.assertNotNull(solver);
        Assert.assertNotNull(solver.getSolution());
        Assert.assertNotNull(solver.getSolution().getResult());
        int[][] result = solver.getSolution().getResult();
        for (int i = 0; i < 9; i++) {
            System.out.println();
            for (int j = 0; j < 9; j++) {
                System.out.print(result[i][j] + " ");
            }
        }
        System.out.println();
    }
}