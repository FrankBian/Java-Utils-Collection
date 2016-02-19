package com.gansuer.algorithms.sort.queue;

/**
 * Created by Frank on 1/13/2016.
 */
public interface MaxPQ<K extends Comparable<K>> extends PriorityQueue<K> {

    /**
     * return the max element in the queue
     * @return
     */
    K max();

    /**
     * delete and return the max element in the queue
     * @return
     */
    K delMax();
}
