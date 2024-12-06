package linkedlist.fundamentals;

import linkedlist.ListNode;

public class InsertBeforeXOfLL {
    public ListNode insertBeforeX(ListNode head, int X, int val) {
        if (head == null){
                return null;
            }
        if (head.val == X){
            return new ListNode(val,head);
        }
        ListNode  temp =  head;
        while (temp.next != null){
            if (temp.next.val ==  X){
                ListNode node = new ListNode(val, temp.next);
                temp.next = node;
                break;
            }
            temp = temp.next;
        }
        return head;
    }
    public static void main(String[] args) {

    }
}
