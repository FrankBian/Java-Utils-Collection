package com.gansuer.algorithms.common;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Frank on 4/17/15.
 */
public class BinarySearchTest {



    private static int[] target = {7,0,67,54,1,89,2,789,67} ;
    @Test
    public void testBinarySearch() throws Exception {
        Arrays.sort(target);

        int ret = BinarySearch.binarySearch(target,89,0,target.length);
//        int ret = BinarySearch.binarySearch(target,89,0,target.length-1);

        print(target);

        System.out.println(ret);

        Assert.assertTrue(ret>0);

    }

    @Test
    public void testBinarySearchByLoop() throws Exception {
        Arrays.sort(target);

//        int ret = BinarySearch.binarySearchByLoop(target,89,0,target.length-1);
        int ret = BinarySearch.binarySearchByLoop(target, 89, 0, target.length);

        print(target);

        System.out.println(ret);

        Assert.assertTrue(ret>0);
    }

    @Test
    public void testBinarySearch1() throws Exception {
        Arrays.sort(target);

//        int ret = BinarySearch.binarySearchByLoop(target,89,0,target.length-1);
        int ret = BinarySearch.binarySearch(target,89);

        print(target);

        System.out.println(ret);

        Assert.assertTrue(ret>0);
    }

    private static void print(int[] a){
        for (int i=0;i<a.length;i++){
            System.out.print(a[i] + "   ");
        }
        System.out.println();
    }



}