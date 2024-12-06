package linkedlist.fasqmedium;

import linkedlist.ListNode;

public class LengthOfLoopInLL {
    public int findLengthOfLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow =slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return findLength(slow,fast);
            }
        }
        return 0;
    }

    private int findLength(ListNode slow, ListNode fast){
        int count = 1;
        fast = fast.next;
        while (slow != fast){
            count++;
            fast = fast.next;
        }
        return count;
    }
    public static void main(String[] args) {

    }
}
