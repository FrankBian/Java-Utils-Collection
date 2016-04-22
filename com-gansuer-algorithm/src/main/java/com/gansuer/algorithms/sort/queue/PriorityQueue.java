package com.gansuer.algorithms.sort.queue;

/**
 * Created by Frank on 1/13/2016.
 */
public interface PriorityQueue<K extends Comparable<K>> {

    /**
     * insert one key into the queue
     *
     * @param key
     */
    void insert(K key);

    /**
     * return true only if the queue is empty
     *
     * @return
     */
    boolean isEmpty();

    /**
     * return the element number of this queue
     *
     * @return
     */
    int size();

    default boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    default void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
