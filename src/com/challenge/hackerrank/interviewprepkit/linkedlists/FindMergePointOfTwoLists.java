package com.challenge.hackerrank.interviewprepkit.linkedlists;

/**
 * Given pointers to the head nodes of  linked lists that merge together at some point, find the Node where the two lists merge. It is guaranteed that the two head Nodes will be different, and neither will be NULL.
 * <p>
 * In the diagram below, the two lists converge at Node x:
 * <p>
 * [List #1] a--->b--->c
 * \
 * x--->y--->z--->NULL
 * /
 * [List #2] p--->q
 * Complete the int findMergeNode(SinglyLinkedListNode* head1, SinglyLinkedListNode* head2) method so that it finds and returns the data value of the Node where the two lists merge.
 * <p>
 * Input Format
 * <p>
 * Do not read any input from stdin/console.
 * <p>
 * The findMergeNode(SinglyLinkedListNode,SinglyLinkedListNode) method has two parameters,  and , which are the non-null head Nodes of two separate linked lists that are guaranteed to converge.
 * <p>
 * Constraints
 * <p>
 * The lists will merge.
 * .
 * .
 * <p>
 * Output Format
 * <p>
 * Do not write any output to stdout/console.
 * <p>
 * Each Node has a data field containing an integer. Return the integer data for the Node where the two lists merge.
 * <p>
 * Sample Input
 * <p>
 * The diagrams below are graphical representations of the lists that input Nodes  and  are connected to. Recall that this is a method-only challenge; the method only has initial visibility to those  Nodes and must explore the rest of the Nodes using some algorithm of your own design.
 * <p>
 * Test Case 0
 * <p>
 * 1
 * \
 * 2--->3--->NULL
 * /
 * 1
 * Test Case 1
 * <p>
 * 1--->2
 * \
 * 3--->Null
 * /
 * 1
 * Sample Output
 * <p>
 * 2
 * 3
 * Explanation
 * <p>
 * Test Case 0: As demonstrated in the diagram above, the merge Node's data field contains the integer .
 * Test Case 1: As demonstrated in the diagram above, the merge Node's data field contains the integer .
 */
public class FindMergePointOfTwoLists {
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode currentA = head1;
        SinglyLinkedListNode currentB = head2;

        //Do till the two nodes are the same
        while (currentA != currentB) {
            //If you reached the end of one list start at the beginning of the other one
            //currentA
            if (currentA.next == null) {
                currentA = head2;
            } else {
                currentA = currentA.next;
            }
            //currentB
            if (currentB.next == null) {
                currentB = head1;
            } else {
                currentB = currentB.next;
            }
        }
        return currentB.data;

    }

    public static void main(String[] args) {

    }
}
