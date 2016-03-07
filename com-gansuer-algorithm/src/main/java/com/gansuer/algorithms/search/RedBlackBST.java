package com.gansuer.algorithms.search;

/**
 * Created by Frank on 3/7/16.
 */
public class RedBlackBST<K extends Comparable<K>, V> implements SequenceST<K, V> {
    /**
     * the MIN Key
     *
     * @return
     */
    @Override
    public K min() {
        return null;
    }

    /**
     * the MAX key
     *
     * @return
     */
    @Override
    public K max() {
        return null;
    }

    /**
     * the MAX key in key set which are less than this specified key
     *
     * @param key
     * @return
     */
    @Override
    public K floor(K key) {
        return null;
    }

    /**
     * the MIN key in key set which are greater than this specified key
     *
     * @param key
     * @return
     */
    @Override
    public K ceiling(K key) {
        return null;
    }

    /**
     * the key number that which are less than this specified key
     *
     * @param key
     * @return
     */
    @Override
    public int rank(K key) {
        return 0;
    }

    /**
     * return the k-rd key by sequences
     *
     * @param k
     * @return
     */
    @Override
    public K select(int k) {
        return null;
    }

    /**
     * Key in the set : low <= key < high
     *
     * @param low
     * @param high
     * @return
     */
    @Override
    public Iterable<K> keys(K low, K high) {
        return null;
    }

    /**
     * delete smallest key
     */
    @Override
    public void deleteMin() {

    }

    /**
     * delete largest key
     */
    @Override
    public void deleteMax() {

    }

    /**
     * insert one key-value pair
     *
     * @param key
     * @param value
     */
    @Override
    public void put(K key, V value) {

    }

    /**
     * return the specified key's value
     *
     * @param key
     * @return
     */
    @Override
    public V get(K key) {
        return null;
    }

    /**
     * remove the key-value pair from this ST
     *
     * @param key
     */
    @Override
    public void delete(K key) {

    }

    /**
     * @param key
     * @return
     */
    @Override
    public boolean contains(K key) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterable<K> keys() {
        return null;
    }
}
