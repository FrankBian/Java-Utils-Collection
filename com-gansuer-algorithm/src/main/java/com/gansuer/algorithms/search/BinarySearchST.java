package com.gansuer.algorithms.search;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Created by Frank on 1/9/2016.
 */
public class BinarySearchST<K extends Comparable<K>, V> implements SequenceST<K, V> {

    private K[] keys;
    private V[] values;
    private int size;
    private int capacity; // array capacity
    private static final int DEFAULT_CAPACITY = 16;

    public BinarySearchST() {
        new BinarySearchST(DEFAULT_CAPACITY);
    }

    public BinarySearchST(int capacity) {
        this.capacity = capacity;
        keys = (K[]) new Comparable[capacity];
        values = (V[]) new Object[capacity];
    }

    @Override
    public K min() {
        return keys[0];
    }

    @Override
    public K max() {
        return keys[size - 1];
    }

    @Override
    public K floor(K key) {
        if (key == null) throw new NullPointerException("argument to floor() is null");
        int index = rank(key);
        if (index < size && key.compareTo(keys[index]) == 0) return keys[index];
        if (index == 0) return null;
        return keys[index - 1];
    }

    @Override
    public K ceiling(K key) {
        if (key == null) throw new NullPointerException("argument to ceiling() is null");
        int index = rank(key);
        if (index == size) return null;
        return keys[index];
    }

    /**
     * this algorithm is Binary-Search-Based
     *
     * @param key
     * @return
     */
    @Override
    public int rank(K key) {
        int low = 0, high = size - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int comparable = key.compareTo(keys[mid]);
            if (comparable < 0) {
                high = mid - 1;
            } else if (comparable > 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }

    @Override
    public K select(int k) {
        return keys[k];
    }

    @Override
    public void put(K key, V value) {
        int i = rank(key);
        if (i < size && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }
        for (int j = size; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        size++;
    }

    @Override
    public V get(K key) {
        if (isEmpty()) return null;
        int index = rank(key);
        if (index < size && keys[index].compareTo(key) == 0) return values[index];
        return null;
    }

    @Override
    public void delete(K key) {
        if (key == null) throw new NullPointerException("argument to delete() is null");
        if (isEmpty()) return;
        int index = rank(key);
        //kye not in table
        if (index == size || keys[index].compareTo(key) != 0) return;
        for (int i = index; i < size - 1; i++) {
            keys[i] = keys[i + 1];
            values[i] = values[i + 1];
        }
        size--;
        keys[size] = null;
        values[size] = null;

    }

    @Override
    public boolean contains(K key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterable<K> keys() {
        return keys(min(), max());
    }

    @Override
    public Iterable<K> keys(K low, K high) {
        Queue<K> queue = new LinkedList<>();
        int lowIndex = rank(low), highIndex = rank(high);
        for (int i = lowIndex; i < highIndex; i++) {
            queue.add(keys[i]);
        }
        if (contains(high)) queue.add(keys[highIndex]);
        return queue;
    }

    /**
     * delete smallest key
     */
    @Override
    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow error");
        delete(min());
    }

    /**
     * delete largest key
     */
    @Override
    public void deleteMax() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow error");
        delete(max());
    }

    /**
     * Check internal invariants.
     * @return
     */

    public boolean check() {
        return isSorted() && rankCheck();
    }

    /**
     * check that rank(select(i))==i
     */
    private boolean rankCheck() {
        for (int i = 0; i < size(); i++) {
            if (i != rank(select(i))) return false;
        }
        for (int i = 0; i < size(); i++) {
            if (keys[i].compareTo(select(rank(keys[i]))) != 0) return false;
        }
        return true;
    }

    private boolean isSorted() {
        for (int i = 1; i < size(); i++) {
            if (keys[i].compareTo(keys[i - 1]) < 0) return false;
        }
        return true;
    }
}
