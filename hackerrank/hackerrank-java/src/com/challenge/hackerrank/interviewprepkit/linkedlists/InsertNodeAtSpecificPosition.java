package com.challenge.hackerrank.interviewprepkit.linkedlists;

/**
 * This challenge is part of a tutorial track by MyCodeSchool and is accompanied by a video lesson.
 * <p>
 * You’re given the pointer to the head node of a linked list, an integer to add to the list and the position at which the integer must be inserted. Create a new node with the given integer, insert this node at the desired position and return the head node.
 * <p>
 * A position of 0 indicates head, a position of 1 indicates one node away from the head and so on. The head pointer given may be null meaning that the initial list is empty.
 * <p>
 * As an example, if your list starts as  and you want to insert a node at position  with , your new list should be
 * <p>
 * Function Description Complete the function insertNodeAtPosition in the editor below. It must return a reference to the head node of your finished list.
 * <p>
 * insertNodeAtPosition has the following parameters:
 * <p>
 * head: a SinglyLinkedListNode pointer to the head of the list
 * data: an integer value to insert as data in your new node
 * position: an integer position to insert the new node, zero based indexing
 * Input Format
 * <p>
 * The first line contains an integer , the number of elements in the linked list.
 * Each of the next  lines contains an integer SinglyLinkedListNode[i].data.
 * The next line contains an integer  denoting the data of the node that is to be inserted.
 * The last line contains an integer .
 * <p>
 * Constraints
 * <p>
 * , where  is the  element of the linked list.
 * .
 * Output Format
 * <p>
 * Return a reference to the list head. Locked code prints the list for you.
 * <p>
 * Sample Input
 * <p>
 * 3
 * 16
 * 13
 * 7
 * 1
 * 2
 * Sample Output
 * <p>
 * 16 13 1 7
 * Explanation
 * <p>
 * The initial linked list is 16 13 7. We have to insert  at the position  which currently has  in it. The updated linked list will be 16 13 1 7
 */
public class InsertNodeAtSpecificPosition {
    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        //create node from data
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

        //if head is null
        if (head == null) {
            return newNode;
        }

        //If only head is there
        SinglyLinkedListNode newHead = head;
        if (position == 0) {
            newNode.next = head;
            newHead.next = newNode;
            return newHead;
        }
        int count = 0;
        SinglyLinkedListNode current = head;
        while (count != position - 1) {
            current = current.next;
            count++;
        }
        newNode.next = current.next;
        current.next = newNode;
        return head;
    }


    public static void main(String[] args) {

        SinglyLinkedListNode head = new SinglyLinkedListNode(16);
        SinglyLinkedListNode n2 = new SinglyLinkedListNode(13);
        SinglyLinkedListNode n3 = new SinglyLinkedListNode(7);
        head.next = n2;
        n2.next = n3;
        n3.next = null;
        int data = 1;
        int position = 2;
        SinglyLinkedListNode newHead = insertNodeAtPosition(head, data, position);


    }
}
