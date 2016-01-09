package com.gansuer.algorithms.sort;

/**
 * Created by Frank on 7/26/15.
 * <p>
 * Bottom to up
 */
public class MergeX extends Sort {

    private Comparable[] tmp = null;

    @Override
    public void sort(Comparable[] arr) {
        int len = arr.length;
        tmp = new Comparable[len];
        for (int sz = 1; sz < len; sz += sz) {
            for (int low = 0; low < len - sz; low += sz + sz) {
                merge(arr, low, low + sz - 1, Math.min(low + sz + sz + -1, len - 1));
            }
        }
    }

    private void merge(Comparable[] arr, int low, int mid, int high) {
        for (int k = low; k <= high; k++) {
            tmp[k] = arr[k];
        }
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) arr[k] = tmp[j++];   // this copying is unnecessary
            else if (j > high) arr[k] = tmp[i++];
            else if (less(tmp[j], tmp[i])) arr[k] = tmp[j++];
            else arr[k] = tmp[i++];
        }
    }
}
