package com.gansuer.algorithms.sort;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Frank on 7/26/15.
 */
public class SortCompareTest {

    @Test
    public void testTimeRandomInput() throws Exception {
        String alg1 = "Insertion";
        String alg2 = "Selection";
        int N = 10000;
        int T = 1000;

        double t1 = SortCompare.timeRandomInput(alg1,N,T);
        double t2 = SortCompare.timeRandomInput(alg2,N,T);

        System.out.println("1000 random doubles total time :");
        System.out.println(alg1 +" : " + t1);
        System.out.println(alg2 +" : " + t2);
        System.out.println("rate(Insertion/Selection) : " + t1/t2);
        System.out.println("rate(Selection/Insertion) : " + t2/t1);

        Assert.assertTrue(t1 < t2);
        Assert.assertTrue(t2/t1 > 1);

    }
}