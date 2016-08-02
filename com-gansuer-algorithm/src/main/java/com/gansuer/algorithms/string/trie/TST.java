package com.gansuer.algorithms.string.trie;

import java.util.List;

/**
 * 3-way Trie
 * Created by Frank on 8/2/2016.
 */
public class TST<V> implements StringST<V> {
    private Node root;

    public TST() {
        root = new Node();
    }

    @Override
    public void put(String key, V val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, V val, int d) {
        char ch = key.charAt(d);

        if (x == null) {
            x = new Node();
            x.c = ch;
        }
        if (ch < x.c) x.left = put(x.left, key, val, d);
        else if (ch > x.c) x.right = put(x.right, key, val, d);
        else if (d < key.length() - 1) x.mid = put(x.mid, key, val, d + 1);
        else x.val = val;
        return x;
    }

    @Override
    public V get(String key) {
        Node res = get(root, key, 0);
        return res == null ? null : res.val;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        char ch = key.charAt(d);
        if (ch < x.c) return get(x.left, key, d);
        else if (ch > x.c) return get(x.right, key, d);
        else if (d < key.length() - 1) return get(x.mid, key, d + 1);
        else return x;
    }

    @Override
    public void delete(String key) {

    }

    @Override
    public boolean contains(String key) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public String longestPrefixOf(String s) {
        return null;
    }

    @Override
    public List<String> keysWithPrefix(String s) {
        return null;
    }

    @Override
    public List<String> keysThatMatch(String pattern) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public List<String> keys() {
        return null;
    }

    private class Node {
        char c; // char
        Node left, mid, right;
        V val;
    }
}
