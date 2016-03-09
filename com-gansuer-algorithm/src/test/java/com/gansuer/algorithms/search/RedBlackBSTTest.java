package com.gansuer.algorithms.search;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by Frank on 3/9/16.
 */
public class RedBlackBSTTest {

    private RedBlackBST<String, Integer> rbt;
    private String[] strs = "S E A R C H E X A M P L E".split(" ");

    @Before
    public void setUp() throws Exception {
        rbt = new RedBlackBST<>();
        for (int i = 0; i < strs.length; i++) {
            rbt.put(strs[i], i);
        }
    }

    @Test
    public void testHeight() throws Exception {
        int height = rbt.height();

        Assert.assertEquals(4, height);
    }

    @Test
    public void testMin() throws Exception {
        String min = "A";
        String res = rbt.min();

        Assert.assertEquals(min, res);
    }

    @Test
    public void testMax() throws Exception {
        String max = "X";
        String res = rbt.max();

        Assert.assertEquals(max, res);
    }

    @Test
    public void testFloor() throws Exception {
        String key = "G", res = rbt.floor(key), cur = "";
        Arrays.sort(strs);

        for (String s : strs) {
            if (s.compareTo(key) > 0) {
                break;
            }
            cur = s;
        }

        Assert.assertEquals(cur, res);

    }

    @Test
    public void testCeiling() throws Exception {
        String key = "I", res = rbt.ceiling(key), cur = "";
        Arrays.sort(strs);

        for (String s : strs) {
            if (s.compareTo(key) >= 0) {
                cur = s;
                break;
            }
        }
        Assert.assertEquals(cur, res);
    }

    @Test
    public void testRank() throws Exception {
        TreeSet<String> set = new TreeSet<>(Arrays.asList(strs));
        int i = 0, res = 0;
        for (String s : set) {
            res = rbt.rank(s);
            System.out.println("i = " + i + ", s =" + s + ", res = " + res);
            Assert.assertEquals(i++, res);
        }
    }

    @Test
    public void testSelect() throws Exception {
        TreeSet<String> set = new TreeSet<>(Arrays.asList(strs));
        int i = 0;
        for (String s : set) {
            Assert.assertEquals(s, rbt.select(i++));
        }
    }

    @Test
    public void testKeys() throws Exception {
        TreeSet<String> set = new TreeSet<>(Arrays.asList(strs));
        List<String> list = new ArrayList<>(set);
        int i = 0;
        for (String s : rbt.keys()){
            Assert.assertEquals(list.get(i++),s);
        }
    }

    @Test
    public void testKeys1() throws Exception {
        TreeSet<String> set = new TreeSet<>(Arrays.asList(strs));
        List<String> list = new ArrayList<>(set);
        String low = "A",high = "S";
        int iLow = list.indexOf(low),iHigh = list.indexOf(high);
        for (String s : rbt.keys(low,high)){
            Assert.assertEquals(list.get(iLow++),s);
        }
        try {
            rbt.keys(high,low);
        }catch (Exception e){
            Assert.assertNotNull(e);
        }
    }

    @Test
    public void testDeleteMin() throws Exception {
        TreeSet<String> set = new TreeSet<>(Arrays.asList(strs));
        for (String s : set){
            Assert.assertEquals(s,rbt.min());
            rbt.deleteMin();
            Assert.assertTrue(!rbt.contains(s));
        }
    }

    @Test
    public void testDeleteMax() throws Exception {

    }

    @Test
    public void testPut() throws Exception {

    }

    @Test
    public void testGet() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }

    @Test
    public void testContains() throws Exception {

    }

    @Test
    public void testIsEmpty() throws Exception {

    }

    @Test
    public void testSize() throws Exception {

    }
}