package com.gansuer.algorithms.search;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Frank on 2/29/16.
 */
public class BinarySearchSTTest {

    private BinarySearchST<String, String> bst;
    private String src = "mnbvgishtoperqw";

    @Before
    public void setUp() throws Exception {
        bst = new BinarySearchST<>(20);
        int index = 0;
        for (char ch : src.toCharArray()) {
            bst.put(ch + "", (index++) + "");
        }
    }

    @Test
    public void testPut() throws Exception {
        Assert.assertTrue(bst.check());
    }

    @Test
    public void testMin() throws Exception {
        String res = bst.min();
        Assert.assertEquals("b", res);
    }

    @Test
    public void testMax() throws Exception {
        String res = bst.max();
        Assert.assertEquals("w", res);
    }

    @Test
    public void testFloor() throws Exception {
        String res = bst.floor("h");
        Assert.assertEquals("h", res);
        res = bst.floor("l");
        Assert.assertEquals("i", res);
    }

    @Test
    public void testCeiling() throws Exception {
        String res = bst.ceiling("h");
        Assert.assertEquals("h", res);
        res = bst.ceiling("l");
        Assert.assertEquals("m", res);
    }

    @Test
    public void testRank() throws Exception {
        char[] arr = src.toCharArray();
        Arrays.sort(arr);
        int index = 0, res = 0;
        for (char c : arr) {
            res = bst.rank(c + "");
            Assert.assertEquals(res, index++);
        }
    }

    @Test
    public void testSelect() throws Exception {
        char[] arr = src.toCharArray();
        Arrays.sort(arr);
        int index = 0;
        String res = "";
        for (char c : arr) {
            res = bst.select(index++);
            Assert.assertEquals(c + "", res);
        }
    }

    @Test
    public void testGet() throws Exception {
        char[] arr = src.toCharArray();
        String res = "";
        for (int i = 0; i < arr.length; i++) {
            res = bst.get(arr[i] + "");
            Assert.assertEquals(i + "", res);
        }
    }

    @Test
    public void testDelete() throws Exception {
        int size = bst.size();
        Assert.assertEquals(src.toCharArray().length, size);
        bst.delete("b");
        Assert.assertTrue(!bst.contains("b"));
        size = bst.size();
        Assert.assertEquals(src.toCharArray().length, size + 1);
        Assert.assertTrue(bst.check());
    }

    @Test
    public void testContains() throws Exception {
        Assert.assertTrue(bst.contains("b"));
        Assert.assertTrue(!bst.contains("a"));
    }

    @Test
    public void testIsEmpty() throws Exception {
        BinarySearchST<String, String> binarySearchST = new BinarySearchST<>();
        Assert.assertTrue(binarySearchST.isEmpty());
        Assert.assertTrue(!bst.isEmpty());
    }

    @Test
    public void testSize() throws Exception {
        Assert.assertTrue(src.toCharArray().length == bst.size());
    }

    @Test
    public void testKeys() throws Exception {
        String low = "h", high = "t";
        char[] arr = src.toCharArray();
        Arrays.sort(arr);
        int li = 0, hi = 0;
        for (int i = 0; i < arr.length; i++) {
            if (low.equals(arr[i] + "")) li = i;
            if (high.equals(arr[i] + "")) hi = i;
        }

        for (String item : bst.keys(low, high)) {
            Assert.assertEquals(arr[li++] + "", item);
        }
        Assert.assertEquals(li, hi + 1);
    }

    @Test
    public void testKeys1() throws Exception {
        char[] arr = src.toCharArray();
        Arrays.sort(arr);
        int index = 0;
        for (String item : bst.keys()) {
            Assert.assertEquals(item, arr[index++] + "");
        }
    }

    @Test
    public void testDeleteMin() throws Exception {
        char[] arr = src.toCharArray();
        Arrays.sort(arr);
        String min = bst.min();
        Assert.assertTrue(min.equals(arr[0]));
        bst.deleteMin();
        min = bst.min();
        Assert.assertEquals(arr[1] + "", min);
    }

    @Test
    public void testDeleteMax() throws Exception {
        char[] arr = src.toCharArray();
        Arrays.sort(arr);
        int len = arr.length;
        String max = bst.max();
        Assert.assertTrue(max.equals("" + arr[len - 1]));
        bst.deleteMax();
        max = bst.max();
        Assert.assertEquals(arr[len - 2] + "", max);
    }
}