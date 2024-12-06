package linkedlist.logicbuilding;

import linkedlist.ListNode;

public class SortALLOf0s1sAnd2s {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode zeroHead =  new ListNode(-1);
        ListNode oneHead =  new ListNode(-1);
        ListNode twoHead =  new ListNode(-1);

        ListNode temp = head;
        ListNode zero  = zeroHead;
        ListNode one = oneHead;
        ListNode two =  twoHead;
        while (temp!=  null){
            if (temp.val == 0){
                zero.next = temp;
                zero = temp;
            } else if (temp.val == 1) {
                one.next = temp;
                one = temp;
            }else {
                if (temp.val == 2) {
                    two.next = temp;
                    two = temp;
                }
            }
            temp =  temp.next;
        }

        zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;

        ListNode newHead = zeroHead.next;
        return newHead;
    }
    public static void main(String[] args) {

    }
}
