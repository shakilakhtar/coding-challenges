package linkedlist.fasqmedium;

import linkedlist.ListNode;

public class DeleteMiddleNodeInLL {
    public ListNode deleteMiddle(ListNode head) {

        if (head == null || head.next == null){
            return null;
        }
        ListNode slow =head;
        ListNode fast = head;
        //skip one step of slow pointer
        fast = fast.next.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp =  slow.next;
        slow.next =slow.next.next;
        temp = null;

        return head;
    }
    public static void main(String[] args) {

    }
}
