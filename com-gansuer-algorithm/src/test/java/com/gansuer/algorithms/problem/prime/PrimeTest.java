package com.gansuer.algorithms.problem.prime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 7/23/15.
 */
public class PrimeTest {
    private Prime prime;

    @Before
    public void setUp() throws Exception {
        prime = new Prime();
    }

    @Test
    public void testPrime() throws Exception {
        int limit = 100;
        int num = 10;
        int[] res = prime.prime(limit, num);

        for (int i = 0; i < num; i++) {
            System.out.print(res[i] + "   ");
        }

        Assert.assertNotNull(res);
    }
}