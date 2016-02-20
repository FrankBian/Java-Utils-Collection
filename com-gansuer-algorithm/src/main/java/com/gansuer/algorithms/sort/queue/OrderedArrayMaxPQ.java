package com.gansuer.algorithms.sort.queue;

/**
 * Created by Frank on 1/14/2016.
 */
public class OrderedArrayMaxPQ<K extends Comparable<K>> extends UnorderArrayMaxPQ {

    public OrderedArrayMaxPQ() {
        super();
    }

    public OrderedArrayMaxPQ(int capacity) {
        super(capacity);
    }

    @Override
    public Comparable delMax() {
        if (isEmpty()) return null;
        Comparable res = values[--size];
        values[size] = null;
        return res;
    }

    /**
     * the array is ASC ordered
     *
     * @param key
     */
    @Override
    public void insert(Comparable key) {
        int index = 0;
        for (; index < size; index++) {
            if (values[index].compareTo(key) > 0) {
                break;
            }
        }
        if (size < values.length) {
            if (index == size) {
                values[size++] = key;
                return;
            }
            for (int i = size - 1; i > index; i--) {
                values[i + 1] = values[i];
            }
            values[index] = key;
            size++;
            return;
        }
        // the array is full of element
        for (int i = 1; i < index; i++) {
            values[i - 1] = values[i];
        }
        values[index - 1] = key;
    }

    @Override
    public Comparable max() {
        if (isEmpty()) return null;
        return values[size-1];
    }
}
