package com.gansuer.algorithms.sort;

/**
 * Created by Frank on 5/13/15.
 *
 * to use the TemplatePattern
 *
 * this can be applied to all objects that implement  Comparable interface
 */
public abstract class Sort {

    public abstract void sort(Comparable[] arr);

    /**
     * change the position of this two elements
     * @param arr
     * @param i
     * @param j
     */
    protected static void exchange(Comparable[] arr, int i , int j){
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     *
     * @param a
     * @param b
     * @return true if a < b , otherwise false returned
     */
    protected static boolean less(Comparable a , Comparable b){
        return a.compareTo(b) < 0;
    }
    public static boolean isSorted(Comparable[] arr){
        for (int i = 1 ; i < arr.length ; i++){
            if (less(arr[i],arr[i-1])){
                return false;
            }
        }
        return true;
    }
}