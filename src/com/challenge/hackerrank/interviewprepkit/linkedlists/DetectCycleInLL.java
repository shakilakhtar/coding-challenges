package com.challenge.hackerrank.interviewprepkit.linkedlists;

/**
 * A linked list is said to contain a cycle if any node is visited more than once while traversing the list. For example, in the following graph there is a cycle formed when node  points back to node .
 * <p>
 * image
 * <p>
 * Function Description
 * <p>
 * Complete the function has_cycle in the editor below. It must return a boolean true if the graph contains a cycle, or false.
 * <p>
 * has_cycle has the following parameter(s):
 * <p>
 * : a pointer to a Node object that points to the head of a linked list.
 * Note: If the list is empty,  will be null.
 * <p>
 * Input Format
 * <p>
 * There is no input for this challenge. A random linked list is generated at runtime and passed to your function.
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * If the list contains a cycle, your function must return true. If the list does not contain a cycle, it must return false. The binary integer corresponding to the boolean value returned by your function is printed to stdout by our hidden code checker.
 * <p>
 * Sample Input
 * <p>
 * The following linked lists are passed as arguments to your function:
 * <p>
 * image
 * image
 * <p>
 * Sample Output
 * <p>
 * 0
 * 1
 * Explanation
 * <p>
 * The first list has no cycle, so we return false and the hidden code checker prints  to stdout.
 * The second list has a cycle, so we return true and the hidden code checker prints  to stdout.
 */
public class DetectCycleInLL {

    boolean hasCycle(SinglyLinkedListNode head) {
        if (head == null) return false;

        SinglyLinkedListNode slow = head;
        SinglyLinkedListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) return false;

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
