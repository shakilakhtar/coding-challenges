package linkedlist.fundamentals;

import linkedlist.ListNode;

public class InsertAtHeadOfLL {
    public ListNode insertAtHead(ListNode head, int X) {

        ListNode temp = new ListNode(X);

        temp.next = head;

        return temp;
    }
    public static void main(String[] args) {

    }
}
