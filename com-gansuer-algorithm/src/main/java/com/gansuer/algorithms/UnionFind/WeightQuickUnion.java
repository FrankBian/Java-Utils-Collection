package com.gansuer.algorithms.UnionFind;

/**
 * Created by Frank on 9/16/15.
 */
public class WeightQuickUnion extends UF {
    private int[] sz;

    public WeightQuickUnion(int count) {
        this.count = count;
        id = new int[count];
        sz = new int[count];
        for (int i = 0; i < count; i++){
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
        if (sz[p] > sz[q]){
            id[rootq] = rootp;
            sz[p] += sz[q];
        }else {
            id[rootp] = rootq;
            sz[q] += sz[p];
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
        while (p != id[p]){
            p = id[p];
        }
        return p;
    }
}
