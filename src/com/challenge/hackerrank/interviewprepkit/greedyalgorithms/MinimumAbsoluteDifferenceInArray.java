package com.challenge.hackerrank.interviewprepkit.greedyalgorithms;

import java.util.*;

/**
 * Consider an array of integers, . We define the absolute difference between two elements,  and  (where ), to be the absolute value of .
 * <p>
 * Given an array of integers, find and print the minimum absolute difference between any two elements in the array. For example, given the array  we can create  pairs of numbers:  and . The absolute differences for these pairs are ,  and . The minimum absolute difference is .
 * <p>
 * Function Description
 * <p>
 * Complete the minimumAbsoluteDifference function in the editor below. It should return an integer that represents the minimum absolute difference between any pair of elements.
 * <p>
 * minimumAbsoluteDifference has the following parameter(s):
 * <p>
 * n: an integer that represents the length of arr
 * arr: an array of integers
 * Input Format
 * <p>
 * The first line contains a single integer , the size of .
 * The second line contains  space-separated integers .
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * Print the minimum absolute difference between any two elements in the array.
 * <p>
 * Sample Input 0
 * <p>
 * 3
 * 3 -7 0
 * Sample Output 0
 * <p>
 * 3
 * Explanation 0
 * <p>
 * With  integers in our array, we have three possible pairs: , , and . The absolute values of the differences between these pairs are as follows:
 * <p>
 * Notice that if we were to switch the order of the numbers in these pairs, the resulting absolute values would still be the same. The smallest of these possible absolute differences is .
 * <p>
 * Sample Input 1
 * <p>
 * 10
 * -59 -36 -13 1 -53 -92 -2 -96 -54 75
 * Sample Output 1
 * <p>
 * 1
 * Explanation 1
 * <p>
 * The smallest absolute difference is .
 * <p>
 * Sample Input 2
 * <p>
 * 5
 * 1 -3 71 68 17
 * Sample Output 2
 * <p>
 * 3
 * Explanation 2
 * <p>
 * The minimum absolute difference is .
 *
 * @author shakil akhtar
 */
public class MinimumAbsoluteDifferenceInArray {

    /**
     * Method 2 reduced complexity
     *    O(nlogn)+O(n)
     * @param arr
     * @return
     */
    static int minimumAbsoluteDifference(int[] arr) {
        int minAbsDiff = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            int diff = Math.abs(arr[i] - arr[i + 1]);
            if (diff < minAbsDiff) {
                minAbsDiff = diff;
            }
        }
        return minAbsDiff;
    }

    /**
     * Method 1 will take O(n2)
     *
     * @param arr
     * @return
     */
    static int minimumAbsoluteDifferenceBruteForce(int[] arr) {
        int minAbsDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int diff = Math.abs(arr[i] - arr[j]);
                if (diff < minAbsDiff) {
                    minAbsDiff = diff;
                }
            }
        }
        return minAbsDiff;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, -7, 0};
        int m = minimumAbsoluteDifference(a);
        System.out.println(m);
    }
}
