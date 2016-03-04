package com.gansuer.algorithms.search;

/**
 * Bianry Tree Node
 * Created by Frank on 3/1/16.
 */
public class BinaryTreeNode<K extends Comparable<K>, V> {

    private K key;
    private V val;
    private BinaryTreeNode<K, V> left;
    private BinaryTreeNode<K, V> right;
    private int n; // the node count in the subtree rooted at this node

    public BinaryTreeNode(K key, V val) {
        //if (key == null) throw new IllegalArgumentException("key is null");
        //if (val == null) throw new IllegalArgumentException("val is null");
        this.val = val;
        this.key = key;
        this.n = 1;
        this.left = null;
        this.right = null;
    }

    public K getKey() {
        return key;
    }

    public BinaryTreeNode setKey(K key) {
        this.key = key;
        return this;
    }

    public V getVal() {
        return val;
    }

    public BinaryTreeNode setVal(V val) {
        this.val = val;
        return this;
    }

    public BinaryTreeNode<K, V> getLeft() {
        return left;
    }

    public BinaryTreeNode setLeft(BinaryTreeNode<K, V> left) {
        this.left = left;
        return this;
    }

    public BinaryTreeNode<K, V> getRight() {
        return right;
    }

    public BinaryTreeNode setRight(BinaryTreeNode<K, V> right) {
        this.right = right;
        return this;
    }

    public int getN() {
        return n;
    }

    public BinaryTreeNode setN(int n) {
        this.n = n;
        return this;
    }

    public void insertChild() {
        this.n += 1;
    }

    public void deleteChild() {
        this.n -= 1;
    }
}
