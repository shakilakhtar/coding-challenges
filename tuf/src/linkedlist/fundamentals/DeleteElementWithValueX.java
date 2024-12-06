package linkedlist.fundamentals;

import linkedlist.ListNode;

public class DeleteElementWithValueX {
    public ListNode deleteNodeWithValueX(ListNode head, int X) {
        if (head == null){
            return null;
        }
        if (head.val == X){
            head = head.next;
            return head;
        }
        ListNode temp  = head;
        ListNode prev =  null;
        while (temp!= null){
            if (temp.val == X){
                prev.next = temp.next;
                return head;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
    public static void main(String[] args) {

    }
}
