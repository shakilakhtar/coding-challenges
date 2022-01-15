package com.challenge.hackerrank.interviewprepkit.dp;

/**
 * Given an array of integers, find the subset of non-adjacent elements with the maximum sum. Calculate the sum of that subset.
 * <p>
 * For example, given an array  we have the following possible subsets:
 * <p>
 * Subset      Sum
 * [-2, 3, 5]   6
 * [-2, 3]      1
 * [-2, -4]    -6
 * [-2, 5]      3
 * [1, -4]     -3
 * [1, 5]       6
 * [3, 5]       8
 * Our maximum subset sum is .
 * <p>
 * Function Description
 * <p>
 * Complete the  function in the editor below. It should return an integer representing the maximum subset sum for the given array.
 * <p>
 * maxSubsetSum has the following parameter(s):
 * <p>
 * arr: an array of integers
 * Input Format
 * <p>
 * The first line contains an integer, .
 * The second line contains  space-separated integers .
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * Return the maximum sum described in the statement.
 * <p>
 * Sample Input 0
 * <p>
 * 5
 * 3 7 4 6 5
 * Sample Output 0
 * <p>
 * 13
 * Explanation 0
 * <p>
 * Our possible subsets are  and . The largest subset sum is  from subset
 * <p>
 * Sample Input 1
 * <p>
 * 5
 * 2 1 5 8 4
 * Sample Output 1
 * <p>
 * 11
 * Explanation 1
 * <p>
 * Our subsets are  and . The maximum subset sum is  from the first subset listed.
 *
 * @author shakil akhtar
 */
public class MaxArraySum {

    static int maxSubsetSum(int[] arr) {
        int sum = arr[0];
        int temp = 0;
        int maxSum;

        for (int i = 1; i < arr.length; i++) {
            maxSum = Math.max(temp, sum);
            sum = temp + arr[i];
            temp = maxSum;
        }

        return Math.max(temp, sum);
    }

    static int maxSubsetSum2(int[] arr) {
        int maxSum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j = j + 2) {
                sum = sum + arr[j];
            }

            if (maxSum <= sum) {
                maxSum = sum;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] a = {3, 5, -7, 8, 10};

        int maxSum = maxSubsetSum(a);
        System.out.println(maxSum);
    }
}
