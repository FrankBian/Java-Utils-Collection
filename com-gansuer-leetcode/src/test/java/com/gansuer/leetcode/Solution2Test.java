package com.gansuer.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 7/5/15.
 */
public class Solution2Test {

    private Solution2.ListNode node1;
    private Solution2.ListNode node2;

    @Before
    public void setUp() throws Exception {
        node1 = new Solution2.ListNode(2);
        node1.next = new Solution2.ListNode(4);
        node1.next.next = new Solution2.ListNode(3);
        node2 = new Solution2.ListNode(5);
        node2.next = new Solution2.ListNode(6);
        node2.next.next = new Solution2.ListNode(4);
    }

    @Test
    public void testAddTwoNumbers() throws Exception {
        Solution2.ListNode res = Solution2.addTwoNumbers(node1, node2);

        Assert.assertNotNull(res);
        Assert.assertEquals(7, res.val);
        Assert.assertEquals(0, res.next.val);
        Assert.assertEquals(8, res.next.next.val);
    }

    @Test
    public void testAddTwoNumbersV1() throws Exception {
        node1 = new Solution2.ListNode(3);
        node1.next = new Solution2.ListNode(7);
        node2 = new Solution2.ListNode(9);
        node2.next = new Solution2.ListNode(2);

        Solution2.ListNode res = Solution2.addTwoNumbers(node1, node2);

        Assert.assertNotNull(res);
        Assert.assertEquals(2, res.val);
        Assert.assertEquals(0, res.next.val);
        Assert.assertEquals(1, res.next.next.val);
    }

    @Test
    public void testAddTwoNumbers1() throws Exception {

    }
}