package com.gansuer.algorithms.sort.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Frank on 2/21/2016.
 */
public class IndexMinPQ<K extends Comparable> implements IndexPQ<K>, Iterable<Integer> {

    private static final int DEFAULT_CAPACITY = 16;

    private int capacity;
    // i is index of the keys[i]
    private K[] keys;
    //binary heap using 1-based indexing
    private int[] pq;
    //inverse of pq : qp[pq[i]] = i(pq)  pq[qp[i]] = i(qp)
    private int[] qp;
    //the number of priority queue
    private int size;

    public IndexMinPQ() {
        this(DEFAULT_CAPACITY);
    }

    public IndexMinPQ(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException();
        this.capacity = capacity;
        keys = (K[]) new Comparable[capacity + 1];
        pq = new int[capacity + 1];
        qp = new int[capacity + 1];
        for (int i = 0; i < qp.length; i++) {
            qp[i] = -1;
        }
    }

    /**
     * return the minimal Item
     *
     * @return
     */
    public K min() {
        return minKey();
    }

    /**
     * return the minimal Item's index
     *
     * @return
     */
    public int minIndex() {
        if (size == 0) throw new NoSuchElementException("Priority queue underflow");
        return pq[1];
    }

    /**
     * Returns a minimum key.
     *
     * @return a minimum key
     * @throws NoSuchElementException if this priority queue is empty
     */
    public K minKey() {
        if (size == 0) throw new NoSuchElementException("Priority queue underflow");
        return keys[pq[1]];
    }

    /**
     * remove the minimal Item and return its index
     *
     * @return
     */
    public int delMin() {
        if (size == 0) throw new NoSuchElementException("Priority queue underflow");
        int min = pq[1];
        exch(1, size--);
        sink(1);
        assert min == pq[size + 1];
        qp[min] = -1;        // delete
        keys[min] = null;    // to help with garbage collection
        pq[size + 1] = -1;        // not needed
        return min;
    }

    @Override
    public void insert(int k, Comparable item) {
        if (contains(k)) throw new IllegalArgumentException("index is already in the priority queue!");
        size++;
        qp[k] = size;
        pq[size] = k;
        keys[k] = (K) item;
        swim(size);
    }

    @Override
    public void change(int k, Comparable item) {
        if (!contains(k)) throw new NoSuchElementException("index is not in the priority queue");
        keys[k] = (K) item;
        swim(qp[k]);
        sink(qp[k]);
    }

    public void changeKey(int k, Comparable item) {
        change(k, item);
    }

    /**
     * Decrease the key associated with index <tt>i</tt> to the specified value.
     *
     * @param i   the index of the key to decrease
     * @param key decrease the key assocated with index <tt>i</tt> to this key
     * @throws IndexOutOfBoundsException unless 0 &le; <tt>i</tt> &lt; <tt>maxN</tt>
     * @throws IllegalArgumentException  if key &ge; key associated with index <tt>i</tt>
     * @throws NoSuchElementException    no key is associated with index <tt>i</tt>
     */
    public void decreaseKey(int i, K key) {
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        if (keys[i].compareTo(key) <= 0)
            throw new IllegalArgumentException("Calling decreaseKey() with given argument would not strictly decrease the key");
        keys[i] = key;
        swim(qp[i]);
    }

    /**
     * Increase the key associated with index <tt>i</tt> to the specified value.
     *
     * @param i   the index of the key to increase
     * @param key increase the key assocated with index <tt>i</tt> to this key
     * @throws IndexOutOfBoundsException unless 0 &le; <tt>i</tt> &lt; <tt>maxN</tt>
     * @throws IllegalArgumentException  if key &le; key associated with index <tt>i</tt>
     * @throws NoSuchElementException    no key is associated with index <tt>i</tt>
     */
    public void increaseKey(int i, K key) {
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        if (keys[i].compareTo(key) >= 0)
            throw new IllegalArgumentException("Calling increaseKey() with given argument would not strictly increase the key");
        keys[i] = key;
        sink(qp[i]);
    }

    /**
     * Returns the key associated with index <tt>i</tt>.
     *
     * @param i the index of the key to return
     * @return the key associated with index <tt>i</tt>
     * @throws IndexOutOfBoundsException unless 0 &le; <tt>i</tt> &lt; <tt>maxN</tt>
     * @throws NoSuchElementException    no key is associated with index <tt>i</tt>
     */
    public K keyOf(int i) {
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        else return keys[i];
    }

    @Override
    public boolean contains(int k) {
        checkIndex(k);
        return qp[k] != -1;
    }

    @Override
    public void delete(int i) {
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        int index = qp[i];
        exch(index, size--);
        swim(index);
        sink(index);
        keys[i] = null;
        qp[i] = -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= capacity) throw new IndexOutOfBoundsException();
    }

    /***************************************************************************
     * Heap helper functions.
     ***************************************************************************/
    private boolean greater(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }

    private void exch(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j < size && greater(j, j + 1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    /***************************************************************************
     * Iterators.
     ***************************************************************************/

    /**
     * Returns an iterator that iterates over the keys on the
     * priority queue in ascending order.
     * The iterator doesn't implement <tt>remove()</tt> since it's optional.
     *
     * @return an iterator that iterates over the keys in ascending order
     */
    public Iterator<Integer> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<Integer> {
        // create a new pq
        private IndexMinPQ<K> copy;

        // add all elements to copy of heap
        // takes linear time since already in heap order so no keys move
        public HeapIterator() {
            copy = new IndexMinPQ<K>(pq.length - 1);
            for (int i = 1; i <= size; i++)
                copy.insert(pq[i], keys[pq[i]]);
        }

        public boolean hasNext() {
            return !copy.isEmpty();
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
        public Integer next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.delMin();
        }
    }

}
