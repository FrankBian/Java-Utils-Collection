package com.gansuer.algorithms.sort;

/**
 * Created by Frank on 8/2/15.
 */
public class QuickSort extends Sort {

    @Override
    public void sort(Comparable[] arr) {
        if (arr == null || arr.length < 2) return;
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(Comparable[] arr, int low, int high) {
        if (high <= low) return;

        int mid = partitionX(arr, low, high);
        quickSort(arr, low, mid - 1);
        quickSort(arr, mid + 1, high);
    }


    private int partition(Comparable[] arr, int low, int high) {
        int i = low, j = high + 1;
        Comparable key = arr[low];
        while (true) {
            while (less(arr[++i], key)) if (i == high) break;
            while (less(key, arr[--j])) if (j == low) break;
            if (i >= j) break;
            exchange(arr, i, j);
        }
        exchange(arr, low, j);
        return j;
    }

    private int partitionX(Comparable[] arr, int low, int high) {
        Comparable key = arr[low];
        while (low < high) {
            while (arr[high].compareTo(key) > 0 && low < high) {
                high--;
            }
            if (low < high) {
                arr[low++] = arr[high];
            }
            while (arr[low].compareTo(key) <= 0 && low < high) {
                low++;
            }
            if (low < high) {
                arr[high--] = arr[low];
            }
        }
        arr[low] = key;
        return low;
    }
}
