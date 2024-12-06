package linkedlist.fundamentals;

import linkedlist.ListNode;

public class InsertAtTailOfLL {
    public ListNode insertAtTail(ListNode head, int X) {
        ListNode node = new ListNode(X);
        if (head ==  null){
            return node;
        }
        ListNode temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
        return head;
    }
    public static void main(String[] args) {

    }
}
