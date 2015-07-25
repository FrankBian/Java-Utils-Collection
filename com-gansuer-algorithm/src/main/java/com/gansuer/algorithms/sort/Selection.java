package com.gansuer.algorithms.sort;

/**
 * Created by Frank on 5/13/15.
 */
public class Selection extends Sort {
    @Override
    public void sort(Comparable[] arr) {
        int len = arr.length;
        for (int i = 0; i< len; i++){
            int min = i ;
            for (int j= i+1; j < len; j++){
                if (less(arr[j],arr[min])){
                    min = j;
                }
            }
            exchange(arr,i,min);
        }
    }
}
