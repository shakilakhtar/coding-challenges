package linkedlist;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(){
        val = 0;
        next = null;
    }

    public ListNode(int data){
        val = data;
        next = null;
    }

    public ListNode(int data, ListNode node){
        val = data;
        next = node;
    }
}
