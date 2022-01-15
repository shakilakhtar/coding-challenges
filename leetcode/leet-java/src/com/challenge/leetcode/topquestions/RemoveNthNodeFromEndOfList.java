package com.challenge.leetcode.topquestions;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 *
 * Given n will always be valid.
 *
 * Follow up:
 *
 * Could you do this in one pass?
 *
 * @author Shakil Akhtar on 17/12/19
 */
public class RemoveNthNodeFromEndOfList {
    static ListNode head;

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        int length  = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        length -= n;
        first = temp;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return temp.next;
    }
    public static void main(String[] args) {
        head=new ListNode(4);
        head.next=new ListNode(5);
        head.next.next=new ListNode(1);
        head.next.next.next=new ListNode(9);
        ListNode choppedList = removeNthFromEnd(head,2);
        System.out.println();
    }
}
