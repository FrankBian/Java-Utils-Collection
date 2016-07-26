package com.gansuer.leetcode.string;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 7/26/16.
 */
public class Solution43Test {

    private Solution43 solution;

    @Before
    public void setUp() throws Exception {
        solution = new Solution43();
    }

    @Test
    public void multiply() throws Exception {
        long num1 = 4567;
        long num2 = 89765;
        String res = solution.multiply(num1 + "", num2 + "");
        Assert.assertEquals(num1 * num2 + "", res);

        num1 = 123;
        num2 = 456;
        res = solution.multiply(num1+"",num2+"");
        Assert.assertEquals(num1*num2+"", res);
    }

    @Test
    public void multiplyBy() throws Exception {
        long num1 = 4567;
        long num2 = 89765;
        String res = solution.multiplyBy(num2 + "", num1 + "");
        Assert.assertEquals(num1 * num2 + "", res);

        num1 = 123;
        num2 = 456;

        res = solution.multiplyBy(num2+"",num1+"");
        Assert.assertEquals(num1*num2+"", res);

        num1 = 7188;
        num2 = 102;
        res = solution.multiplyBy(num1+"",num2+"");
        Assert.assertEquals(num1*num2+"",res);
    }

    @Test
    public void char2int() throws Exception {
        Assert.assertEquals(0, solution.char2int('0'));
        Assert.assertEquals(1, solution.char2int('1'));
        Assert.assertEquals(2, solution.char2int('2'));
        Assert.assertEquals(3, solution.char2int('3'));
        Assert.assertEquals(4, solution.char2int('4'));
        Assert.assertEquals(5, solution.char2int('5'));
        Assert.assertEquals(6, solution.char2int('6'));
        Assert.assertEquals(7, solution.char2int('7'));
        Assert.assertEquals(8, solution.char2int('8'));
        Assert.assertEquals(9, solution.char2int('9'));
    }

    @Test
    public void add() throws Exception {
        long num1 = 4567;
        long num2 = 6778898;
        Assert.assertEquals((num1 + num2) + "", solution.add(num2 + "", num1 + ""));

        num1 = 34567;
        num2 = 563773783;
        Assert.assertEquals((num1 + num2) + "", solution.add(num2 + "", num1 + ""));

        num1 = 3456777;
        num2 = 2345556;
        Assert.assertEquals((num1 + num2) + "", solution.add(num2 + "", num1 + ""));

    }

    @Test
    public void multiply1() throws Exception {

        long num1 = 456788865;
        int n = 4;
        Assert.assertEquals(num1 * n + "", solution.multiply(num1 + "", n));
        n = 1;
        Assert.assertEquals(num1 * n + "", solution.multiply(num1 + "", n));
        n = 0;
        Assert.assertEquals(num1 * n + "", solution.multiply(num1 + "", n));
        n = 9;
        Assert.assertEquals(num1 * n + "", solution.multiply(num1 + "", n));
        n = 6;
        Assert.assertEquals(num1 * n + "", solution.multiply(num1 + "", n));

    }

    @Test
    public void multiplyX() throws Exception {
        long num1 = 4567;
        long num2 = 89765;
        String res = solution.multiplyX(num1 + "", num2 + "");
        Assert.assertEquals(num1 * num2 + "", res);

        num1 = 123;
        num2 = 456;
        res = solution.multiplyX(num1+"",num2+"");
        Assert.assertEquals(num1*num2+"", res);
    }
}