package com.gansuer.algorithms.sort;

/**
 * Created by Frank on 7/26/15.
 */
public class Shell extends Sort {
    @Override
    public void sort(Comparable[] arr) {
        int len = arr.length;
        int h = 1;
        while(h < len/3){
            h = 3*h +1;
        }
        while (h >= 1){
            for (int i = h ; i < len; i++){
                for (int j= i; j >= h && less(arr[j],arr[j-h]); j -= h){
                    exchange(arr,j,j-h);
                }
            }
            h = h/3;
        }
    }
}
