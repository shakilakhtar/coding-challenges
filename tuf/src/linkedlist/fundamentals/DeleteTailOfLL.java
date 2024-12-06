package linkedlist.fundamentals;

import linkedlist.ListNode;

public class DeleteTailOfLL {
    public ListNode deleteTail(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode temp = head;
        //reach to second last element
        while (temp.next.next != null){
            temp= temp.next;
        }
        //delete the tail element
        temp.next = null;

        return head;
    }
    public static void main(String[] args) {

    }
}
