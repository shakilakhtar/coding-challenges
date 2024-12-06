package linkedlist.fasqmedium;

import linkedlist.ListNode;

public class DetectLoopInLL {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast!= null && fast.next != null){
            slow = slow.next;
            fast =fast.next.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
