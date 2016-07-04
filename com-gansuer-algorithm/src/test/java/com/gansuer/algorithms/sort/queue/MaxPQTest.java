package com.gansuer.algorithms.sort.queue;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 2/22/2016.
 */
public class MaxPQTest {

    private MaxPQ<String> maxPQ;
    private char[] srcs = "priorityqueue".toCharArray();
    private String[] strs;
    @Before
    public void setUp() throws Exception {
        maxPQ = new UnorderArrayMaxPQ<>();
        strs = new String[srcs.length];
        int i= 0;
        for (char src : srcs) {
            strs[i++] = src+"";
        }
    }

    @Test
    public void testMax() throws Exception {

    }

    @Test
    public void testDelMax() throws Exception {
        //P R I O * R * * I * T * Y * * * Q U getEdges * * * U * getEdges
        maxPQ.insert("p");
        maxPQ.insert("r");
        maxPQ.insert("i");
        maxPQ.insert("o");
        System.out.println(maxPQ.delMax());
        maxPQ.insert("r");
        System.out.println(maxPQ.delMax());
        System.out.println(maxPQ.delMax());
        maxPQ.insert("i");
        System.out.println(maxPQ.delMax());
        maxPQ.insert("t");
        System.out.println(maxPQ.delMax());
        maxPQ.insert("y");
        System.out.println(maxPQ.delMax());
        System.out.println(maxPQ.delMax());
        System.out.println(maxPQ.delMax());
        maxPQ.insert("q");
        maxPQ.insert("u");
        maxPQ.insert("e");
        System.out.println(maxPQ.delMax());
        System.out.println(maxPQ.delMax());
        System.out.println(maxPQ.delMax());
        maxPQ.insert("u");
        System.out.println(maxPQ.delMax());
        maxPQ.insert("e");

    }
}