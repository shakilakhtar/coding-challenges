package com.challenge.neetcode.linkedlist;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        final ListNode root  = new ListNode();
        ListNode temp = root;

        while (list1 != null && list2 != null){
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            }else {
                temp.next =  list2;
                list2 = list2.next;
            }
            temp =  temp.next;
        }
        //when lists are not of equal sizes
        temp.next = list1 != null ? list1 : list2;
        return root.next;
    }

    public static void main(String[] args) {

    }
}
