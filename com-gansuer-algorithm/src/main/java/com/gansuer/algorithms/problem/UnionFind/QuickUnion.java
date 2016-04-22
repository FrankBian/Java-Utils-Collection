package com.gansuer.algorithms.problem.unionFind;

/**
 * Created by Frank on 9/16/15.
 */
public class QuickUnion extends UF {

    public QuickUnion(int count) {
        this.count = count;
        id = new int[count];
        for (int i = 0; i < count; i++) {
            id[i] = i;
        }
    }

    /**
     * connect p and q
     *
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int rootp = find(p);
        int rootq = find(q);
        if (rootp == rootq) return;
        id[rootp] = rootq;
        count--;
    }

    /**
     * find p's identify
     *
     * @param p
     * @return
     */
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }


}
