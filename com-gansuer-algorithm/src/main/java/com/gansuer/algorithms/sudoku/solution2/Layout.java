package com.gansuer.algorithms.sudoku.solution2;

import java.util.*;

/**
 * Created by Frank on 11/6/15.
 */
public class Layout {

    private List<Grid> grids;

    private int[][] result;
    private Map<Integer, Set<Integer>> colIndexMap = null;
    private Map<Integer, Set<Integer>> rowIndexMap = null;
    private Map<Integer, Set<Integer>> areaIndexMap = null;

    public Layout(int[][] array) {
        init(array);
    }

    private void init(int[][] array) {
        grids = new ArrayList<>();
        colIndexMap = new HashMap<>();
        rowIndexMap = new HashMap<>();
        areaIndexMap = new HashMap<>();
        Set<Integer> colItem = null;
        Set<Integer> rowItem = null;
        Set<Integer> areaItem = null;
        for (int i = 0; i < 81; i++) {
            Grid grid = new Grid();
            Set<Integer> temp = new HashSet<>();
            for (int ii = 0; ii < 9; ii++) {
                temp.add(ii);
            }
            grid.setCandidates(temp);
            grids.add(grid);

            int row = i / 9, col = i % 9, area = getAreaIndex(row, col);
            if (colIndexMap.containsKey(col)) {
                colItem = colIndexMap.get(col);
            } else {
                colItem = new HashSet<>();
                colIndexMap.put(col, colItem);
            }
            colItem.add(i);
            if (rowIndexMap.containsKey(row)) {
                rowItem = rowIndexMap.get(row);
            } else {
                rowItem = new HashSet<>();
                rowIndexMap.put(row, rowItem);
            }
            rowItem.add(i);
            if (areaIndexMap.containsKey(area)) {
                areaItem = areaIndexMap.get(area);
            } else {
                areaItem = new HashSet<>();
                areaIndexMap.put(area, areaItem);
            }
            areaItem.add(i);
        }

        if (array != null) {
            for (int i = 0; i < 9; i++) {
                if (i >= array.length) break;
                for (int j = 0; j < 9; j++) {
                    if (j >= array[i].length) break;
                    grids.get(getIndex(i, j)).decides(array[i][j]);
                    erase(i,j,array[i][j]);
                }
            }
        }
    }

    private int getAreaIndex(int row, int col) {
        return row / 3 * 3 + col / 3;
    }

    private int getIndex(int row, int col) {
        return row * 9 + col;
    }

    private boolean erase(int row, int col, int value) {
        int valueIndex = getIndex(row,col);
        return eraseHelper(valueIndex,rowIndexMap.get(row),value) &&
                eraseHelper(valueIndex,colIndexMap.get(col),value) &&
                eraseHelper(valueIndex,areaIndexMap.get(getAreaIndex(row,col)),value) ;
    }

    private boolean eraseHelper(int index, Set<Integer> indexs, int value){
        if (indexs == null || indexs.size() != 9) return false;
        for (int item : indexs){
            if (item == index) continue;
            grids.get(item).erase(value);
        }
        return true;
    }

    /**
     * all grid is completed !
     * @return
     */
    public int isSolvable() {
        return 0;
    }
}
