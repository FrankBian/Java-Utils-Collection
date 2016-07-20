package com.gansuer.leetcode;

import com.gansuer.common.util.FileUtils;
import com.gansuer.common.util.StringUtils;
import com.gansuer.leetcode.string.Solution3;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Created by Frank on 7/5/15.
 */
public class Solution3Test {

    private Solution3 solution3;
    private String cases;

    @Before
    public void setUp() throws Exception {
        solution3 = new Solution3();
        String path = getClass().getClassLoader().getResource("Solution3TestCase.txt").getFile();
        cases = StringUtils.join(FileUtils.readFile(path), "");
    }

    @Test
    public void testLengthOfLongestSubstringV4() throws Exception {
        String target = "abcabcbb";
        int res = solution3.lengthOfLongestSubstringV4(target);

        int res1 = solution3.lengthOfLongestSubstringV4("bbbbbb");
        Date begin = new Date();
        int res2 = solution3.lengthOfLongestSubstringV4(cases);
        Date end = new Date();

        int res3 = solution3.lengthOfLongestSubstringV4("c");
        int res4 = solution3.lengthOfLongestSubstringV4("pwwkew");
        int res5 = solution3.lengthOfLongestSubstringV4("au");

        System.out.println("length of the target String : " + cases.length());
        System.out.println("length of longest Substring : " + res2);
        System.out.println("Times : " + (end.getTime() - begin.getTime()));
        Assert.assertEquals(3, res);
        Assert.assertEquals(1, res1);
        Assert.assertEquals(95, res2);
        Assert.assertEquals(1, res3);
        Assert.assertEquals(3, res4);
        Assert.assertEquals(2, res5);
    }

    @Test
    public void testLengthOfLongestSubstringV5() throws Exception {
        String target = "abcabcbb";
        int res = solution3.lengthOfLongestSubstringV5(target);

        int res1 = solution3.lengthOfLongestSubstringV5("bbbbbb");
        Date begin = new Date();
        int res2 = solution3.lengthOfLongestSubstringV5(cases);
        Date end = new Date();

        int res3 = solution3.lengthOfLongestSubstringV5("c");
        int res4 = solution3.lengthOfLongestSubstringV5("pwwkew");
        int res5 = solution3.lengthOfLongestSubstringV5("au");

        System.out.println("length of the target String : " + cases.length());
        System.out.println("length of longest Substring : " + res2);
        System.out.println("Times : " + (end.getTime() - begin.getTime()));
        Assert.assertEquals(3, res);
        Assert.assertEquals(1, res1);
        Assert.assertEquals(95, res2);
        Assert.assertEquals(1, res3);
        Assert.assertEquals(3, res4);
        Assert.assertEquals(2, res5);
    }

    @Test
    public void testLengthOfLongestSubstring() throws Exception {
        String target = "abcabcbb";
        int res = solution3.lengthOfLongestSubstring(target);
        Assert.assertEquals(3, res);

        res = solution3.lengthOfLongestSubstring("bbbbbb");
        Assert.assertEquals(1, res);

        Date begin = new Date();
        int res2 = solution3.lengthOfLongestSubstring(cases);
        Date end = new Date();

        int res3 = solution3.lengthOfLongestSubstring("c");
        int res4 = solution3.lengthOfLongestSubstring("pwwkew");
        int res5 = solution3.lengthOfLongestSubstring("au");

        System.out.println("length of the target String : " + cases.length());
        System.out.println("length of longest Substring : " + res2);
        System.out.println("Times : " + (end.getTime() - begin.getTime()));
        Assert.assertEquals(95, res2);
        Assert.assertEquals(1, res3);
        Assert.assertEquals(3, res4);
        Assert.assertEquals(2, res5);
    }

    @Test
    public void testLengthOfLongestSubstringV6() throws Exception {
        int res = solution3.lengthOfLongestSubstringV6("abcabcbb");
        int res1 = solution3.lengthOfLongestSubstringV6("bbbbbb");
        Date begin = new Date();
        int res2 = solution3.lengthOfLongestSubstringV6(cases);
        Date end = new Date();
        int res3 = solution3.lengthOfLongestSubstringV6("c");
        int res4 = solution3.lengthOfLongestSubstringV6("pwwkew");
        int res5 = solution3.lengthOfLongestSubstringV6("au");

        System.out.println("length of the target String : " + cases.length());
        System.out.println("length of longest Substring : " + res2);
        System.out.println("Times : " + (end.getTime() - begin.getTime()));
        Assert.assertEquals(3, res);
        Assert.assertEquals(1, res1);
        Assert.assertEquals(95, res2);
        Assert.assertEquals(1, res3);
        Assert.assertEquals(3, res4);
        Assert.assertEquals(2, res5);
    }

}