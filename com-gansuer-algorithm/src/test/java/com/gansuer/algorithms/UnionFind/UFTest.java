package com.gansuer.algorithms.UnionFind;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 9/18/15.
 */
public class UFTest {

    private UF quickFind ;
    private UF quickUnion ;
    private UF weightUnion ;
    @Before
    public void setUp() throws Exception {
        quickFind = new QuickFind(10);
        weightUnion = new WeightQuickUnion(10);
    }

    @Test
    public void testUnion() throws Exception {
        quickFind.union(0,6);
        quickFind.union(8,6);
        quickFind.union(3,6);
        quickFind.union(6,7);
        quickFind.union(5,9);
        quickFind.union(2,7);
        quickFind.printId();
    }
    @Test
    public void testUnion1() throws Exception {
        weightUnion.union(6,7);
        weightUnion.union(9,2);
        weightUnion.union(0,1);
        weightUnion.union(4,5);
        weightUnion.union(0,2);
        weightUnion.union(3,7);
        weightUnion.union(5,7);
        weightUnion.union(4,1);
        weightUnion.union(2,8);
        weightUnion.printId();
    }

    @Test
    public void testFind() throws Exception {

    }

    @Test
    public void testConnected() throws Exception {

    }

    @Test
    public void testCount() throws Exception {

    }


}