package com.gansuer.algorithms.sort.queue;


/**
 * Created by Frank on 1/13/2016.
 */
public class UnorderArrayMaxPQ<K extends Comparable<K>> implements MaxPQ<K> {

    protected K[] values;
    protected int size;
    protected static final int DEFAULT_CAPACITY = 16;

    public UnorderArrayMaxPQ() {
        this(DEFAULT_CAPACITY);
    }

    public UnorderArrayMaxPQ(int capacity) {
        values = (K[]) new Comparable[capacity];
    }

    @Override
    public K max() {
        if (isEmpty()) return null;
        K max = values[0];
        for (int i = 1; i < size; i++) {
            if (values[i].compareTo(max) > 0) {
                max = values[i];
            }
        }
        return max;
    }

    @Override
    public K delMax() {
        if (isEmpty()) return null;
        int index = 0;
        for (int i = 1; i < size; i++) {
            if (values[i].compareTo(values[index]) > 0) {
                index = i;
            }
        }
        K res = values[index];
//        values[index] = null;
//        for (int i = index; i < size - 1; i++) {
//            values[index] = values[index + 1];
//        }
        if (index < size  -1){
            swap(values,index,size-1);
        }
        values[size-1] = null;
        size--;
        return res;
    }

    @Override
    public void insert(K key) {
        if (size < values.length) {
            values[size++] = key;
        } else {
            K min = values[0];
            int index = 0;
            for (int i = 1; i < size; i++) {
                if (min.compareTo(values[i]) > 0) {
                    index = i;
                }
            }
            values[index] = key;
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
