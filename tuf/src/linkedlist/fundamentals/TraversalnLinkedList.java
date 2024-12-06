package linkedlist.fundamentals;

import linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

public class TraversalnLinkedList {
    public List<Integer> LLTraversal(ListNode head) {
        List<Integer> values = new ArrayList<>();
        ListNode current = head;
        while (current != null){
            values.add(current.val);
            current = current.next;
        }
        return values;
    }
    public static void main(String[] args) {

    }
}
