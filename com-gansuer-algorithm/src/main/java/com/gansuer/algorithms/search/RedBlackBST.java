package com.gansuer.algorithms.search;

/**
 * Created by Frank on 3/7/16.
 */
public class RedBlackBST<K extends Comparable<K>, V> implements SequenceST<K, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;
    private int size;

    private class Node {
        private K key;
        private V val;
        private boolean color;
        private Node left, right;

        public Node(K key, V val, boolean color) {
            this.key = key;
            this.val = val;
            this.color = color;
        }
    }

    /**
     * the height of the tree
     *
     * @return
     */
    public int height() {
        return height(root);
    }

    private int height(Node x) {
        if (x == null) return 0;
        return 1 + Math.max(height(x.left), height(x.right));
    }

    /**
     * the MIN Key
     *
     * @return
     */
    @Override
    public K min() {
        Node res = min(root);
        return res == null ? null : res.key;
    }

    private Node min(Node x) {
        if (x == null) return null;
        Node cur = x;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }

    /**
     * the MAX key
     *
     * @return
     */
    @Override
    public K max() {
        Node res = max(root);
        return res == null ? null : res.key;
    }

    private Node max(Node x) {
        if (x == null) return null;
        Node cur = x;
        while (cur.right != null) {
            cur = cur.right;
        }
        return cur;
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
        Node res = floor(key, root);
        return res != null ? res.key : null;
    }

    private Node floor(K key, Node x) {
        if (x == null) return null;
        int cmp = x.key.compareTo(key);
        if (cmp == 0) return x;
        if (cmp > 0) return floor(key, x.left);
        Node res = floor(key, x.right);
        return res != null ? res : x;
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
        Node res = ceiling(key, root);
        return res != null ? res.key : null;
    }

    private Node ceiling(K key, Node x) {
        if (x == null) return null;
        int cmp = x.key.compareTo(key);
        if (cmp == 0) return x;
        if (cmp < 0) return ceiling(key, x.right);
        Node res = ceiling(key, x.left);
        return res != null ? res : x;
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

        assert check();
    }

    /**
     * delete largest key
     */
    @Override
    public void deleteMax() {

        assert check();
    }

    /**
     * insert one key-value pair
     *
     * @param key
     * @param value
     */
    @Override
    public void put(K key, V value) {
        if (key == null) throw new IllegalArgumentException("thr first argument to put() is null");
        if (value == null) {
            delete(key);
            return;
        }
        root = put(key, value, root);
        root.color = BLACK;

        assert check();
    }

    private Node put(K key, V value, Node x) {
        if (x == null) {
            size++;
            return new Node(key, value, RED);
        }
        int cmp = x.key.compareTo(key);
        if (cmp == 0) {
            x.val = value;
        } else if (cmp > 0) {
            x.left = put(key, value, x.left);
        } else {
            x.right = put(key, value, x.right);
        }
        //ensure that satisfy the red-black tree
        if (isRed(x.right) && !isRed(x.left)) {
            x = rotateLeft(x);
        }
        if (isRed(x.left) && isRed(x.left.left)) {
            x = rotateRight(x);
        }
        if (isRed(x.left) && isRed(x.right)) {
            flipColors(x);
        }
        return x;
    }

    /**
     * return the specified key's value
     *
     * @param key
     * @return
     */
    @Override
    public V get(K key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        return get(key, root);
    }

    private V get(K key, Node x) {
        Node cur = x;
        while (cur != null) {
            int cmp = cur.key.compareTo(key);
            if (cmp == 0) return cur.val;
            else if (cmp > 0) cur = cur.left;
            else cur = cur.right;
        }
        return null;
    }

    /**
     * remove the key-value pair from this ST
     *
     * @param key
     */
    @Override
    public void delete(K key) {

        assert check();
    }

    /**
     * @param key
     * @return
     */
    @Override
    public boolean contains(K key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private int size(Node x) {
        if (x == null) return 0;
        return 1 + size(x.left) + size(x.right);
    }

    @Override
    public Iterable<K> keys() {
        return null;
    }

    /**
     * Red-Black helper function
     */
    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    //rotate right
    private Node rotateRight(Node node) {
        assert node != null && isRed(node.left);
        Node x = node.left;
        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    //rotate left
    private Node rotateLeft(Node node) {
        assert node != null && isRed(node.right);
        Node x = node.right;
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    // precondition: two children are red, node is black
    // postcondition: two children are black, node is red
    private void flipColors(Node h) {
        assert !isRed(h) && isRed(h.left) && isRed(h.right);
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    /**
     * check integrity of red-black tree data structure
     */
    private boolean check() {
        if (!isBST()) {
            System.out.println("Not in symmetric order");
            return false;
        }
        if (!is23()) {
            System.out.println("Not a 2-3 tree");
            return false;
        }
        if (!isBalanced()) {
            System.out.println("Not balanced");
            return false;
        }
        return true;
    }

    // Does the tree have no red right links, and at most one (left)
    // red links in a row on any path?
    private boolean is23() {
        return is23(root);
    }

    private boolean is23(Node x) {
        if (x == null) return true;
        if (isRed(x.right)) return false;
        if (x != root && isRed(x) && isRed(x.left)) return false;
        return is23(x.left) && is23(x.right);
    }

    // does this binary tree satisfy symmetric order?
    // Note: this test also ensures that data structure is a binary tree since order is strict
    private boolean isBST() {
        return isBST(root, null, null);
    }

    private boolean isBST(Node x, K min, K max) {
        if (x == null) return true;
        if (min != null && x.key.compareTo(min) <= 0) return false;
        if (max != null && x.key.compareTo(max) >= 0) return false;
        return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
    }

    // do all paths from root to leaf have same number of black edges?
    private boolean isBalanced() {
        int black = 0;
        Node x = root;
        while (x != null) {
            if (!isRed(x)) {
                black++;
            }
            x = x.left;
        }
        return isBalanced(root, black);
    }

    private boolean isBalanced(Node x, int black) {
        if (x == null) return black == 0;
        if (!isRed(x)) black--;
        return isBalanced(x.left, black) && isBalanced(x.right, black);
    }
}
