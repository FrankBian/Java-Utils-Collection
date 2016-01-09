package com.gansuer.algorithms.sort;


import com.gansuer.stdlib.StdRandom;
import com.gansuer.stdlib.Stopwatch;

/**
 * Created by Frank on 7/26/15.
 */
public class SortCompare {

    public static double time(String alg, Comparable[] arr) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) new Insertion().sort(arr);
        if (alg.equals("InsertionX")) new Insertion().sortX(arr);
        if (alg.equals("Selection")) new Selection().sort(arr);
        if (alg.equals("Shell")) new Shell().sort(arr);
        if (alg.equals("Merge")) new Merge().sort(arr);
        if (alg.equals("QuickSort")) new QuickSort().sort(arr);
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) {
        // use alg to sort T arrays which length is N
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }


}
