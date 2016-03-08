package com.gansuer.algorithms.problem.UnionFind;

/**
 * Created by Frank on 9/16/15.
 */
public class QuickFind extends UF {

    public QuickFind(int n) {
        id = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if (pID == qID) return;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
        count--;
    }

    /**
     * find p's identify
     *
     * @param p
     * @return
     */
    @Override
    public int find(int p) {
        return id[p];
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

}
