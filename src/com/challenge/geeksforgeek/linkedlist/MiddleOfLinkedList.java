package com.challenge.geeksforgeek.linkedlist;

import com.challenge.leetcode.topquestions.ListNode;

public class MiddleOfLinkedList {

    public void middle(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.val);
    }
}
