package com.gansuer.algorithms.sort.queue;

import com.gansuer.algorithms.stdlib.StdOut;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 2/21/2016.
 */
public class IndexMinPQTest {

    private IndexMinPQ<String> pq;
    private String[] strings = {"it", "was", "the", "best", "of", "times", "it", "was", "the", "worst"};

    @Before
    public void setUp() throws Exception {
        // insert a bunch of strings
        pq = new IndexMinPQ<>(strings.length);
        for (int i = 0; i < strings.length; i++) {
            pq.insert(i, strings[i]);
        }

    }

    @Test
    public void testMain() throws Exception {
        // delete and print each key
        while (!pq.isEmpty()) {
            int i = pq.delMin();
            StdOut.println(i + " " + strings[i]);
        }
        StdOut.println();

        // reinsert the same strings
        for (int i = 0; i < strings.length; i++) {
            pq.insert(i, strings[i]);
        }
        while (!pq.isEmpty()) {
            pq.delMin();
        }


    }

    @Test
    public void testMin() throws Exception {
        String res = pq.min();

        Assert.assertEquals("best",res);
    }

    @Test
    public void testMinIndex() throws Exception {
        int min = pq.minIndex();

        Assert.assertEquals(3,min);
    }

    @Test
    public void testMinKey() throws Exception {
        String min = pq.minKey();
        Assert.assertEquals("best",min);
    }

    @Test
    public void testDelMin() throws Exception {
        int min = pq.delMin();
        Assert.assertEquals(3,min);

        boolean res = pq.contains(min);
        Assert.assertEquals(false,res);
    }

    @Test
    public void testInsert() throws Exception {
        boolean isEmpty = pq.isEmpty();
        Assert.assertEquals(false,isEmpty);

        int size = pq.size();
        Assert.assertEquals(strings.length,size);
    }

    @Test
    public void testChange() throws Exception {
        int k = 0;
        String item = "begin";
        pq.change(k,item);

        Assert.assertEquals(true,pq.contains(k));
        Assert.assertEquals(item,pq.keyOf(k));
        Assert.assertEquals(item,pq.min());
    }

    @Test
    public void testChangeKey() throws Exception {
        testChange();
    }

    @Test
    public void testDecreaseKey() throws Exception {
        int k = 3;
        String key = "abc";

        pq.decreaseKey(k,key);
        Assert.assertEquals(key,pq.keyOf(k));

        key = "cba";
        try {
            pq.decreaseKey(k,key);
        }catch (RuntimeException e){
            System.out.println("illegalArgumentException");
        }
        Assert.assertEquals("abc",pq.keyOf(k));
    }

    @Test
    public void testIncreaseKey() throws Exception {
        int k = 3;
        String key = "better";

        pq.increaseKey(k,key);
        Assert.assertEquals(key,pq.keyOf(k));

        key = "begin";
        try {
            pq.increaseKey(k,key);
        }catch (RuntimeException e){
            System.out.println("illegalArgumentException");
        }
        Assert.assertEquals("better",pq.keyOf(k));
    }

    @Test
    public void testKeyOf() throws Exception {
        for (int i = 0; i < strings.length; i++){
            Assert.assertEquals(strings[i],pq.keyOf(i));
        }
    }

    @Test
    public void testContains() throws Exception {
        for (int i = 0; i < strings.length; i++){
            Assert.assertEquals(true,pq.contains(i));
        }
    }

    @Test
    public void testDelete() throws Exception {
        int k = 9;
        Assert.assertEquals(true,pq.contains(k));
        pq.delete(k);

        Assert.assertEquals(strings.length - 1 , pq.size());
        Assert.assertEquals(false,pq.contains(k));
    }

    @Test
    public void testIsEmpty() throws Exception {
        Assert.assertEquals(false,pq.isEmpty());
        while (!pq.isEmpty()){
            pq.delMin();
        }
        Assert.assertEquals(true,pq.isEmpty());
    }

    @Test
    public void testSize() throws Exception {
        Assert.assertEquals(strings.length,pq.size());
    }

    @Test
    public void testIterator() throws Exception {
        // print each key using the iterator
        for (int i : pq) {
            StdOut.println(i + " " + strings[i]);
        }
    }
}