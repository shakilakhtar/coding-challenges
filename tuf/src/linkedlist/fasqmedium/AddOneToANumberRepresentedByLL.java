package linkedlist.fasqmedium;

import linkedlist.ListNode;

public class AddOneToANumberRepresentedByLL {
    public ListNode addOne(ListNode head) {
        int carry = recFunc(head);
        //if carry
        if (carry == 1){
            //create new node
            ListNode newNode =  new ListNode(1);
            newNode.next = head;
            head = newNode;
        }
        return head;
    }
    private int recFunc(ListNode temp){
        if (temp == null){
            return 1;
        }
        int carry =  recFunc(temp.next);
        temp.val = temp.val + carry;
        if (temp.val < 10){
            return 0;
        }
        temp.val = 0;
        return 1;
    }
    public static void main(String[] args) {

    }
}
