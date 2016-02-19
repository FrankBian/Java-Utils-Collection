package com.gansuer.algorithms.sort.queue;

/**
 * Created by Frank on 1/18/2016.
 */
public class Helper {

    static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    static void swap(Comparable[] arr, int i, int j){
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
