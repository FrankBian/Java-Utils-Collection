package com.gansuer.algorithms.search;

/**
 * Binary Search implementation
 * more details offered in Array.java
 * Created by Frank on 4/17/15.
 */
public class BinarySearch {


    /**
     * search the key between begin and end
     *
     * @param arr   a sorted array
     * @param key   the key you want to search
     * @param begin
     * @param end
     * @return the index of the key
     */
    public static int binarySearch(int[] arr, int key, int begin, int end) {
        if (begin >= end) {
            return -1;
        }
        int mid = (begin + end) / 2;
        if (arr[mid] == key) {
            return mid;
        } else if (arr[mid] < key) {
            return binarySearch(arr, key, mid + 1, end);
        } else {
            return binarySearch(arr, key, begin, mid);
        }
    }

    /**
     * search the key between <code>from</code> and <code>to</code>
     *
     * @param arr  a sorted array
     * @param key  the target you want to search
     * @param from >= <code>from</code>
     * @param to   < <code>to</code>
     * @return the index of the key
     */
    public static int binarySearchByLoop(int[] arr, int key, int from, int to) {
        while (from <= to) {
            int mid = from + (to - 1 - from) / 2;
            if (key < arr[mid])
                to = mid - 1;
            else if (key > arr[mid])
                from = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int a) {
        return binarySearch(arr, a, 0, arr.length - 1);
    }


}
