package com.gansuer.algorithms.problem.theKInArray;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Frank on 7/24/15.
 */
public class JavaSolution {

    public int theKofArray(int[] arr, int k) {
        if (arr == null || k < 1 || arr.length < k) {
            throw new IllegalArgumentException("invalid arguments");
        }
        Queue<Integer> priority = new PriorityQueue<>(k);
        for (int i = 0; i < arr.length; i++) {
            if (priority.size() == k) {
                int tmp = priority.poll();
                priority.add(Math.max(tmp, arr[i]));
            } else {
                priority.add(arr[i]);
            }
        }
        return priority.poll();
    }

    public Comparable kTurnInArray(Comparable[] arr, int k){
        if (arr == null || k < 1 || k > arr.length){
            throw  new IllegalArgumentException("invalid arguments");
        }
        int low = 0, high = arr.length -1, index = 0;
        while (low < high){
            index = partition(arr,low,high);
            if (index == k) return arr[k];
            else if (index < k) low = index+1;
            else high = index -1;
        }
        return arr[k];
    }

    private int partition(Comparable[] arr, int low, int high){
        Comparable key = arr[low];
        while (low < high){
            while (arr[high].compareTo(key) > 0 && low < high){
                high--;
            }
            if (low < high) {
                arr[low++] = arr[high];
            }
            while (arr[low].compareTo(key) < 0 && low < high){
                low++;
            }
            if (low < high){
                arr[high--] = arr[low];
            }
        }
        arr[low] = key;
        return low;
    }

}
