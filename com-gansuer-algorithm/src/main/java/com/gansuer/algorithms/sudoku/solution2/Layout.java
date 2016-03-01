package com.gansuer.algorithms.sudoku.solution2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Frank on 11/6/15.
 */
public class Layout {

    private List<Grid> grids;

    private int[][] result = null;
    private Map<Integer, Set<Integer>> colIndexMap = new HashMap<>();
    private Map<Integer, Set<Integer>> rowIndexMap = new HashMap<>();
    private Map<Integer, Set<Integer>> areaIndexMap = new HashMap<>();

    public Layout(int[][] array) {
        init(array);
    }

    public Layout(Layout other) {
        this.grids = new ArrayList<>();
        grids.addAll(other.grids.stream().map(Grid::new).collect(Collectors.toList()));
//        for (Grid grid : other.getGrids()){
//            this.grids.add(new Grid(grid));
//        }
        this.colIndexMap.putAll(other.colIndexMap);
        this.rowIndexMap.putAll(other.rowIndexMap);
        this.areaIndexMap.putAll(other.areaIndexMap);
    }

    public List<Grid> getGrids() {
        return grids;
    }

    public int[][] getResult() {
        if (result == null) {
            result = new int[9][9];
            for (Grid grid : grids) {
                result[grid.getIndex() / 9][grid.getIndex() % 9] = grid.getValue();
            }
        }
        return result;
    }


    private void init(int[][] array) {
        grids = new ArrayList<>();
        for (int i = 0; i < 81; i++) {
            Grid grid = new Grid(i);
            Set<Integer> temp = new HashSet<>();
            for (int ii = 1; ii < 10; ii++) {
                temp.add(ii);
            }
            grid.setCandidates(temp);
            grids.add(grid);

            int row = i / 9, col = i % 9, area = getAreaIndex(row, col);
            put(colIndexMap, col, i);
            put(rowIndexMap, row, i);
            put(areaIndexMap, area, i);
        }
//        String res = initMap(colIndexMap, "colIndexMap");
//        Assert.that(res == null, res);
//        res = initMap(rowIndexMap, "rowIndexMap");
//        Assert.that(res == null, res);
//        res = initMap(areaIndexMap, "areaIndexMap");
//        Assert.that(res == null, res);
        if (array != null) {
            for (int i = 0; i < 9; i++) {
                if (i >= array.length) break;
                for (int j = 0; j < 9; j++) {
                    if (j >= array[i].length) break;
                    grids.get(getIndex(i, j)).decides(array[i][j]);
                    erase(i, j, array[i][j]);
                }
            }
        }
    }

//
//    private String initMap(Map<Integer, Set<Integer>> map, String name) {
//        System.out.println(" --- " + name + " ---");
//        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " : [" + StringUtils.join(entry.getValue(), ",") + "]");
//            if (entry.getValue().size() != 9) {
//                return "colIndexMap : key = " + entry.getKey() + ", valueSize = " + entry.getValue().size();
//            }
//        }
//        return null;
//    }

    private void put(Map<Integer, Set<Integer>> map, int key, int value) {
        if (map != null) {
            if (map.containsKey(key)) {
                map.get(key).add(value);
            } else {
                Set<Integer> temp = new HashSet<>();
                temp.add(value);
                map.put(key, temp);
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
        int valueIndex = getIndex(row, col);

        if (!eraseHelper(valueIndex, rowIndexMap.get(row), value)) return false;
        if (!eraseHelper(valueIndex, colIndexMap.get(col), value)) return false;
        return eraseHelper(valueIndex, areaIndexMap.get(getAreaIndex(row, col)), value);

    }

    private boolean eraseHelper(int index, Set<Integer> indexes, int value) {
        if (indexes == null || indexes.size() != 9)
            throw new ExceptionInInitializerError("the index map is not CORRECT ! index = " + index +
                    ", Set = " + (indexes == null ? "null" : indexes.size()));
        for (int item : indexes) {
            if (item == index) continue;
            grids.get(item).erase(value);
        }
        return true;
    }

    /**
     * all grid is completed !
     *
     * @return 0-uncompleted  -1-error  1- completed
     */
    public int isSolvable() {
        for (Grid grid : grids) {
            if (grid.getValue() == 0) {
                return grid.getCandidates().size() > 0 ? 0 : -1;
            }
        }

        return verify() ? 1 : -1;
    }

    private boolean verify() {
        for (int type = 0; type < 3; type++) {
            for (int i = 0; i < 9; i++) {
                if (!verifyArea(i, type)) return false;
            }
        }
        return true;
    }

    /**
     * @param area
     * @param type 0-col 1-row 2-area
     * @return
     */
    private boolean verifyArea(int area, int type) {
        int[] temp = new int[10];
        Set<Integer> indexes = type == 0 ? colIndexMap.get(area) : (type == 1 ? rowIndexMap.get(area) : areaIndexMap.get(area));
        if (indexes == null && area > 0 && area < 9)
            throw new ExceptionInInitializerError("the index map is not CORRECT ! (area,type) = (" + area + "," + type + ")");
        for (int index : indexes) {
            int value = grids.get(index).getValue();
            temp[value] += 1;
        }
        if (temp[0] > 0) return false;
        for (int i = 1; i < 10; i++) {
            if (temp[i] != 1)
                return false;
        }
        return true;
    }

    public Grid speculateGrid() {
        int index = -1;
        int cands = Integer.MAX_VALUE;
        for (int i = 0; i < grids.size(); i++) {
            Grid grid = grids.get(i);
            if (grid.isDecided()) continue;
            if (grid.getValue() == 0 && grid.getCandidates().size() > 0 && grid.getCandidates().size() < cands) {
                index = i;
                cands = grid.getCandidates().size();
            }
        }
        return index < 0 ? null : grids.get(index);
    }

    public boolean decide(int index, int value) {
        boolean decided = grids.get(index).decides(value);
        if (decided) {
            int col = index % 9, row = index / 9;
            return erase(row, col, value);
        }
        return false;
    }
}
