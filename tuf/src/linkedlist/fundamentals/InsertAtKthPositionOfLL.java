package linkedlist.fundamentals;

import linkedlist.ListNode;

public class InsertAtKthPositionOfLL {
    public ListNode insertAtKthPosition(ListNode head, int X, int K) {
        if (head == null){
            if (K == 1){
                return new ListNode(X);
            }else {
                return head;
            }
        }
        if (K == 1){
            return new ListNode(X,head);
        }
        int count = 0;
        ListNode  temp =  head;
        while (temp != null){
            count++;
            if (count ==  K -1){
                ListNode node = new ListNode(X, temp.next);
                temp.next = node;
            }
            temp = temp.next;
        }
        return head;
    }
    public static void main(String[] args) {

    }
}
