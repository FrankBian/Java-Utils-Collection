package com.gansuer.algorithms.sort;

import com.gansuer.algorithms.stdlib.StdRandom;

/**
 * Created by Frank on 7/26/16.
 */
public class Quick3Way implements Sort {


    @Override
    public void sort(Comparable[] arr) {
        StdRandom.shuffle(arr);
        sort(arr, 0, arr.length - 1);
        assert isSorted(arr);
    }

    private void sort(Comparable[] arr, int low, int high) {
        if (high <= low) return;
        int lt = low, gt = high;
        Comparable val = arr[low];

        int i = low;
        while (i <= gt) {
            int cmp = arr[i].compareTo(val);
            if (cmp < 0) exchange(arr, lt++, i);
            else if (cmp > 0) exchange(arr, i, gt--);
            else i++;
        }
        // arr[low,lt) < val = arr[lt,gt] < arr(gt,high]
        sort(arr, low, lt - 1);
        sort(arr, gt + 1, high);
    }
}
