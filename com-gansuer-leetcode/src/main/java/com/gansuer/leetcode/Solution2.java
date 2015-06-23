package com.gansuer.leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null){
            return null;
        }

        int tmp = (l1.val + l2.val)/10 , mod = (l1.val + l2.val)%10 ;
        ListNode head = new ListNode(mod), next = null;
        head.next = next;

        l1 = l1.next ;
        l2 = l2.next ;
        while (l1 != null && l2 != null){
            mod = (l1.val + l2.val)%10 ;
            next = new ListNode(mod +tmp);
            tmp = (l1.val + l2.val)/10 ;
            next = next.next;
            l1 = l1.next ;
            l2 = l2.next ;
        }
        if (l1 == null && l2 == null && tmp ==0){
            next = null;
        }else if (l1 == null && l2 ==null && tmp > 0){
            next = new ListNode(tmp);
            next.next = null;
        }else if (l1 == null && l2 != null){
            next = l2;
        }else if (l1 != null && l2 == null){
            next = l1;
        }
        return head;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null){
            return null;
        }

        int tmp = (l1.val + l2.val)/10 , mod = (l1.val + l2.val)%10 ;
        ListNode head = new ListNode(mod), next = null;
        head.next = next;

        l1 = l1.next ;
        l2 = l2.next ;
        while (l1 != null && l2 != null){
            mod = (l1.val + l2.val)%10 ;
            next = new ListNode(mod +tmp);
            tmp = (l1.val + l2.val)/10 ;
            next = next.next;
            l1 = l1.next ;
            l2 = l2.next ;
        }
        if (l1 == null && l2 == null && tmp ==0){
            next = null;
        }else if (l1 == null && l2 ==null && tmp > 0){
            next = new ListNode(tmp);
            next.next = null;
        }else if (l1 == null && l2 != null){
            next = l2;
        }else if (l1 != null && l2 == null){
            next = l1;
        }

        return head;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
}
