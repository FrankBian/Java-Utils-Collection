package com.gansuer.algorithms.search;

import java.util.NoSuchElementException;

/**
 * Created by Frank on 3/1/16.
 */
public class BinarySearchTree<K extends Comparable<K>, V> implements SequenceST<K, V> {

    private BinaryTreeNode<K, V> root;

    public BinarySearchTree(BinaryTreeNode<K, V> root) {
        this.root = root;
    }

    /**
     * Empty Tree
     **/
    public BinarySearchTree() {
        root = null;
    }

    /**
     * the MIN Key
     *
     * @return
     */
    @Override
    public K min() {
        if (isEmpty()) throw new NoSuchElementException("BinaryTree is Empty");
        return (K) min(root).getKey();
    }

    private BinaryTreeNode min(BinaryTreeNode root) {
        if (root == null) throw new NullPointerException("argument to min() is null");
        if (root.getLeft() == null) return root;
        return min(root.getLeft());
    }

    /**
     * the MAX key
     *
     * @return
     */
    @Override
    public K max() {
        if (isEmpty()) throw new NoSuchElementException("BinaryTree is Empty");
        return (K) max(root).getKey();
    }

    private BinaryTreeNode max(BinaryTreeNode root) {
        if (root == null) throw new NullPointerException("argument to max() is null");
        if (root.getRight() == null) return root;
        return max(root.getRight());
    }

    /**
     * the MAX key in key set which are less than this specified key
     *
     * @param key
     * @return
     */
    @Override
    public K floor(K key) {
        if (isEmpty()) return null;
        BinaryTreeNode cur = find(key);
        if (cur != null) return (K) cur.getKey();
        return null;
    }

    private BinaryTreeNode floorNode(K key) {
        if (key == null) throw new NullPointerException("argument to floor() is null");
        if (isEmpty()) return null;
        BinaryTreeNode cur = find(key);
        if (cur != null) return cur;

        if (root.getKey().compareTo(key) > 0) { //left : root > key
            cur = root.getLeft();
            while (cur != null) {
                if (cur.getKey().compareTo(key) > 0) {
                    cur = cur.getLeft();
                } else {
                    if (cur.getRight() == null) break;
                    if (cur.getRight().getKey().compareTo(key) > 0) break;
                    cur = cur.getRight();
                }
            }
        } else { //right : root < key
            if (root.getRight() == null) return root;
            cur = root.getRight();
            while (cur != null) {
                if (cur.getKey().compareTo(key) > 0) { //left

                }
            }
        }
        return cur;
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
        if (isEmpty() || k > root.getN() || k < 1) {
            throw new IndexOutOfBoundsException("k =" + k + ", size = " + size());
        }
        return (K) select(k, root).getKey();
    }

    /**
     * @param k    [1,root.size]
     * @param root NotNull
     * @return
     */
    private BinaryTreeNode select(int k, BinaryTreeNode root) {
        if (k > root.getN() || k < 1) {
            throw new IndexOutOfBoundsException("k =" + k + ", node'size = " + root.getN());
        }
        if (k == root.getN()) return max(root);
        int sizeLeft = root.getLeft() == null ? 0 : root.getLeft().getN();
        if (k < sizeLeft) {
            return select(k, root.getLeft());
        }
        if (k == sizeLeft) {
            return max(root.getLeft());
        }
        if (k == sizeLeft + 1) {
            return root;
        }
        k = k - sizeLeft - 1;
        return select(k, root.getRight());

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
     * assume that it has no duplicated key
     *
     * @param key
     * @param value
     */
    @Override
    public void put(K key, V value) {
        BinaryTreeNode node = new BinaryTreeNode(key, value);
        if (isEmpty()) { // Empty tree
            root = node;
            return;
        }

        BinaryTreeNode cur = root;
        while (true) {
            cur.insertChild();
            if (cur.getKey().compareTo(key) > 0) { //left
                if (cur.getLeft() == null) {
                    cur.setLeft(node);
                    break;
                }
                cur = cur.getLeft();
            } else { //right
                if (cur.getRight() == null) {
                    cur.setRight(node);
                    break;
                }
                cur = cur.getRight();
            }
        }
    }

    /**
     * return the specified key's value
     *
     * @param key
     * @return
     */
    @Override
    public V get(K key) {
        BinaryTreeNode node = find(key);
        return node == null ? null : (V) node.getVal();
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
        return find(key) != null;
    }

    /**
     * find the BinaryTreeNode with the specified key
     *
     * @param key
     * @return
     */
    private BinaryTreeNode find(K key) {
        if (key == null) throw new NullPointerException("argument to get() is null");
        if (isEmpty()) return null;
        BinaryTreeNode cur = root;
        int res = 0;
        while (cur != null) {
            res = cur.getKey().compareTo(key);
            if (res == 0) return cur;
            else if (res < 0) cur = cur.getRight();
            else cur = cur.getLeft();
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        if (isEmpty()) return 0;
        return root.getN();
    }

    @Override
    public Iterable<K> keys() {
        return null;
    }
}
