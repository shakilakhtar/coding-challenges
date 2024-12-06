package linkedlist.logicbuilding;

import linkedlist.ListNode;

public class ReverseALL {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead  = reverseList(head.next);
        ListNode front =  head.next;
        front.next = head;
        head.next = null;

        return newHead;
    }
    public static void main(String[] args) {

    }
}
