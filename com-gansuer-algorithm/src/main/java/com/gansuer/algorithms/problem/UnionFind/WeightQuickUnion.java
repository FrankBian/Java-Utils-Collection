package com.gansuer.algorithms.problem.unionFind;

/**
 * Created by Frank on 9/16/15.
 */
public class WeightQuickUnion extends UF {
    private int[] sz;

    public WeightQuickUnion(int count) {
        this.count = count;
        id = new int[count];
        sz = new int[count];
        for (int i = 0; i < count; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    /**
     * connect p and q
     *
     * @param p
     * @param q
     */
    @Override
    public void union(int p, int q) {
        int rootp = find(p);
        int rootq = find(q);
        if (rootp == rootq) return;
        if (sz[rootp] >= sz[rootq]) {
            id[rootq] = rootp;
            sz[rootp] += sz[rootq];
        } else {
            id[rootp] = rootq;
            sz[rootq] += sz[rootp];
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
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }
}
