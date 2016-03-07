package com.gansuer.algorithms.search;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Created by Frank on 3/3/2016.
 */
public class BinarySearchTreeTest {

    private BinarySearchTree<String, Integer> bst;

    private String[] strings = "S E A R C H E X A M P L E".split(" ");

    @Before
    public void setUp() throws Exception {
        bst = new BinarySearchTree<>();
        for (int i = 0; i < strings.length; i++) {
            bst.put(strings[i], i);
        }
    }

    @Test
    public void testMin() throws Exception {
        String min = bst.min();

        Assert.assertEquals("A", min);
    }

    @Test
    public void testMax() throws Exception {
        String max = bst.max();

        Assert.assertEquals("X", max);
    }

    @Test
    public void testFloor() throws Exception {
        String key = "I";
        Arrays.sort(strings);
        String res = null;
        for (String str : strings) {
            if (str.compareTo(key) <= 0) {
                res = str;
            } else {
                break;
            }
        }

        String floor = bst.floor(key);

        Assert.assertEquals(res, floor);
    }

    @Test
    public void testCeiling() throws Exception {
        String key = "I";
        Arrays.sort(strings);
        String res = null;
        for (int i = strings.length - 1; i >= 0; i--) {
            if (strings[i].compareTo(key) >= 0) {
                res = strings[i];
            } else {
                break;
            }
        }

        String ceiling = bst.ceiling(key);

        Assert.assertEquals(res, ceiling);
    }

    @Test
    public void testRank() throws Exception {
        String key = "I";
        Arrays.sort(strings);
        Set<String> set = new HashSet<>();
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].compareTo(key) < 0) {
                set.add(strings[i]);
            }
        }
        int rank = bst.rank(key);

        Assert.assertEquals(set.size(), rank);
    }

    @Test
    public void testSelect() throws Exception {
        TreeSet<String> set = new TreeSet<String>(Arrays.asList(strings));
        ArrayList<String> list = new ArrayList<>(set);

        int index = 0;
        for (String str : list) {
            String res = bst.select(index++);
            Assert.assertEquals(str, res);
        }
        try {
            Assert.assertEquals("XXX", bst.select(index + 10));
        } catch (Exception e) {
            System.out.println("exception :" + e.getMessage());
        }
    }

    @Test
    public void testKeys() throws Exception {
        int n = 0;
        for (String str : bst.keys()) {
            Assert.assertTrue(bst.contains(str));
            n++;
        }

        Assert.assertEquals(n, bst.size());
    }

    @Test
    public void testDeleteMin() throws Exception {
        TreeSet<String> set = new TreeSet<String>(Arrays.asList(strings));
        ArrayList<String> list = new ArrayList<>(set);

        for (String str : list) {
            String res = bst.min();
            Assert.assertEquals(str, res);
            bst.deleteMin();
        }

    }

    @Test
    public void testDeleteMax() throws Exception {
        TreeSet<String> set = new TreeSet<String>(Arrays.asList(strings));
        ArrayList<String> list = new ArrayList<>(set);

        for (int i = list.size() - 1; i >= 0; i--) {
            String res = bst.max();
            Assert.assertEquals(list.get(i), res);
            bst.deleteMax();
        }
    }

    @Test
    public void testPut() throws Exception {
        for (String str : strings) {
            Assert.assertTrue(bst.contains(str));
        }
    }

    @Test
    public void testGet() throws Exception {
        int index = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String str : strings) {
            map.put(str, index++);
        }

        for (String key : map.keySet()) {
            Assert.assertEquals(map.get(key), bst.get(key));
        }
    }

    @Test
    public void testDelete() throws Exception {
        String key = "A";
        bst.delete(key);
        Assert.assertTrue(!bst.contains(key));
        bst.delete(key);
    }

    @Test
    public void testContains() throws Exception {
        for (String str : strings) {
            Assert.assertTrue(bst.contains(str));
        }
    }

    @Test
    public void testIsEmpty() throws Exception {
        BinarySearchTree<String, String> temp = new BinarySearchTree<>();
        Assert.assertTrue(temp.isEmpty());
        Assert.assertTrue(!bst.isEmpty());

    }

    @Test
    public void testSize() throws Exception {
        TreeSet<String> set = new TreeSet<String>(Arrays.asList(strings));
        ArrayList<String> list = new ArrayList<>(set);
        int size = list.size();

        for (int i = list.size() - 1; i >= 0; i--) {
            String res = bst.max();
            Assert.assertEquals(list.get(i), res);
            Assert.assertEquals(size--, bst.size());
            bst.deleteMax();
        }
    }

    @Test
    public void testKeys1() throws Exception {
        String low = "B", high = "S";
        for (String str : bst.keys(low, high)) {
            Assert.assertTrue(str.compareTo(low) >= 0);
            Assert.assertTrue(str.compareTo(high) <= 0);
        }
    }
}