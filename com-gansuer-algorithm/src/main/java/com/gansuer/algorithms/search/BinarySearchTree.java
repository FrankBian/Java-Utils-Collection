package com.gansuer.algorithms.search;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

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
     * Return the number of keys in the symbol table strictly less than <tt>key</tt>.
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

    private int rank(K key, BinaryTreeNode root) {
        if (root == null) return 0;
        int sizeLeft = root.getLeft() == null ? 0 : root.getLeft().getN();
        int temp = root.getKey().compareTo(key);
        if (temp == 0) return sizeLeft;
        if (temp > 0) return rank(key, root.getLeft());
        return sizeLeft + 1 + rank(key, root.getRight());
    }

    /**
     * return the k-rd key by sequences
     *
     * @param k [0,size())
     * @return
     */
    @Override
    public K select(int k) {
        if (isEmpty() || k >= root.getN() || k < 0) {
            throw new IndexOutOfBoundsException("k =" + k + ", size = " + size());
        }
        return (K) select(k, root).getKey();
    }

    /**
     * @param k    [0,size())
     * @param root NotNull
     * @return
     */
    private BinaryTreeNode select(int k, BinaryTreeNode root) {
        if (k >= root.getN() || k < 0) {
            throw new IndexOutOfBoundsException("k =" + k + ", node'size = " + root.getN());
        }
        int sizeLeft = size(root.getLeft());
        if (k < sizeLeft) return select(k, root.getLeft());
        if (k == sizeLeft) return root;
        return select(k - sizeLeft - 1, root.getRight());

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
        if (key == null) throw new NullPointerException("first argument to put is null");
        if (value == null) {
            delete(key);
            return;
        }

        root = put(root, key, value);
        assert check();
    }

    /**
     * recursive put method
     *
     * @param node
     * @param key
     * @param val
     * @return
     */
    private BinaryTreeNode put(BinaryTreeNode node, K key, V val) {
        if (node == null) return new BinaryTreeNode(key, val);
        int cmp = node.getKey().compareTo(key);
        if (cmp == 0) node.setVal(val);
        else if (cmp > 0) node.setLeft(put(node.getLeft(), key, val));
        else node.setRight(put(node.getRight(), key, val));

        node.setN(1 + size(node.getLeft()) + size(node.getRight()));
        return node;
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
        root = removeMin(root);

        assert check();
    }

    /**
     * remove the min key's node, and return root Node
     *
     * @return
     */
    private BinaryTreeNode removeMin(BinaryTreeNode root) {
        if (root == null) return null;
        BinaryTreeNode res = root;
        if (root.getLeft() == null) {
            res = root.getRight();
            return res;
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
        } else {
            parent.setLeft(min.getRight());
            parent.setN(size(parent));
        }
        return res;
    }

    /**
     * delete largest key
     */
    @Override
    public void deleteMax() {
        if (isEmpty()) throw new NoSuchElementException("BinaryTree is Empty");
        root = removeMax(root);

        assert check();
    }

    /**
     * remove the max key's node, and return it
     *
     * @return
     */
    private BinaryTreeNode removeMax(BinaryTreeNode root) {
        if (root == null) return null;
        BinaryTreeNode res = root;
        if (root.getRight() == null) {
            res = root.getLeft();
            return res;
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
        } else {
            parent.setRight(max.getLeft());
            parent.setN(size(parent));
        }
        return res;
    }

    /**
     * remove the key-value pair from this ST
     *
     * @param key
     */
    @Override
    public void delete(K key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        if (isEmpty()) throw new NoSuchElementException("BinaryTree is Empty");
        root = remove(key, root);

        assert check();
    }

    /**
     * @param key  NotNull
     * @param root
     * @return
     */
    private BinaryTreeNode remove(K key, BinaryTreeNode root) {
        if (root == null) return null;
        BinaryTreeNode temp = null;
        int res = root.getKey().compareTo(key);
        if (res == 0) {
            if (root.getLeft() == null && root.getRight() == null) { //left node
                return null;
            } else if (root.getLeft() != null) {
                temp = max(root.getLeft());
                root.setLeft(removeMax(root.getLeft()));
            } else {
                temp = min(root.getRight());
                root.setRight(removeMin(root.getRight()));
            }
            temp.setLeft(root.getLeft());
            temp.setRight(root.getRight());
            temp.setN(size(temp));
            return temp;
        } else if (res > 0) {
            root.setLeft(remove(key, root.getLeft()));
            return root;
        } else {
            root.setRight(remove(key, root.getRight()));
            return root;
        }
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
        if (low == null) throw new NullPointerException("first argument to keys() is null");
        if (high == null) throw new NullPointerException("second argument to keys() is null");

        Queue<K> queue = new LinkedList<>();
        keys(root, queue, low, high);
        return queue;
    }

    private void keys(BinaryTreeNode root, Queue<K> queue, K low, K high) {
        if (root == null) return;
        int lowCom = root.getKey().compareTo(low), highCom = root.getKey().compareTo(high);
        if (lowCom > 0) keys(root.getLeft(), queue, low, high);
        if (lowCom >= 0 && highCom <= 0) queue.add((K) root.getKey());
        if (highCom < 0) keys(root.getRight(), queue, low, high);
    }

    @Override
    public Iterable<K> keys() {
        return keys(min(), max());
    }

    /*************************************************************************
     * Check integrity of BST data structure.
     ***************************************************************************/
    private boolean check() {
        if (!isBST()) {
            System.out.println("NOT BST");
            return false;
        }
        if (!isSizeCorrect()) {
            System.out.println("Subtree size NOT CORRECT");
            return false;
        }
        if (!isRankCorrect()) {
            System.out.println("Rank NOT CORRECT");
            return false;
        }
        return true;
    }

    /**
     * does this binary tree satisfy symmetric order ?
     * this method also ensure that this BST is a binary tree since order is strict
     *
     * @return
     */
    private boolean isBST() {
        return isBST(root, null, null);
    }

    /**
     * is the tree rooted at x a BST with all keys strictly between min and max
     * (if min or max is null, treat as empty constraint)
     *
     * @param node
     * @param min
     * @param max
     * @return
     */
    private boolean isBST(BinaryTreeNode node, K min, K max) {
        if (node == null) return true;
        if (min != null && node.getKey().compareTo(min) <= 0) return false;
        if (max != null && node.getKey().compareTo(max) >= 0) return false;
        return isBST(node.getLeft(), min, (K) node.getKey())
                && isBST(node.getRight(), (K) node.getKey(), max);
    }

    private boolean isSizeCorrect() {
        return isSizeCorrect(root);
    }

    private boolean isSizeCorrect(BinaryTreeNode node) {
        if (node == null) return true;
        if (node.getN() != size(node.getLeft()) + size(node.getRight()) + 1) return false;
        return isSizeCorrect(node.getRight()) && isSizeCorrect(node.getLeft());
    }

    private boolean isRankCorrect() {
        if (isEmpty()) return true;
        for (int i = 0; i < size(); i++) {
            if (i != rank(select(i))) return false;
        }
        for (K key : keys()) {
            if (key.compareTo(select(rank(key))) != 0) return false;
        }
        return true;
    }
}
