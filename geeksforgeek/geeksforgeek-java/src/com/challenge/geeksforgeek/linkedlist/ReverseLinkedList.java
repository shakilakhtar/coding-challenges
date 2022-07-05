package com.challenge.geeksforgeek.linkedlist;


public class ReverseLinkedList {

    public ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous; //previous is the new head;
    }
}
