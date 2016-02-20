package com.gansuer.algorithms.sort.queue;

import com.gansuer.algorithms.sort.Helper;

/**
 * TODO：need to test
 * Created by Frank on 1/18/2016.
 */
public class BinaryMaxPQ<V extends Comparable<V>> implements MaxPQ {

    /**
     * this array is begin from index 1 , index 0 is not used
     */
    private V[] vals;
    private int size;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 16;

    public BinaryMaxPQ() {
        new BinaryMaxPQ(DEFAULT_CAPACITY);
    }

    public BinaryMaxPQ(int capacity) {
        vals = (V[]) new Comparable[capacity];
        this.capacity = capacity;
    }

    @Override
    public Comparable max() {
        if (isEmpty()) return null;
        return vals[1];
    }

    @Override
    public Comparable delMax() {
        if (isEmpty()) return null;
        V val = vals[1];
        Helper.swap(vals, 1, size);
        vals[size--] = null;
        sink(1);
        return val;
    }

    @Override
    public void insert(Comparable key) {
        if (size < capacity - 1) {
            vals[++size] = (V) key;
            swim(size);
        } else if (Helper.less(vals[size], key)) { // this array is full
            vals[size] = (V) key;
            swim(size);
        }

    }

    /**
     * let the min element sink into a right position
     *
     * @param index
     */
    private void sink(int index) {
        while (2 * index <= size) {
            int k = 2 * index;
            if (k < size && Helper.less(vals[k], vals[k + 1])) {
                k = k + 1;
            }
            if (Helper.less(vals[k], vals[index])) {
                break;
            }
            Helper.swap(vals, index, k);
            index = k;
        }
    }

    /**
     * let the greater element swim into a right position
     *
     * @param index
     */
    private void swim(int index) {
        while (index > 1 && Helper.less(vals[index / 2], vals[index])) {
            Helper.swap(vals, index, index / 2);
            index /= 2;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

}
