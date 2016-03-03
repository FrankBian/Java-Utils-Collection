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
        if (key == null) throw new IllegalArgumentException("argument to floor() is null");
        if (isEmpty()) throw new NoSuchElementException("BinaryTree is Empty");
        BinaryTreeNode res = floor(key, root);
        return res == null ? null : (K) res.getKey();
    }

    private BinaryTreeNode floor(K key, BinaryTreeNode root) {
        if (root == null) return null;
        int res = root.getKey().compareTo(key);
        if (res == 0) return root;
        if (res > 0) return floor(key, root.getLeft());
        BinaryTreeNode temp = floor(key, root.getRight());
        return temp == null ? root : temp;
    }

    /**
     * the MIN key in key set which are greater than this specified key
     *
     * @param key
     * @return
     */
    @Override
    public K ceiling(K key) {
        if (key == null) throw new IllegalArgumentException("argument to ceiling() is null");
        if (isEmpty()) throw new NoSuchElementException("BinaryTree is Empty");
        BinaryTreeNode res = ceiling(key, root);
        return res == null ? null : (K) res.getKey();
    }

    private BinaryTreeNode ceiling(K key, BinaryTreeNode root) {
        if (root == null) return null;
        int res = root.getKey().compareTo(key);
        if (res == 0) return root;
        if (res < 0) return ceiling(key, root.getRight());
        BinaryTreeNode temp = ceiling(key, root.getLeft());
        return temp == null ? root : temp;
    }

    /**
     * the key number that which are less than this specified key
     *
     * @param key
     * @return
     */
    @Override
    public int rank(K key) {
        if (key == null) throw new IllegalArgumentException("argument to rank() is null");
        if (isEmpty()) throw new IllegalStateException("BinaryTree is Empty");

        return rank(key, root);
    }

    public int rank(K key, BinaryTreeNode root) {
        if (root == null) return 0;
        int sizeLeft = root.getLeft() == null ? 0 : root.getLeft().getN();
        int temp = root.getKey().compareTo(key);
        if (temp == 0) return sizeLeft + 1;
        if (temp > 0) return rank(key, root.getLeft());
        return sizeLeft + 1 + rank(key, root.getRight());
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
     * delete smallest key
     */
    @Override
    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("BinaryTree is Empty");
        if (root.getLeft() == null) {
            root = root.getRight();
            return;
        }
        BinaryTreeNode parent = root, min = parent.getLeft();
        while (min.getLeft() != null) {
            parent.deleteChild();
            parent = min;
            min = parent.getLeft();
        }
        if (min.getRight() == null) {
            parent.setLeft(null);
            parent.deleteChild();
            return;
        }
        parent.setLeft(min.getRight());
        parent.setN(size(parent));
    }

    /**
     * delete largest key
     */
    @Override
    public void deleteMax() {
        if (isEmpty()) throw new NoSuchElementException("BinaryTree is Empty");
        if (root.getRight() == null) {
            root = root.getLeft();
            return;
        }
        BinaryTreeNode parent = root, max = parent.getRight();
        while (max.getRight() != null) {
            parent.deleteChild();
            parent = max;
            max = parent.getRight();
        }
        if (max.getLeft() == null) {
            parent.setRight(null);
            parent.deleteChild();
            return;
        }
        parent.setRight(max.getLeft());
        parent.setN(size(parent));
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
        //if (isEmpty()) throw new NoSuchElementException("BinaryTree is Empty");
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
        return isEmpty() ? 0 : root.getN();
    }

    private int size(BinaryTreeNode root) {
        if (root == null) return 0;
        int size = 1;
        if (root.getLeft() != null) size += root.getLeft().getN();
        if (root.getRight() != null) size += root.getRight().getN();
        return size;
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

    @Override
    public Iterable<K> keys() {
        return null;
    }
}
