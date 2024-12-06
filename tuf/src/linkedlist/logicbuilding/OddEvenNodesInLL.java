package linkedlist.logicbuilding;

import linkedlist.ListNode;

public class OddEvenNodesInLL {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode odd =  head;
        ListNode even  = head.next;
        ListNode firstEven = head.next;

        while (even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            //loop execution
            odd = odd.next;
            even = even.next;
        }
        odd.next = firstEven;
        return head;
    }
    public static void main(String[] args) {

    }
}
