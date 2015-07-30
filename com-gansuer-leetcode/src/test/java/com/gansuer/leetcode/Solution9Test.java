package com.gansuer.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 7/30/15.
 */
public class Solution9Test {

    private Solution9 solution9;

    @Before
    public void setUp() throws Exception {
        solution9 = new Solution9();
    }

    @Test
    public void testIsPalindrome() throws Exception {
        int src = 100;
        boolean res = solution9.isPalindrome(src);
        Assert.assertTrue(!res);

        src = 1005;
        res = solution9.isPalindrome(src);
        Assert.assertTrue(!res);

        src = 101;
        res = solution9.isPalindrome(src);
        Assert.assertTrue(res);

        src = 102;
        res = solution9.isPalindrome(src);
        Assert.assertTrue(!res);

        src = -101;
        res = solution9.isPalindrome(src);
        Assert.assertTrue(!res);

        src = 1001;
        res = solution9.isPalindrome(src);
        Assert.assertTrue(res);

        src = 1002;
        res = solution9.isPalindrome(src);
        Assert.assertTrue(!res);
        src = 1010;
        res = solution9.isPalindrome(src);
        Assert.assertTrue(!res);

        src = 1100;
        res = solution9.isPalindrome(src);
        Assert.assertTrue(!res);

        src = -1002;
        res = solution9.isPalindrome(src);
        Assert.assertTrue(!res);
    }

    @Test
    public void testIsPalindrome2() throws Exception {
        int src = 100;
        boolean res = solution9.isPalindrome(src);
        Assert.assertTrue(!res);

        src = 1005;
        res = solution9.isPalindrome2(src);
        Assert.assertTrue(!res);

        src = 101;
        res = solution9.isPalindrome2(src);
        Assert.assertTrue(res);

        src = 102;
        res = solution9.isPalindrome2(src);
        Assert.assertTrue(!res);

        src = -101;
        res = solution9.isPalindrome2(src);
        Assert.assertTrue(!res);

        src = 1001;
        res = solution9.isPalindrome2(src);
        Assert.assertTrue(res);

        src = 1002;
        res = solution9.isPalindrome2(src);
        Assert.assertTrue(!res);
        src = 1010;
        res = solution9.isPalindrome2(src);
        Assert.assertTrue(!res);

        src = 1100;
        res = solution9.isPalindrome2(src);
        Assert.assertTrue(!res);

        src = -1002;
        res = solution9.isPalindrome2(src);
        Assert.assertTrue(!res);
    }
}