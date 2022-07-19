package com.challenge.leetcode.highfreqency;

import com.challenge.leetcode.topquestions.ListNode;

import java.util.PriorityQueue;

/**
 * 23. Merge k Sorted Lists
 *
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 *
 *
 * Example 1:
 *
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * Example 2:
 *
 * Input: lists = []
 * Output: []
 * Example 3:
 *
 * Input: lists = [[]]
 * Output: []
 *
 *
 * Constraints:
 *
 * k == lists.length
 * 0 <= k <= 104
 * 0 <= lists[i].length <= 500
 * -104 <= lists[i][j] <= 104
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length will not exceed 104.
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                (a,b)->a.val -b.val
        );
       for (ListNode e:lists){
           if (e!=null){
               pq.add(e);
           }
       }
       ListNode dummy = new ListNode(0);
        ListNode output = dummy;
        while (!pq.isEmpty()){
            ListNode current = pq.poll();
            dummy.next=current;
            current=current.next;
            dummy=dummy.next;
            if (current!=null){
                pq.add(current);
            }
        }
    return output.next;
    }
}
