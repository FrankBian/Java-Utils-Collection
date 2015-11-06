package com.gansuer.algorithms.sudoku.solution2;

import java.util.Set;

/**
 * Created by Frank on 11/6/15.
 */
public class Grid {

    private int value;

    private boolean decided = false;
    private Set<Integer> candidates = null;

    public Grid() {
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
}
