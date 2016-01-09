package com.gansuer.algorithms.search;

/**
 * symbol table
 * Created by Frank on 1/9/2016.
 */
public interface ST<K, V> {

    /**
     * insert one key-value pair
     *
     * @param key
     * @param value
     */
    void put(K key, V value);

    /**
     * return the specified key's value
     *
     * @param key
     * @return
     */
    V get(K key);

    /**
     * remove the key-value pair from this ST
     *
     * @param key
     */
    void delete(K key);

    /**
     * @param key
     * @return
     */
    boolean contains(K key);

    boolean isEmpty();

    int size();

    Iterable<K> keys();
}
