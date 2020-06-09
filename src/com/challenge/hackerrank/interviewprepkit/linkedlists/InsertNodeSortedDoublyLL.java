package com.challenge.hackerrank.interviewprepkit.linkedlists;

/**
 * Given a reference to the head of a doubly-linked list and an integer, , create a new DoublyLinkedListNode object having data value  and insert it into a sorted linked list while maintaining the sort.
 * <p>
 * Function Description
 * <p>
 * Complete the sortedInsert function in the editor below. It must return a reference to the head of your modified DoublyLinkedList.
 * <p>
 * sortedInsert has two parameters:
 * <p>
 * head: A reference to the head of a doubly-linked list of DoublyLinkedListNode objects.
 * data: An integer denoting the value of the  field for the DoublyLinkedListNode you must insert into the list.
 * Note: Recall that an empty list (i.e., where ) and a list with one element are sorted lists.
 * <p>
 * Input Format
 * <p>
 * The first line contains an integer , the number of test cases.
 * <p>
 * Each of the test case is in the following format:
 * <p>
 * The first line contains an integer , the number of elements in the linked list.
 * Each of the next  lines contains an integer, the data for each node of the linked list.
 * The last line contains an integer  which needs to be inserted into the sorted doubly-linked list.
 * Constraints
 * <p>
 * Output Format
 * <p>
 * Do not print anything to stdout. Your method must return a reference to the  of the same list that was passed to it as a parameter.
 * <p>
 * The ouput is handled by the code in the editor and is as follows:
 * For each test case, print the elements of the sorted doubly-linked list separated by spaces on a new line.
 * <p>
 * Sample Input
 * <p>
 * 1
 * 4
 * 1
 * 3
 * 4
 * 10
 * 5
 * Sample Output
 * <p>
 * 1 3 4 5 10
 * Explanation
 * <p>
 * The initial doubly linked list is:  .
 * <p>
 * The doubly linked list after insertion is:
 */
public class InsertNodeSortedDoublyLL {

    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {

        DoublyLinkedListNode temp=head;
        DoublyLinkedListNode currentnode=new DoublyLinkedListNode(data);
        if(head.data>data)
        {
            currentnode.next=head;
            head=currentnode;
        }
        else
        {
            while(temp.next!=null && temp.data<data)
            {
                temp=temp.next;
            }
            if(temp.next==null && temp.data<data)
            {
                temp.next=currentnode;
                currentnode.prev=temp;
                return head;
            }
            else{
                currentnode.prev=temp.prev;
                currentnode.next=temp;
                currentnode.prev.next=currentnode;
                temp.prev=currentnode;
            }
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
