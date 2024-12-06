package linkedlist.logicbuilding;

import linkedlist.ListNode;

public class AddTwoNumbersInLL {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // a dummy node to track head of the new list
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;
        int carry = 0 ;
        while (l1!= null || l2 != null || carry!= 0){
            int sum = 0;
            if (l1 != null){
                sum = sum + l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                sum = sum + l2.val;
                l2 = l2.next;
            }
            //add carry
            sum = sum + carry;
            carry = sum / 10;
            //create new node
            ListNode node  =  new ListNode(sum % 10);
            temp.next = node;
            temp = temp.next;
        }
        return dummyNode.next;
    }
    public static void main(String[] args) {

    }
}
