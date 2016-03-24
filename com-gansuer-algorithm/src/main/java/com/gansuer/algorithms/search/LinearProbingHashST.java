package com.gansuer.algorithms.search;

/**
 * Created by Frank on 3/24/2016.
 */
public class LinearProbingHashST<K, V> {

    private int size;
    private int capacity;
    private K[] keys;
    private V[] values;

    public LinearProbingHashST() {
        this(16);
    }

    public LinearProbingHashST(int capacity) {
        this.capacity = capacity;
        keys = (K[]) new Object[capacity];
        values = (V[]) new Object[capacity];
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    public void put(K key, V val) {
        if (size > capacity / 2) resize(capacity * 2);
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % capacity) {
            if (keys[i].equals(key)) {
                values[i] = val;
                return;
            }
        }
        keys[i] = key;
        values[i] = val;
        size++;
    }

    private void resize(int newCapacity) {
        LinearProbingHashST<K,V> temp = new LinearProbingHashST<>(newCapacity);
        for (int i= 0; i < capacity;i++){
            if (keys[i] != null){
                temp.put(keys[i],values[i]);
            }
        }
        keys = temp.keys;
        values = temp.values;
        capacity = temp.capacity;
    }

    public V get(K key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % capacity) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    public int size(){
        return size;
    }
}
