package com.gansuer.algorithms.UnionFind;

/**
 * Created by Frank on 9/16/15.
 */
public abstract class UF {

    protected int[] id;
    protected int count;
    /**
     * connect p and q
     * @param p
     * @param q
     */
    public abstract void union(int p,int q);

    /**
     * find p's identify
     * @param p
     * @return
     */
    public abstract int find(int p);

    /**
     * judge if p connects with q
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p , int q){
        return find(p) == find(q);
    }

    /**
     * number of connected component
     * @return
     */
    protected int count(){
        return count;
    }

    protected void printId(){
        for (int i= 0; i< id.length ; i++){
            System.out.print(id[i] + " ");
        }
    }
}
