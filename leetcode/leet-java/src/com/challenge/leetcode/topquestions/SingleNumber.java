package com.challenge.leetcode.topquestions;

import java.util.Arrays;
/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 *
 * @author Shakil Akhtar
 */
public class SingleNumber {
    public static  int singleNumber(int[] nums) {
        //Doing little different can be done using storage in O(n) time :)
        Arrays.sort(nums);
        //Considering if no single number then return -100
        int a=-100;
        for(int i=0;i<nums.length;i=i+2){
                if (i+1==nums.length){
                    a=nums[i];
                }
                else if (nums[i] != nums[i + 1]) {
                    a= nums[i];
                    break;
                }
                else {

                }
        }
        return a;
    }

    public static void main(String[] args) {
        int [] a= {4,1,2,1,2};
        int singleNum = singleNumber(a);
        System.out.println(singleNum);
    }
}
