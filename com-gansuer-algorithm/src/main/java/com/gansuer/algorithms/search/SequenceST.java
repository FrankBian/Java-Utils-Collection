package com.gansuer.algorithms.search;

/**
 * Created by Frank on 1/9/2016.
 */
public interface SequenceST<K extends Comparable<K>, V> extends ST<K, V> {

    /**
     * the MIN Key
     * @return
     */
    K min();

    /**
     * the MAX key
     * @return
     */
    K max();

    /**
     * the MAX key in key set which are less than this specified key
     * @param key
     * @return
     */
    K floor(K key);

    /**
     * the MIN key in key set which are greater than this specified key
     * @param key
     * @return
     */
    K ceiling(K key);

    /**
     * the key number that which are less than this specified key
     * @param key
     * @return
     */
    int rank(K key);

    /**
     * return the k-rd key by sequences
     * @param k
     * @return
     */
    K select(int k);

    /**
     * Key in the set : low <= key < high
     * @param low
     * @param high
     * @return
     */
    Iterable<K> keys(K low, K high);
}
