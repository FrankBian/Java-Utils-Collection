package com.gansuer.algorithms.string.trie;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Frank on 8/2/2016.
 */
public class TrieST<V> implements StringST<V> {

    private static final int R = 256; // 基数
    private Node root;

    private static class Node {
        private Object val;
        private Node[] next = new Node[R];
    }

    public TrieST() {
        root = new Node();
    }

    @Override
    public void put(String key, V val) {
        root = put(root, key, 0, val);
    }

    private Node put(Node x, String key, int d, V val) {
        if (x == null) x = new Node();
        if (d == key.length()) {
            x.val = val;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, d + 1, val);
        return x;
    }

    @Override
    public V get(String key) {
        Node res = get(root, key, 0);
        return res == null ? null : (V) res.val;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d);
        return get(x.next[c], key, d + 1);
    }

    @Override
    public void delete(String key) {
        root = delete(root, key, 0);
    }

    private Node delete(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) {
            x.val = null;
        } else {
            char ch = key.charAt(d);
            x.next[ch] = delete(x.next[ch], key, d + 1);
        }
        if (x.val != null) return x;
        for (char ch = 0; ch < R; ch++)
            if (x.next[ch] != null) return x;
        return null;
    }

    @Override
    public boolean contains(String key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        for (char ch = 0; ch < R; ch++)
            if (root.next[ch] != null) return false;
        return true;
    }

    @Override
    public String longestPrefixOf(String s) {
        int len = search(root, s, 0, 0);
        return s.substring(0, len);
    }

    private int search(Node x, String s, int d, int len) {
        if (x == null) return len;
        if (x.val != null) len = d;
        if (d == s.length()) return len;

        char ch = s.charAt(d);
        return search(x.next[ch], s, d + 1, len);
    }

    @Override
    public List<String> keysWithPrefix(String s) {
        List<String> res = new LinkedList<>();
        collect(get(root, s, 0), s, res);
        return res;
    }

    private void collect(Node node, String prefix, List<String> res) {
        if (node == null) return;
        if (node.val != null) res.add(prefix);
        for (char ch = 0; ch < R; ch++) {
            collect(node.next[ch], prefix + ch, res);
        }
    }

    @Override
    public List<String> keysThatMatch(String pattern) {
        List<String> res = new LinkedList<>();
        collect(root, "", pattern, res);
        return res;
    }

    private void collect(Node x, String prefix, String pattern, List<String> res) {

        int d = prefix.length();
        if (x == null) return;
        if (d == pattern.length() && x.val != null) res.add(prefix);
        if (d == pattern.length()) return;

        char next = pattern.charAt(d);
        for (char ch = 0; ch < R; ch++) {
            if (next == '.' || next == ch) {
                collect(x.next[ch], prefix + ch, pattern, res);
            }
        }
    }

    /**
     * lazy recursive implementation
     *
     * @return
     */
    @Override
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        int cnt = 0;
        if (x.val != null) cnt++;
        for (char ch = 0; ch < R; ch++) {
            cnt += size(x.next[ch]);
        }
        return cnt;
    }

    @Override
    public List<String> keys() {
        return keysWithPrefix("");
    }
}
