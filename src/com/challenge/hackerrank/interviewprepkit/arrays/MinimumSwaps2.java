package com.challenge.hackerrank.interviewprepkit.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given an unordered array consisting of consecutive integers  [1, 2, 3, ..., n] without any duplicates. You are allowed to swap any two elements. You need to find the minimum number of swaps required to sort the array in ascending order.
 * <p>
 * For example, given the array  we perform the following steps:
 * <p>
 * i   arr                     swap (indices)
 * 0   [7, 1, 3, 2, 4, 5, 6]   swap (0,3)
 * 1   [2, 1, 3, 7, 4, 5, 6]   swap (0,1)
 * 2   [1, 2, 3, 7, 4, 5, 6]   swap (3,4)
 * 3   [1, 2, 3, 4, 7, 5, 6]   swap (4,5)
 * 4   [1, 2, 3, 4, 5, 7, 6]   swap (5,6)
 * 5   [1, 2, 3, 4, 5, 6, 7]
 * It took  swaps to sort the array.
 *
 * @author shakil akhtar
 */
public class MinimumSwaps2 {

    static int minimumSwaps(int[] arr) {
        //create a index map of array elements
        Map<Integer, Integer> imap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            imap.put(arr[i], i);
        }

        int countMinSwaps = 0;
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] == index + 1)
                continue;
            else {
                int swappingIndex = imap.get(index + 1);
                int temp = arr[index];
                arr[index] = arr[swappingIndex];
                arr[swappingIndex] = temp;
                imap.put(index + 1, index);
                imap.put(arr[swappingIndex], swappingIndex);
                countMinSwaps++;
            }
        }

        return countMinSwaps;
    }

    public static void main(String[] args) {
        int[] a = {4, 3, 1, 2};
        int count=minimumSwaps(a);
        System.out.println(count);
    }
}
