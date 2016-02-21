package com.gansuer.algorithms.sort.queue;

/**
 * Index priority queue. In many applications,
 * it makes sense to allow clients to refer to items that are already on the priority queue.
 * One easy way to do so is to associate a unique integer index with each item.
 * Created by Frank on 2/21/2016.
 */
public interface IndexPQ<K extends Comparable>{

    /**
     * insert Item, associate with K
     * @param K
     * @param item
     */
    void insert(int K, K item);

    /**
     * change Item associated with K to item
     * @param K index
     * @param item
     */
    void change(int K, K item);

    /**
     * is K associated with some Item
     * @param k
     * @return
     */
    boolean contains(int k);

    /**
     * remove K and item associated with K
     * @param k
     */
    void delete(int k);

    /**
     * is priority queue empty
     * @return
     */
    boolean isEmpty();

    /**
     * number of items in the priority queue
     * @return
     */
    int size();
}
