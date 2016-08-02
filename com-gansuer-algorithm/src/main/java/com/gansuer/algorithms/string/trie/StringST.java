package com.gansuer.algorithms.string.trie;

import java.util.List;

/**
 * Created by Frank on 8/2/2016.
 */
public interface StringST<V> {
    /**
     * insert a K-V into the ST, remove K-V if value is null
     *
     * @param key
     * @param val
     */
    void put(String key, V val);

    /**
     * return value associated with the specified Key, null returned if the key isn't contained
     *
     * @param key
     * @return
     */
    V get(String key);

    /**
     * remove the K-V associated with the specified Key
     *
     * @param key
     */
    void delete(String key);

    /**
     * return true if ST contains the K-V associated with the key, otherwise return false
     *
     * @param key
     * @return
     */
    boolean contains(String key);

    /**
     * if the ST is empty
     *
     * @return
     */
    boolean isEmpty();

    /**
     * return the longest key, which is one of the prefix of s
     *
     * @param s
     * @return
     */
    String longestPrefixOf(String s);

    /**
     * return all keys, which s is their prefix
     *
     * @param s
     * @return
     */
    List<String> keysWithPrefix(String s);

    /**
     * return all keys that match pattern
     * @param pattern
     * @return
     */
    List<String> keysThatMatch(String pattern);

    /**
     * the number of K-V pairs
     * @return
     */
    int size();

    /**
     * All keys
     * @return
     */
    List<String> keys();
}
