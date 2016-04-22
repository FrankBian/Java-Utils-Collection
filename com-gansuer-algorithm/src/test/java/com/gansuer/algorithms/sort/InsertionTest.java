package com.gansuer.algorithms.sort;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Created by Frank on 5/13/15.
 */
public class InsertionTest {

    private Insertion insertion;

    @Before
    public void setUp() throws Exception {
        insertion = new Insertion();
    }

    @Test
    public void testSortX() throws Exception {
        Integer[] arr = {3, 8, 2, 3, 5, 0, -1};
        insertion.sortX(arr);
        Assert.assertTrue(insertion.isSorted(arr));
        insertion.show(arr);
    }

    private long function(long target){
        if (target == 0 || target == 1){
            return 1;
        }
        return function(target-1) + function(target-2);
    }

    @Test
    public void testFunction() throws Exception {
        Date begin = new Date();
        long res = function(100);
        Date end = new Date();
        System.out.println(res);
        System.out.println(end.getTime() - begin.getTime());

    }

    @Test
    public void testFunctions() throws Exception {
        Date begin = new Date();
        double res = functions(101);
        Date end = new Date();

        System.out.println(res);
        System.out.println(end.getTime()-begin.getTime());
    }

    private double functions(double n){
        double min = 1,max=1,res=0;
        int flag = 1;
        for (int i = 2;i <=100 ; i++){
            res = min+max;
            if (flag > 0){
                max = res;
            }else {
                min = res;
            }
            flag*= -1;
        }
        return res;
    }
}