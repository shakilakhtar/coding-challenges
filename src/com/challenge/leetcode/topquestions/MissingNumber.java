package com.challenge.leetcode;

import java.util.Arrays;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 * Example 1:
 *
 * Input: [3,0,1]
 * Output: 2
 * Example 2:
 *
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 *
 * @author Shakil Akhtar on 17/12/19
 */
public class MissingNumber {
    public static int missingNumber(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int actual=0;
         for(int i=0;i<=nums.length;i++){
             actual+=i;
         }
         return actual-sum;
    }
    public static void main(String[] args) {
        int [] n={9,6,4,2,3,5,7,0,1};
        int missing = missingNumber(n);
        System.out.println(missing);
    }
}
