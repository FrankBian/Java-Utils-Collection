package com.gansuer.algorithms.sort;

/**
 * Created by Frank on 5/13/15.
 */
public class Insertion extends Sort {
    @Override
    public void sort(Comparable[] arr) {
        int len = arr.length;
        for (int i = 1 ; i < len ; i++){
            for (int j= i ; j >= 1 && less(arr[j],arr[j-1]) ; j--){
                exchange(arr,j,j-1);
            }
        }
    }
}
