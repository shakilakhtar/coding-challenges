package linkedlist.fasqmedium;

import linkedlist.ListNode;

public class CheckLLIsPalindrome {
    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = reverseLinkedList(slow.next);
        ListNode first  = head;
        ListNode second = newHead;

        while (second != null){
            if (first.val != second.val){
                reverseLinkedList(newHead);

                return false;
            }
            first = first.next;
            second = second.next;
        }

        reverseLinkedList(newHead);

        return true;
    }

    private ListNode reverseLinkedList(ListNode head) {
        /* Check if the list is empty
        or has only one node */
        if (head == null || head.next == null) {
            /* No change is needed;
            return the current head */
            return head;
        }

        /* Reverse the remaining
        part of the list and get the new head */
        ListNode newHead = reverseLinkedList(head.next);

        /* Store the next node in 'front'
        to reverse the link */
        ListNode front = head.next;

        /* Update the 'next' pointer of 'front' to
        point to the current head, effectively
        reversing the link direction */
        front.next = head;

        /* Set the 'next' pointer of the
        current head to 'null' to
        break the original link */
        head.next = null;

        /* Return the new head obtained
        from the recursion */
        return newHead;
    }
    public static void main(String[] args) {

    }
}
