package com.gansuer.algorithms.sudoku.solution2;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Frank on 11/6/15.
 */
public class Grid {

    private int index;
    private int value;

    private boolean decided = false;
    private Set<Integer> candidates = null;

    public Grid(int index) {
        this.index = index;
    }

    public Grid(Grid other){
        this.index = other.index;
        this.value = other.value;
        this.decided = other.decided;
        this.candidates = new HashSet<>(other.getCandidates());
    }

    public boolean decides(int cand){
        if (cand < 1 || cand > 9) return false;
        if (candidates.contains(cand)){
            value = cand;
            candidates.clear();
            decided = true;
            return true;
        }
        return false;
    }

    public boolean erase(int cand){
        return candidates.contains(cand) ? candidates.remove(cand) : true;
    }
    public int getValue() {
        return value;
    }

    public Set<Integer> getCandidates() {
        return candidates;
    }

    public boolean isDecided() {
        return decided;
    }

    public void setCandidates(Set<Integer> candidates) {
        this.candidates = candidates;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
