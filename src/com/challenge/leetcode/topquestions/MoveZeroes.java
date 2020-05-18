package com.challenge.leetcode;
/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *
 * @author Shakil Akhtar
 */
public class MoveZeroes{
    public static void moveZeroes(int[] nums) {
        int nonZeroPointer=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                int temp=nums[nonZeroPointer];
                nums[nonZeroPointer]=nums[i];
                nums[i]=temp;
                nonZeroPointer++;
            }
        }
        for (int i:nums){
            System.out.print(i+" ");
        }
    }

    public static void main(String[] args) {
        int [] a={0,1,0,3,12};
        moveZeroes(a);
    }
}
