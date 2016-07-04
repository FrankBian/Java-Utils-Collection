package com.gansuer.algorithms.search;

/**
 * Created by Frank on 3/24/2016.
 */
public class SeparateChainingHashST<K extends Comparable<K>, V> {
    private int size; // the count of K-getVertices pairs
    private int capacity;
    private BinarySearchST<K, V>[] container;

    public SeparateChainingHashST(int capacity) {
        this.capacity = capacity;
        container = new BinarySearchST[capacity];
        for (int i = 0; i < capacity; i++) {
            container[i] = new BinarySearchST<>();
        }
    }

    public SeparateChainingHashST() {
        this(997);
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    private V get(K key) {
        return container[hash(key)].get(key);
    }

    private void put(K key, V val) {
        container[hash(key)].put(key, val);
        size++;
    }

    public int size(){
        return size;
    }
}
