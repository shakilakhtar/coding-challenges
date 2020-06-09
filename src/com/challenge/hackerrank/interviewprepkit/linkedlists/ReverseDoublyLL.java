package com.challenge.hackerrank.interviewprepkit.linkedlists;

/**
 * This challenge is part of a tutorial track by MyCodeSchool
 * <p>
 * You’re given the pointer to the head node of a doubly linked list. Reverse the order of the nodes in the list. The head node might be NULL to indicate that the list is empty. Change the next and prev pointers of all the nodes so that the direction of the list is reversed. Return a reference to the head node of the reversed list.
 * <p>
 * Function Description
 * <p>
 * Complete the reverse function in the editor below. It should return a reference to the head of your reversed list.
 * <p>
 * reverse has the following parameter(s):
 * <p>
 * head: a reference to the head of a DoublyLinkedList
 * Input Format
 * <p>
 * The first line contains an integer , the number of test cases.
 * <p>
 * Each test case is of the following format:
 * <p>
 * The first line contains an integer , the number of elements in the linked list.
 * The next  lines contain an integer each denoting an element of the linked list.
 * Constraints
 * <p>
 * Output Format
 * <p>
 * Return a reference to the head of your reversed list. The provided code will print the reverse array as a one line of space-separated integers for each test case.
 * <p>
 * Sample Input
 * <p>
 * 1
 * 4
 * 1
 * 2
 * 3
 * 4
 * Sample Output
 * <p>
 * 4 3 2 1
 * Explanation
 * <p>
 * The initial doubly linked list is:
 * <p>
 * The reversed doubly linked list is:
 */
public class ReverseDoublyLL {

    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {

        DoublyLinkedListNode temp = head;
        DoublyLinkedListNode newHead = head;
        while (temp != null) {
            DoublyLinkedListNode prev = temp.prev;
            temp.prev = temp.next;
            temp.next = prev;
            newHead = temp;
            temp = temp.prev;
        }
        return newHead;
    }

    public static void main(String[] args) {

    }
}
