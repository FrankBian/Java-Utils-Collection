package com.gansuer.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 11/22/15.
 */
public class BSTIteratorTest {

    private Solution108 solution108;
    private Solution173.BSTIterator bstIterator;
    private Solution173.BSTIteratorV1 bstIteratorV1;
    @Before
    public void setUp() throws Exception {
        solution108 = new Solution108();
    }

    @Test
    public void testHasNext() throws Exception {
        int[] input = {2,3,4,5,6,7,8,9,10,34,56};

        TreeNode root = solution108.sortedArrayToBST(input);
        bstIterator = new Solution173.BSTIterator(root);
        int index = 0;
        while (bstIterator.hasNext()){
            Assert.assertEquals(input[index++],bstIterator.next());
        }
    }

    @Test
    public void testNext() throws Exception {
        int[] input = {2,3,4,5,6,7,8,9,10,34,56};

        TreeNode root = solution108.sortedArrayToBST(input);
        bstIteratorV1 = new Solution173.BSTIteratorV1(root);
        int index = 0;
        while (bstIteratorV1.hasNext()){
            Assert.assertEquals(input[index++],bstIteratorV1.next());
        }
    }
}