package com.gansuer.algorithms.problem.prime;

/**
 * Created by Frank on 7/23/15.
 */
public class Prime {

    /**
     * top Num primes less than N
     *
     * @param limit
     * @param num
     * @return
     */
    public int[] prime(int limit, int num) {
        boolean[] primes = new boolean[limit + 1];
        for (int i = 2; i <= limit; i++) {
            primes[i] = true;
        }

        for (int i = 2; i <= Math.sqrt(limit); i++) {
            if (primes[i]) {
                for (int j = 2 * i; j <= limit; j = j + i) {
                    primes[j] = false;
                }
            }
        }
        int[] res = new int[num];
        int len = 0;
        for (int i = 2; i <= limit && len < num; i++) {
            if (primes[i]) {
                res[len++] = i;
            }
        }
        return res;
    }
}
