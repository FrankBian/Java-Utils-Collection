package com.gansuer.algorithms.sort;

/**
 * Created by Frank on 2/21/2016.
 */
public class Heap extends Sort {

    /**
     * Rearranges the array in ascending order, using the natural order.
     *
     * @param arr the array to be sorted
     */
    @Override
    public void sort(Comparable[] arr) {
        int n = arr.length;
        for (int k = n / 2; k >= 0; k--)
            sink(arr, n, k);
        while (n > 0) {
            exchange(arr, 0, --n);
            sink(arr, n, 0);
        }
    }

    /**
     * 0-based binary heap array
     * @param arr
     * @param len array's length
     * @param i
     */
    private void sink(Comparable[] arr, int len, int i) {
        while (2 * i + 1 < len) {
            int j = 2 * i + 1;
            if (j + 1 < len && less(arr[j], arr[j + 1])) j++;
            if (less(arr[j], arr[i])) break;
            exchange(arr, i, j);
            i = j;
        }
    }
}
