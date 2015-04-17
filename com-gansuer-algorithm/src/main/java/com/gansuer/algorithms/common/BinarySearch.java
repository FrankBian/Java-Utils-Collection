package com.gansuer.algorithms.common;

/**
 * 数组的二分查找
 * Arrays.java 中提供更为详细的内容
 *
 * Created by Frank on 4/17/15.
 */
public class BinarySearch {


    /**
     * 数组必须有序
     * 在begin和end之间查找 ，包括end
     *
     * @param arr
     * @param key
     * @param begin
     * @param end
     * @return
     */
    public static int binarySearch(int[] arr, int key , int begin, int end){
        if (begin >= end){
            return -1;
        }
        int mid = ( begin + end ) / 2 ;
        if (arr[mid] == key){
            return mid;
        }else if(arr[mid] < key){
            return binarySearch(arr,key,mid+1,end);
        }else{
            return binarySearch(arr,key,begin,mid);
        }
    }

    /**
     * 数组必须有序
     * 在 from 和 to 之间查找，不包括 to
     * @param arr
     * @param key
     * @param from
     * @param to
     * @return
     */
    public static int binarySearchByLoop(int[] arr,int key , int from , int to){
        while (from <= to){
            int mid = from + ( to -1 - from) / 2 ;
            if (key < arr[mid])
                to = mid -1;
            else if(key > arr[mid])
                from = mid +1;
            else
                return mid;
        }
        return -1 ;
    }

    public static int binarySearch(int[] arr, int a ){
        return binarySearch(arr,a,0, arr.length -1);
    }


}
