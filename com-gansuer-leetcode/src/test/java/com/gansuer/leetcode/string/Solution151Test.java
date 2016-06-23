package com.gansuer.leetcode.string;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 4/22/2016.
 */
public class Solution151Test {


    private Solution151 solution151;
    @Before
    public void setUp() throws Exception {
        solution151 = new Solution151();
    }

    @Test
    public void reverseWords() throws Exception {
        String src = "the sky is blue     ";
        String res = solution151.reverseWords(src);
        Assert.assertEquals("blue is sky the",res);

        Assert.assertEquals("blue is sky the",solution151.reverse(src));

        Assert.assertEquals("b a",solution151.reverse("a    b"));

        res = "a      b".replaceAll("([\\s\\t\\r]+)"," ");
        Assert.assertEquals("a b",res);

    }
}