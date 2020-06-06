package com.challenge.hackerrank.interviewprepkit.search;

import java.util.*;

/**
 * We define the following:
 * <p>
 * A subarray of array  of length  is a contiguous segment from  through  where .
 * The sum of an array is the sum of its elements.
 * Given an  element array of integers, , and an integer, , determine the maximum value of the sum of any of its subarrays modulo . For example, Assume  and . The following table lists all subarrays and their moduli:
 * <p>
 * sum	%2
 * [1]		1	1
 * [2]		2	0
 * [3]		3	1
 * [1,2]		3	1
 * [2,3]		5	1
 * [1,2,3]		6	0
 * The maximum modulus is .
 * <p>
 * Function Description
 * <p>
 * Complete the maximumSum function in the editor below. It should return a long integer that represents the maximum value of .
 * <p>
 * maximumSum has the following parameter(s):
 * <p>
 * a: an array of long integers, the array to analyze
 * m: a long integer, the modulo divisor
 * Input Format
 * <p>
 * The first line contains an integer , the number of queries to perform.
 * <p>
 * The next  pairs of lines are as follows:
 * <p>
 * The first line contains two space-separated integers  and (long), the length of  and the modulo divisor.
 * The second line contains  space-separated long integers .
 * Constraints
 * <p>
 * the sum of  over all test cases
 * Output Format
 * <p>
 * For each query, return the maximum value of  as a long integer.
 * <p>
 * Sample Input
 * <p>
 * 1
 * 5 7
 * 3 3 9 9 5
 * Sample Output
 * <p>
 * 6
 * Explanation
 * <p>
 * The subarrays of array  and their respective sums modulo  are ranked in order of length and sum in the following list:
 * <p>
 * and
 * and
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * The maximum value for  for any subarray is .
 */
public class MaximumSubarraySum {

    static long maximumSum(long[] a, long m) {
        long maxSum = 0;

        TreeSet<Long> prefix = new TreeSet<Long>();
        long currSum = 0;

        for (int i = 0; i < a.length; i++) {
            currSum = (currSum + a[i] % m) % m;
            maxSum = Math.max(maxSum, currSum);

            Long pr = prefix.higher(currSum);
            if (pr != null) {
                maxSum = Math.max(maxSum, (currSum - pr + m) % m);
            }
            prefix.add(currSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {

    }
}
