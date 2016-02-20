package com.gansuer.algorithms.sort;

/**
 * Created by Frank on 1/18/2016.
 */
public class Helper {

    public static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    public static void swap(Comparable[] arr, int i, int j){
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
