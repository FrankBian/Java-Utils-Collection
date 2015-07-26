package com.gansuer.algorithms.sort;

/**
 * Created by Frank on 7/26/15.
 * Top to Down
 */
public class Merge extends Sort {

    @Override
    public void sort(Comparable[] arr) {
        Comparable[] aux = new Comparable[arr.length];
        sort(arr, aux, 0, arr.length - 1);
    }

    private void sort(Comparable[] arr, Comparable[] tmp, int low, int high) {
        if (high <= low) return;
        int mid = (high + low) / 2;
        sort(arr, tmp, low, mid);
        sort(arr, tmp, mid + 1, high);
//        merge(arr, tmp, low, mid, high);
        if (less(arr[mid+1],arr[mid])){  //Enhancing
            merge(arr, tmp, low, mid, high);
        }
    }

    private void merge(Comparable[] arr, Comparable[] tmp, int low, int mid, int high) {
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
