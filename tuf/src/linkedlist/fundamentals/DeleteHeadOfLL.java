package linkedlist.fundamentals;

import linkedlist.ListNode;

public class DeleteHeadOfLL {
    public ListNode deleteHead(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode temp = head;
        head = head.next;
        temp = null;
        return head;
    }
    public static void main(String[] args) {

    }
}
