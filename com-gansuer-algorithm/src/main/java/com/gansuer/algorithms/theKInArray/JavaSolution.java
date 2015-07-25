package com.gansuer.algorithms.theKInArray;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Frank on 7/24/15.
 */
public class JavaSolution {

    public int theKofArray(int[] arr, int k){
        if (arr == null || k < 1 || arr.length < k){
            throw new IllegalArgumentException("invalid arguments");
        }
        Queue<Integer> priority = new PriorityQueue<Integer>(k);
        for (int i = 0 ; i < arr.length ;i++){
            if (priority.size() == k){
                int tmp = priority.poll();
                priority.add(Math.max(tmp,arr[i]));
            }else {
                priority.add(arr[i]);
            }
        }
//        System.out.println(priority.poll());
        return priority.poll();
    }
}
