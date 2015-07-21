package com.gansuer.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 7/21/15.
 */
public class Solution7Test {

    private Solution7 solution7;
    @Before
    public void setUp() throws Exception {
        solution7 = new Solution7();
    }

    @Test
    public void testReverse() throws Exception {
        int input = 123;
        int expected = 321;
        int actual = solution7.reverse(input);

        Assert.assertEquals(expected,actual);
        input = -123;
        expected = -321;
        actual = solution7.reverse(input);

        Assert.assertEquals(expected,actual);

        input = -2147483648;
        expected = 0;
        actual = solution7.reverse(input);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testReverse1() throws Exception {
        int input = 123;
        int expected = 321;
        int actual = solution7.reverse1(input);

        Assert.assertEquals(expected,actual);

        input = -123;
        expected = -321;
        actual = solution7.reverse1(input);

        Assert.assertEquals(expected,actual);

        input = -2147483648;
        expected = 0;
        actual = solution7.reverse1(input);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testReverse2() throws Exception {
        int input = 123;
        int expected = 321;
        int actual = solution7.reverse2(input);

        Assert.assertEquals(expected,actual);

        input = -123;
        expected = -321;
        actual = solution7.reverse2(input);

        Assert.assertEquals(expected,actual);

        input = -2147483648;
        expected = 0;
        actual = solution7.reverse2(input);

        Assert.assertEquals(expected,actual);
    }

}