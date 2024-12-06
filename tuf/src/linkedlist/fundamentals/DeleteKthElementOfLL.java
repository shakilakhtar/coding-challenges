package linkedlist.fundamentals;

import linkedlist.ListNode;

public class DeleteKthElementOfLL {
    public ListNode deleteKthNode(ListNode head, int k) {
        if (head == null){
            return null;
        }
        if (k == 1){
            ListNode temp = head;
            head = head.next;
            return head;
        }
        ListNode temp = head;

        // Traverse to the (k-1)th node
        for (int i = 0; (temp.next !=null && i < k - 2) ; i++) {

            temp= temp.next;
        }
        //condition when k is greater than list
        //simply return unchanged list
        if (temp == null || temp.next == null){
            return head;
        }
        temp.next = temp.next.next;

        return head;
    }
    public static void main(String[] args) {

    }
}
